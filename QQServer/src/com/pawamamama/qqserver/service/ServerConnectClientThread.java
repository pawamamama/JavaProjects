package com.pawamamama.qqserver.service;

import com.pawamamama.qqcommon.Message;
import com.pawamamama.qqcommon.MessageType;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

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
    public  ServerConnectClientThread(Socket socket, String userId) {
        this.socket = socket;
        this.userId = userId;
    }
    @Override
    public void run() {//线程处于run ，可以发送接收消息
        while (true) {
            System.out.println("服务端和客户端"+ userId + "保持通讯，读取数据");
            try {
                ObjectInputStream ois =
                        new ObjectInputStream(socket.getInputStream());
                Message message = (Message) ois.readObject();
                //后面会使用message 根据类型做处理
                if (message.getMesType().equals(MessageType.MESSAGE_GET_ONLINE_FRIEND)) {
                    //客户端要在线用户列表
                    System.out.println(message.getSender() + " 该用户要在线用户列表");
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
                }else {
                    System.out.println("其他类型的message");
                }
             } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }


}