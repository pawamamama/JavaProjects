package com.pawamamama.qqclient.service;

import com.pawamamama.qqcommon.Message;
import com.pawamamama.qqcommon.MessageType;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;

/**
 * Class: ClientConnectServerThread
 *
 * <pre>客户端连接服务器线程，后台待命接收从服务器发来的消息
 * </pre>
 *
 * @author pawamamama
 * @date 2026/9/20
 */
@SuppressWarnings({"all"})
public class ClientConnectServerThread extends  Thread{
    //该线程需要持有Socket
    private Socket socket;
    //构造器可以接收一个Socket
    public  ClientConnectServerThread(Socket socket){
        this.socket = socket;
    }
    @Override
    public void  run(){
        //因为Thread需要在后台和服务器通讯，因此我们做成一个while循环
        while (true){
            try {
                System.out.println("客户端线程，等待读取从服务器端发送的消息");
                //一直读取
                final ObjectInputStream ois =
                        new ObjectInputStream(socket.getInputStream());
                //反序列化，如果通道里没有对象传输过来会一直阻塞在这里
                Message message = (Message) ois.readObject();//阻塞
                //后面我们去使用这个message
                //判断类型
                //如果是读取到的是服务端返回的好友在线用户列表
                if (message.getMesType().equals(MessageType.MESSAGE_RET_ONLINE_FRIEND)) {
                    //取出在线列表，并显示
                    //规定列表形式
                    //服务端用空格隔开发送
                    //100 200 紫霞仙子
                    //客户端用空格分割
                     String[] onlineUser = message.getContent().split(" ");
                    System.out.println("\t\t========== 当前用户列表 ==========");
                    //取出列表
                    for (String user : onlineUser) {
                        System.out.println(user);
                    }
                } else {
                    System.out.println("其他类型暂时不处理");
                }

             } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    //为了更方便得到Socket
    public Socket getSocket() {
        return socket;
    }
}