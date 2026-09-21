package com.pawamamama.qqserver.service;

import com.pawamamama.qqcommon.Message;

import java.io.IOException;
import java.io.ObjectInputStream;
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
            System.out.println("服务端和客户端保持通讯，读取数据");
            try {
                ObjectInputStream ois =
                        new ObjectInputStream(socket.getInputStream());
                Message message = (Message) ois.readObject();
                //后面会使用
             } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }


}