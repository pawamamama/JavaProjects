package com.pawamamama.qqclient.service;

import com.pawamamama.qqcommon.Message;

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