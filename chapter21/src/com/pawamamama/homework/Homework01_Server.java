package com.pawamamama.homework;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Class: homework01
 *
 * <pre>
 * </pre>
 *
 * @author pawamamama
 * @date 2026/9/17
 */
@SuppressWarnings({""})
public class Homework01_Server {
    public static void main(String[] args) throws IOException {
        //1.客户端设置
        ServerSocket serverSocket = new ServerSocket(9999);
        //2.获取socket,accept阻断状态
        Socket socket = serverSocket.accept();
        //3.获取流
        InputStream inputStream = socket.getInputStream();

        //设置字节数组读取内容
        byte[] buffer = new byte[1024];
        int len = 0;
        String s = "";
        while ((len = inputStream.read(buffer)) != -1) {
            s = new String(buffer, 0, len);//根据读取到的长度显示字符串
            //待优化,因为是一次读1024字节，可以使用字符串拼接
            System.out.println("服务器接收到客户端  = " + s );
        }
        //
        String reply = "";
        switch (s) {
            case "name":
                //回送名字
                reply = "nova";
                break;
            case "hobby":
                //回送编写java程序
                reply = "编写java程序";
                break;
            default:
                //你在说啥
                reply = "你在说啥";
                break;
        }
        new Homework01_Server().sendMessage(socket, reply);
        socket.close();
        serverSocket.close();


    }

    //写一个方法专门发送信息，要求是传入一个字符串
    private void sendMessage(Socket socket, String s) throws IOException {
        //获取输出流
        final OutputStream outputStream = socket.getOutputStream();
        outputStream.write(s.getBytes());
        socket.shutdownOutput();
        outputStream.close();
        //最后再关流，方法使用完成之后jvm 垃圾回收
    }
}