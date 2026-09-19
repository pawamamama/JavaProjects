package com.pawamamama.homework;

import com.sun.jndi.toolkit.ctx.PartialCompositeDirContext;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

/**
 * Class: Homework03_Server_upload
 *
 * <pre>
 * </pre>
 *
 * @author pawamamama
 * @date 2026/9/19
 */
@SuppressWarnings({"all"})
public class Homework03_Server_upload {
    public static void main(String[] args) throws Exception {
        //
        final ServerSocket serverSocket = new ServerSocket(9999);
        Socket accept = serverSocket.accept();
        String s = StreamUtils.streamToString(accept.getInputStream()).trim();
        //老韩思路
        /*final InputStream inputStream = accept.getInputStream();
        byte[] buffer = new byte[1024];
        int len = 0;
        String  name2 = "";
        while ((len = inputStream.read(buffer)) != -1) {
            name2+=new String(buffer,0,len,StandardCharsets.UTF_8);
        }*/
        System.out.println("客户希望的下载名" + s);

        String path = "";
        if (s.equals("飞行艇")) {
            path = "src\\com\\pawamamama\\homework\\musices\\飛行艇 - King Gnu.flac";

        } else {
            path = "src\\com\\pawamamama\\homework\\musices\\" +
                    "Drown Out The Noise - THE RAMPAGE from EXILE TRIBE.flac";
        }
        //把文件加载进流里
        final BufferedInputStream bufferedInputStream =
                new BufferedInputStream(new FileInputStream(path));
        //把文件byte化
        byte[] music = StreamUtils.streamToByteArray(bufferedInputStream);
        //后发送整个文件
        accept.getOutputStream().write(music);
        accept.shutdownOutput();
        accept.close();

    }

}