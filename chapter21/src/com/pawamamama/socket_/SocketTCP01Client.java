package com.pawamamama.socket_;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.nio.charset.StandardCharsets;

/**
 * Class: SocketTCP01Client
 *
 * <pre>客户端
 * 1.连接服务端（ip，端口）
 * 2.连接上生成socket，通过字节输出流 socket.getOutputStream()
 * 3.写入到数据通道
 * </pre>
 *
 * @author pawamamama
 * @date 2026/9/5
 */
@SuppressWarnings({"all"})
public class SocketTCP01Client {
    public static void main(String[] args) throws IOException {
        //连接本机的 9999 端口号
        Socket socket = new Socket(InetAddress.getLocalHost(), 9999);
        System.out.println("客户端  socket accepted" +  socket.getClass() );
        //发送 hello server
        //得到 和 socket 关联的输出流对象
        OutputStream outputStream = socket.getOutputStream();
        //写入
        outputStream.write("hello server".getBytes());
        //关闭流对象和socket
        outputStream.close();
        socket.close();
        System.out.println("客户端退出");

    }

}