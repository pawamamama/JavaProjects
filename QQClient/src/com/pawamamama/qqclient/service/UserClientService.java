package com.pawamamama.qqclient.service;

import com.pawamamama.qqcommon.Message;
import com.pawamamama.qqcommon.MessageType;
import com.pawamamama.qqcommon.User;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * Class: UserClientService
 *
 * <pre>该类完成用户登录验证和用户注册等功能
 * 使用User类保存用户信息
 * Message 通信使用的对象
 * MessageType负责登录认证功能
 * </pre>
 *
 * @author pawamamama
 * @date 2026/9/20
 */
@SuppressWarnings({"all"})
public class UserClientService {
    //
    boolean b = false;
    private User u = new User();//可能要在其他地方使用user信息
    private Socket socket;

    //根据userId 和 userPwd 到服务器验证该用户是否合法
    public boolean checkUser(String userId, String userPwd) {
        //创建User对象
        u.setUserId(userId);
        u.setPrasswd(userPwd);
        //连接到服务器发送u对象
        try {
            socket = new Socket(InetAddress.getByName("127.0.0.1"), 9999);
            //得到对象流->发送到服务器
            final ObjectOutputStream oos =
                    // Socket输出流包装为对象输出流
                    new ObjectOutputStream(socket.getOutputStream());
            //序列化成byte发送
            oos.writeObject(u);//把用户信息对象发送过去了
            //===============================================================
            //===============================================================
            //===============================================================
            //读取服务端回送的Message对象
            final ObjectInputStream ois =
                    // Socket输入流包装为对象输入流
                    new ObjectInputStream(socket.getInputStream());
            //反序列化得到服务器回送的消息
            Message ms = (Message) ois.readObject();
            //判断登录
            if (ms.getMesType().equals(MessageType.MESSAGE_LOGIN_SUCCEED)) {//登录成功
                //发起一个线程，让线程持有socket
                // 让该线程保持和服务端通信-> 线程类（ClientConnectServerThread）客户端连接服务器线程
                //启动线程
                final ClientConnectServerThread ccst = new ClientConnectServerThread(socket);
                ccst.start();
                //这里为了扩展放到一个集合中管理
                ManageClientServerThread.addClilentServerThread(userId, ccst);
                //登录成功
                b = true;
            } else {//登录失败，就不能启动和服务器通讯的线程，所以要关闭socket
                socket.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return b;//如果到这里就是登录失败直接返回false
    }

    //向服务器端请求在线用户列表
    public void onlineFriendList() {
        //发送一个Message
        Message message = new Message();
        message.setMesType(MessageType.MESSAGE_GET_ONLINE_FRIEND);
        //设置发送者
        message.setSender(u.getUserId());
        //发送给服务器
        try {
            //获取到当前线程的Socket
            ObjectOutputStream oos =
                    new ObjectOutputStream(
                            //先从管理线程的集合类获取到持有该Socket的线程，然后获取socket,在从socket中拿出输出流
                            ManageClientServerThread.getClilentServerThread(u.getUserId())
                                    .getSocket().getOutputStream());
            oos.writeObject(message);//发送

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    //编写方法退出客户端，并给服务端发送一个退出系统的massage
    public void logout() {
        final Message message = new Message();
        //设置消息类型
        message.setMesType(MessageType.MESSAGE_CLIENT_EXIT);
        //设置发送者
        message.setSender(u.getUserId());//指定哪个客户端，要删除集合
        try {
            //发送
            final ObjectOutputStream oos =
                    new ObjectOutputStream(socket.getOutputStream());
            //还可以
            /*new ObjectOutputStream(ManageClientServerThread.
            getClilentServerThread(u.getUserId()).getSocket().
            getOutputStream()).writeObject(message);*/
            //不过太长了
            oos.writeObject(message);
            System.out.println(u.getUserId()+" 退出了系统");
            System.exit(0);//结束进程
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}