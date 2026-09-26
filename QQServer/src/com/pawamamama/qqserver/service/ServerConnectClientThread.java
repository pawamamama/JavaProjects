package com.pawamamama.qqserver.service;

import com.pawamamama.qqcommon.Message;
import com.pawamamama.qqcommon.MessageType;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;

/**
 * Class: ServerConnectClientTherad
 *
 * <pre>该线程用于 服务端socket 和 客户端保持通讯，必须持有服务端socket
 * </pre>
 *
 * @author pawamamama
 * @date 2026/9/21
 */
@SuppressWarnings({"all"})
public class ServerConnectClientThread extends Thread {
    private Socket socket;
    //需要知道服务端和谁通信的，所以要用户id
    private String userId;

    public ServerConnectClientThread(Socket socket, String userId) {
        this.socket = socket;
        this.userId = userId;
    }

    public Socket getSocket() {
        return socket;
    }

    @Override
    public void run() {//线程处于run ，可以发送接收消息
        while (true) {
            System.out.println("服务端和客户端" + userId + "保持通讯，读取数据");
            try {
                ObjectInputStream ois =
                        new ObjectInputStream(socket.getInputStream());
                Message message = (Message) ois.readObject();
                //后面会使用message 根据类型做处理
                if (message.getMesType().equals(MessageType.MESSAGE_GET_ONLINE_FRIEND)) {
                    //客户端要在线用户列表
                    System.out.println(message.getSender() + " 该用户要在线用户列表");
                    //向管理socket的类要在线用户
                    final String onlineUser = ManageClientThreads.getOnlineUser();
                    //准备发送给服务器，用message返回
                    final Message message1 = new Message();
                    //客户端要检查类型，设置成
                    message1.setMesType(MessageType.MESSAGE_RET_ONLINE_FRIEND);
                    message1.setContent(onlineUser);//信息写入
                    //设置接收者是谁，是上面回信的消息的发送者
                    message1.setGetter(message.getSender());
                    //写入到数据通道
                    final ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
                    oos.writeObject(message1);
                } else if (message.getMesType().equals(MessageType.MESSAGE_TO_ALL_MES)) {//群发消息
                    //取出所有在线用户的线程类
                    //获取线程
                    final HashMap<String, ServerConnectClientThread> hm = ManageClientThreads.getHm();
                    //遍历所有线程，排除发送人
                    for (Map.Entry<String, ServerConnectClientThread> entry : hm.entrySet()) {
                        //是发送者就跳出过这次发送
                        if (entry.getKey().equals(message.getSender())) {
                            continue;
                        }
                        //通过集合中存放的value 得到所有在线用户的输出流，并转发该消息
                        final ObjectOutputStream oos
                                //先获取socket再获取输出流
                                = new ObjectOutputStream(entry.getValue().getSocket().getOutputStream());
                        //转发消息给接收者
                        oos.writeObject(message);//如果客户不在线，可以保存到数据库，可以实现离线留言，上线再发送
                    }
                } else if (message.getMesType().equals(MessageType.MESSAGE_COMM_MES)) {//普通私聊
                    //转发消息
                    //根据对应message获取getterId，得到对应线程
                    final ServerConnectClientThread scct =
                            ManageClientThreads.getServerConnectClientThread(message.getGetter());
                    //通过线程获取对应的对象输出流，将message对象转发给指定的客户端
                    final ObjectOutputStream oos
                            //先获取socket再获取输出流
                            = new ObjectOutputStream(scct.getSocket().getOutputStream());
                    //转发消息给接收者
                    oos.writeObject(message);//如果客户不在线，可以保存到数据库，可以实现离线留言，上线再发送

                } else if (message.getMesType().equals(MessageType.MESSAGE_CLIENT_EXIT)) {//客户端退出
                    System.out.println(message.getSender() + " 退出客户端");
                    //修复服务端eof异常
                    sleep(1);
                    //将客户端对应线程从集合中删除
                    ManageClientThreads.removeClientThread(userId);
                    socket.close();//关闭该线程持有的socket，其他的不受影响，多线程编程
                    //退出线程
                    break;//退出外循环
                } else {
                    System.out.println("其他类型");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }


}