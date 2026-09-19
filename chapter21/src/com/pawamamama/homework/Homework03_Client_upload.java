package com.pawamamama.homework;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.nio.charset.StandardCharsets;

/**
 * Class: Homework03_Client_upload
 *
 * <pre>
 * </pre>
 *
 * @author pawamamama
 * @date 2026/9/19
 */
@SuppressWarnings({"all"})
public class Homework03_Client_upload {
    public static void main(String[] args) throws Exception {
        Socket socket = new Socket(InetAddress.getLocalHost(), 9999);
        //就发一次没必要设置buff流了，也不用关流
        String name = "飞行艇";
        name = "Drown Out The Noise - THE RAMPAGE from EXILE TRIBE";
        socket.getOutputStream().write(name.getBytes(StandardCharsets.UTF_8));
        socket.shutdownOutput();
        //载入到客户端
        //先接收名字

        String path = "src\\com\\pawamamama\\homework\\client_music\\" + name + ".flac" ;
        System.out.println("path = [" + path + "]");
        System.out.println("name length = " + name.length());
        //接收完整的文件流
        final BufferedInputStream bufferedInputStream = new BufferedInputStream(socket.getInputStream());
        //转byte
        byte[] music = StreamUtils.streamToByteArray(bufferedInputStream);
        //载入到客户端文件
        new BufferedOutputStream(new FileOutputStream(path)).write(music);
        //关流
        bufferedInputStream.close();

        socket.close();
    }
}