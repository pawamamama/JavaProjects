package com.pawamamama.homework;

import java.io.IOException;
import java.io.InputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * Class: homework01_Cilent
 *
 * <pre>
 * </pre>
 *
 * @author pawamamama
 * @date 2026/9/17
 */
@SuppressWarnings({"all"})
public class homework01_Cilent {
    public static void main(String[] args) throws IOException {
        //1.连接服务器
        Socket socket = new Socket(InetAddress.getLocalHost(), 9999);
        //2.获取流 发送消息
        socket.getOutputStream().write("hobby".getBytes());
        //结束标记
        socket.shutdownOutput();
        //接收消息
        InputStream inputStream = socket.getInputStream();
        //设置字节数组读取内容
        byte[] buffer = new byte[1024];
        int len = 0;
        String s = "";
        while ((len = inputStream.read(buffer)) != -1) {
            s = new String(buffer, 0, len);//根据读取到的长度显示字符串
            System.out.println( "服务器回送 " + s);
        }
        //关流
        socket.close();
    }

}