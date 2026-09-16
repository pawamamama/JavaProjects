package com.pawamamama.upload;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;

/**
 * Class: TCPFileUpLoadCilent
 *
 * <pre>文件上传
 * 客户端
 * 1.发送图片
 * 2.接收回信
 * </pre>
 *
 * @author pawamamama
 * @date 2026/9/11
 */
@SuppressWarnings({"all"})
public class TCPFileUpLoadCilent {
    public static void main(String[] args) throws Exception {
        //1.创建客户端的scoket连接
        //客户端链接端口，但是客户端会通过tcp/ip协议去分配（是随机的）
        Socket socket = new Socket(InetAddress.getLocalHost(), 8888);
        //2.读文件到字节数组
        //2.1 创建对应输入流，把文件加载到流中
        String filePath = "D:\\java_learning\\java_code\\chapter21\\src\\com\\pawamamama\\upload\\png\\bg.png";
        BufferedInputStream bis = new BufferedInputStream(new FileInputStream(filePath));
        //2.2 读取到一个字节数组中，使用别人写好的工具类（StreamUtils）
        // bytes就是对应的字节数组
        byte[] bytes = StreamUtils.streamToByteArray(bis);//把流放入
        //3.把得到的字节数组传入到输出流到服务端
        //socket.getOutputStream().write(bytes);
        BufferedOutputStream bos = new BufferedOutputStream(socket.getOutputStream());
        bos.write(bytes);//可以直接写入字节数组，实现传输文件
        //设置结束标记
        bis.close();//关闭流
        socket.shutdownOutput();//数据结束标记
        //=================================================================================
        //=================================================================================
        //=================================================================================
        //=================================================================================
        //=================================================================================
        //=================================================================================
        //接收从服务端回复的消息
         InputStream inputStream = socket.getInputStream();
         //使用工具类把输入流转换成字符串
        String s = StreamUtils.streamToString(inputStream);
        System.out.println(s);
        //关闭流
        bos.close();
        socket.close();



    }

}