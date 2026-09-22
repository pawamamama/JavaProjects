package com.pawamamama.qqserver.service;

import com.pawamamama.qqcommon.Message;
import com.pawamamama.qqcommon.MessageType;
import com.pawamamama.qqcommon.User;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Class: QQServer
 *
 * <pre>服务端-监听端口等待客户端的连接并保持通讯
 * </pre>
 *
 * @author pawamamama
 * @date 2026/9/21
 */
@SuppressWarnings({"all"})
public class QQServer {
    private ServerSocket ss = null;
    //创建一个集合，存放多个用户，这些用户登录认为合法
    //这里也可以使用ConcurrentHashMap可以处理并发的集合，没有线程安全问题，这里只读可以不用
    private static HashMap<String, User> validUsers = new HashMap<>();
    //类加载时x会加载静态代码快
    static {//初始化 validUsers
        validUsers.put("100",new User("100","123456"));
        validUsers.put("200",new User("200","123456"));
        validUsers.put("300",new User("300","123456"));
        validUsers.put("至尊宝",new User("至尊宝","123456"));
        validUsers.put("紫霞仙子",new User("紫霞仙子","123456"));
        validUsers.put("菩提老祖",new User("菩提老祖","123456"));
    }
    //验证用户是否有效的方法
    private static boolean checkUser(String userId,String UserPwd){
         User user = validUsers.get(userId);
         if (user == null){//没有存在与集合中
             return false;
         }
         if (!user.getPrasswd().equals(UserPwd)){

             return false;
         }
         return true;//通过
    }
    public QQServer() {
        //端口可以写在一个配置文件中
        System.out.println("服务端在9999端口监听");
        try {
            ss = new ServerSocket(9999);
            //监听工作是一直循环的，当和某个客户端建立连接后，会继续监听
            while (true) {
                Socket socket = ss.accept();
                //得到socket关联的对象输入流
                ObjectInputStream ois =
                        new ObjectInputStream(socket.getInputStream());
                //先创建一个输出流用于写出msg对象
                ObjectOutputStream oos =
                        new ObjectOutputStream(socket.getOutputStream());
                //第一次发过来的一定是一个User对象
                User u = (User) ois.readObject();
                //实际上后台是有一个数据库去验证id pwd，这里用集合
                //写一个message对象,准备回复客户端的消息，登录成败与否都要回送消息
                Message message = new Message();
                //写一个验证用户的方法
                if (checkUser(u.getUserId(),u.getPrasswd())) {//合法用户
                    //设置登录成功
                    message.setMesType(MessageType.MESSAGE_LOGIN_SUCCEED);
                    //给连接的客户端发送Message对象
                    oos.writeObject(message);
                    //创建一个线程和客户端保持通讯，该线程需要持有socket对象
                    final ServerConnectClientThread serverConnectClientThread
                            = new ServerConnectClientThread(socket, u.getUserId());
                    //启动该线程
                    serverConnectClientThread.start();
                    //把该线程对象放入到集合中管理
                    ManageClientThreads.
                            addClientThread(u.getUserId(), serverConnectClientThread);

                } else {//登录失败
                    //设置消息
                    System.out.println("登录失败 用户名：" + u.getUserId()
                            + "密码：" + u.getPrasswd() );
                    message.setMesType(MessageType.MESSAGE_LOGIN_FAIL);
                    oos.writeObject(message);//发送
                    //登录失败要关闭socket
                    socket.close();
                }
            }
            //扩大范围
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            //如果服务端退出了while循环说明服务端不在监听因此需要关闭资源
            try {
                ss.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}