package com.pawamamama.socket_;

import java.io.*;
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
public class SocketTCP03Client {
    public static void main(String[] args) throws IOException {
        //连接本机的 9999 端口号
        Socket socket = new Socket(InetAddress.getLocalHost(), 9999);
        System.out.println("客户端  socket accepted" +  socket.getClass() );
        //发送 hello server
        //得到 和 socket 关联的输出流对象
        OutputStream outputStream = socket.getOutputStream();
        //写入，使用字符流
        //转换流
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream));
        bufferedWriter.write("hello server 字符流");
        //插入一个换行符，表示写入内容结束,此时要求对方使用readline方式读取
        bufferedWriter.newLine();
        bufferedWriter.flush();//刷新
        //接收回信
        //获取输入流，读取数据并显示,字节流
        InputStream inputStream = socket.getInputStream();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        String s = bufferedReader.readLine();
        System.out.println(s);
        //关闭流对象和socket
        //字符流关闭外层流
        bufferedWriter.close();
        socket.close();
        bufferedReader.close();
        System.out.println("客户端退出");

    }

}