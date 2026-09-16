package com.pawamamama.upload;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Class: TCPFileUpLoadServer
 *
 * <pre>文件上传
 * 服务端
 * 1.接收文件
 * 2.回信给客户端
 * </pre>
 *
 * @author pawamamama
 * @date 2026/9/11
 */
@SuppressWarnings({"all"})
public class TCPFileUpLoadServer {
    public static void main(String[] args) throws Exception {
        //1.服务器在本机监听8888端口，服务器指定端口
        ServerSocket serverSocket = new ServerSocket(8888);
        //2.等待连接
        System.out.println("服务端在8888端口监听。。。。");
        Socket socket = serverSocket.accept();
        //3.读取客户端发送的数据
        //3.1 通过Socket得到一个输入流(inputStream)
        BufferedInputStream bis =
                new BufferedInputStream(socket.getInputStream());
        //3.2 通过工具类把流转成一个字节数组
        byte [] bytes  = StreamUtils.streamToByteArray(bis);
        //4.将得到的bytes写入到指定路径
        String dest ="D:\\java_learning\\java_code\\chapter21\\src\\com\\pawamamama\\upload\\png\\copy.png";
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(dest));
        bos.write(bytes);//写入
        bos.close();
        //=================================================================================
        //=================================================================================
        //=================================================================================
        //=================================================================================
        //=================================================================================
        //=================================================================================
        //发送信息到客户端说收到了
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        bw.write("服务端收到文件");
        bw.flush();//刷新
        socket.shutdownOutput();//设置结束标记
       //关闭其他资源
       bis.close();
       socket.close();
       serverSocket.close();
       //=================================================================================
        bw.close();



    }
}