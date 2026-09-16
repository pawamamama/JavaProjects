package com.pawamamama.socket_;

import jdk.nashorn.internal.runtime.UnwarrantedOptimismException;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Class: SocketTCP01Server
 *
 * <pre>
 *
 *     socket 服务端
 *     字符流编程
 *     1.字符流可以使用 writer.newLine（换行符）
 *     来设置写入标记，注意需要对方使用readLine才能使用
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
public class SocketTCP03Server {
    public static void main(String[] args) throws IOException {
        //细节要求9999端口没有被占用，没有其他服务
        ServerSocket serverSocket = new ServerSocket(9999);
        Socket socket = serverSocket.accept();//会阻塞，等待连接
        //细节serverSocket通过accept方法返回多个socket（多并发）
        System.out.println("服务端socket accepted" +  socket.getClass() );
        //获取输入流
        //读取不到会阻塞在这里，一直等到有输入流流入
        InputStream inputStream = socket.getInputStream();
        //读取,字节流-转换流-字符流
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        String s = bufferedReader.readLine();
        System.out.println(s);
        //5.回送消息
        //5.1 得到输出流给客户端，写入数据到通道
        OutputStream outputStream = socket.getOutputStream();
        //使用字符流
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream));
        bufferedWriter.write("hello Client 字符流");
        bufferedWriter.newLine();
        bufferedWriter.flush();//手动刷新
        //关闭流和socket
        socket.close();
        serverSocket.close();//服务端口关闭
        bufferedReader.close();
        //关闭输入流
        bufferedWriter.close();

    }
}