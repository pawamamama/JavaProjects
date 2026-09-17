package com.pawamamama.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.nio.charset.StandardCharsets;

/**
 * Class: UDPReceiverA
 *
 * <pre>
 *     接收端，收到发送端消息就回复
 * </pre>
 *
 * @author pawamamama
 * @date 2026/9/16
 */
@SuppressWarnings({"all"})
public class UDPReceiverA {
    public static void main(String[] args) throws IOException {
        //1.创建一个DatagramSocket 对象,准备在9999接收数据
        DatagramSocket socket = new DatagramSocket(9999);
        //2.构建一个DatagramPacket 对象来承载数据
        // udp协议的数据包最大64kb
        byte[] buffer = new byte[1024];//这里1024已经够大了
        DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
        //3.调用接收方法
        //在9999端口上等待，接收到数据到packet
        //如果没有数据包发送，就会阻塞等待
        System.out.println("接收端等待数据");
        socket.receive(packet);
        //4.接收到packet需要进行拆包，取出数据并显示
        int length = packet.getLength();//实际接收到的长度
        byte[] data = packet.getData();//接收到的数据
        final String s = new String(data, 0, length);
        System.out.println("B发送 " + s + " A收到");
        //------------------------------------------------------------
        //------------------------------------------------------------
        //------------------------------------------------------------
        //------------------------------------------------------------
        //------------------------------------------------------------
        //------------------------------------------------------------
        //回发消息给B
        data = "ええ　本当に？　ありがとうございます".getBytes(StandardCharsets.UTF_8);
        final DatagramPacket datagramPacket =
                new DatagramPacket(data, data.length, InetAddress.getLocalHost(), 9998);
        socket.send(datagramPacket);
        //关闭资源
        socket.close();
        System.out.println("A端退出");

    }

}