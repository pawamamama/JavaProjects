package com.pawamamama.homework;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 * Class: Homework02_ReceiverA
 *
 * <pre>
 * </pre>
 *
 * @author pawamamama
 * @date 2026/9/18
 */
@SuppressWarnings({"all"})
public class Homework02_ReceiverA {
    public static void main(String[] args) throws IOException {
        //1.创建
        DatagramSocket socket = new DatagramSocket(8888);
        //2.创建packet接收数据
        byte[] data = new byte[1024];
        DatagramPacket packet = new DatagramPacket(data, data.length);
        //3.等待消息传入
        socket.receive(packet);
        //4.接收消息后拆包
        final int length = packet.getLength();
        final byte[] data1 = packet.getData();
        final String s = new String(data1, 0, length);
        //
        String s1 = "";
        if (s.equals("四大名著是哪些")) {
            s1 = "四大名著是 《三国演义》《水浒传》《西游记》《红楼梦》";
        } else {
            s1 = "what?";
        }
        //回送消息
        byte[] data2 = s1.getBytes();
        //创建包
        packet = new DatagramPacket(data2,data2.length, InetAddress.getLocalHost(),7777);
        socket.send(packet);
        //关流
        socket.close();

    }

}