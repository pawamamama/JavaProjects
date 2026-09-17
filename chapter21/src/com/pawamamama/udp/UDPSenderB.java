package com.pawamamama.udp;

import java.io.IOException;
import java.net.*;
import java.nio.charset.StandardCharsets;

/**
 * Class: UDPSenderB
 *
 * <pre>发送端
 * </pre>
 *
 * @author pawamamama
 * @date 2026/9/16
 */
@SuppressWarnings({"all"})
public class UDPSenderB {
    public static void main(String[] args) throws IOException {
        //1.创建DatagramSocket 对象，准备发送和接收数据 9998端口发送和接收
        DatagramSocket socket = new DatagramSocket(9998) ;
        //2.将需要发送的数据，装包到一个 DatagramPacket对象中
        byte[] data = "明日は　一緒に　すき焼き　を食べに行こう　と　思っているんですが　どうですか".
                getBytes(StandardCharsets.UTF_8);//指定字符集
        //DatagramPacket  有字节数组 字节长度 主机地址（至少知道ip），发送到的端口
        final DatagramPacket datagramPacket =
                new DatagramPacket(data, data.length, InetAddress.getLocalHost(), 9999);//发送到9999端口
        socket.send(datagramPacket);//发送
        //-----------------------------------------
        //-----------------------------------------
        //-----------------------------------------
        //-----------------------------------------
        //-----------------------------------------
        //接收消息
        byte[] buffer = new byte[1024];
        DatagramPacket packet = new DatagramPacket(buffer, buffer.length);//设置容器
        //等待消息
        socket.receive(packet);
        final byte[] data1 = packet.getData();
        final String s = new String(data1, 0, packet.getLength(), StandardCharsets.UTF_8);
        System.out.println("A 发送 "+ s + " B收到");

        //关闭资源
        socket.close();
        System.out.println("B端退出");

    }
}