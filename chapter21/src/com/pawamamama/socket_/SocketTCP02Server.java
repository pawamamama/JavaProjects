package com.pawamamama.socket_;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Class: SocketTCP01Server
 *
 * <pre>socket 服务端
 * 1.在本机的9999端口监听，等待连接
 * 2.当没有客户端连接9999端口时，程序会阻塞，等待连接
 * 3.通过socket.getIntputStream() 读取客户端写入到数据通道的数据，并显示
 *
 * </pre>
 *
 * @author pawamamama
 * @date 2026/9/5
 */
@SuppressWarnings({"all"})
public class SocketTCP02Server {
    public static void main(String[] args) throws IOException {
        //细节要求9999端口没有被占用，没有其他服务
        ServerSocket serverSocket = new ServerSocket(9999);
        Socket socket = serverSocket.accept();//会阻塞，等待连接
        //细节serverSocket通过accept方法返回多个socket（多并发）
        System.out.println("服务端socket accepted" +  socket.getClass() );
        //获取输入流
        //读取不到会阻塞在这里，一直等到有输入流流入
        InputStream inputStream = socket.getInputStream();
        //读取
        byte[] buf = new byte[1024];
        int len = 0;
        while ((len = inputStream.read(buf)) != -1) {
            String s = new String(buf, 0, len);//根据读取到的长度显示字符串
            System.out.println(s);
        }
        //5.回送消息
        //5.1 得到输出流给客户端，写入数据到通道
        OutputStream outputStream = socket.getOutputStream();
        outputStream.write("hello Client".getBytes());//写入数据
        //结束标记
        socket.shutdownOutput();
        //关闭流和socket
        socket.close();
        serverSocket.close();//服务端口关闭
        inputStream.close();
        //关闭输入流
        outputStream.close();

    }
}