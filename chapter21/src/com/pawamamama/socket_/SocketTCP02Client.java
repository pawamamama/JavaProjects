package com.pawamamama.socket_;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;

/**
 * Class: SocketTCP01Client
 *
 * <pre>客户端
 * 1.连接服务端（ip，端口）
 * 2.连接上生成socket，通过字节输出流 socket.getOutputStream()
 * 3.写入到数据通道
 * 接收服务端的回信
 * //发送完之后添加一个结束标记
 * </pre>
 *
 * @author pawamamama
 * @date 2026/9/5
 */
@SuppressWarnings({"all"})
public class SocketTCP02Client {
    public static void main(String[] args) throws IOException {
        //连接本机的 9999 端口号
        Socket socket = new Socket(InetAddress.getLocalHost(), 9999);
        System.out.println("客户端  socket accepted" +  socket.getClass() );
        //发送 hello server
        //得到 和 socket 关联的输出流对象
        OutputStream outputStream = socket.getOutputStream();
        //写入
        outputStream.write("hello server".getBytes());
        //结束标记
        socket.shutdownOutput();
        //接收回信
        //获取输入流，读取数据并显示
        InputStream inputStream = socket.getInputStream();
        byte[] buffer = new byte[1024];
        int len = 0;
        while ((len = inputStream.read(buffer)) != -1) {
            System.out.println(new String(buffer, 0, len));
        }
        //关闭流对象和socket
        outputStream.close();
        socket.close();
        inputStream.close();
        System.out.println("客户端退出");

    }

}