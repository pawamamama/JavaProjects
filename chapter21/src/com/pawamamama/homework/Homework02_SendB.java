package com.pawamamama.homework;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.nio.charset.StandardCharsets;

/**
 * Class: Homework02_SendB
 *
 * <pre>
 * </pre>
 *
 * @author pawamamama
 * @date 2026/9/18
 */
@SuppressWarnings({"all"})
public class Homework02_SendB {
    public static void main(String[] args) throws IOException {
        //1.创建 套接字对象
        //端口是各自的 因为在一个主机端口尽量不要一样
        DatagramSocket socket = new DatagramSocket(7777);
        //2.发送信息
        byte[] data = "四大名著是哪些".getBytes(StandardCharsets.UTF_8);
        //3.把消息填入到数据包中
        final DatagramPacket datagramPacket = new DatagramPacket(data, data.length, InetAddress.getByName("127.0.0.1"), 8888);
        //发送
        socket.send(datagramPacket);
        //接收消息
        byte[] buffer = new byte[1024];
        DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
        //3.等待消息传入
        socket.receive(packet);
        //4.接收消息后拆包
        final int length = packet.getLength();
        final byte[] data2 = packet.getData();
        final String s = new String(data2, 0, length);
        System.out.println(s);
        socket.close();
    }

}