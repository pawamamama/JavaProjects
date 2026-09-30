package com.pawamamama.qqclient.service;

import com.pawamamama.qqcommon.Message;
import com.pawamamama.qqcommon.MessageType;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Class: FileClientService
 *
 * <pre>该类完成 文件传输
 * </pre>
 *
 * @author pawamamama
 * @date 2026/9/28
 */
@SuppressWarnings({"all"})
public class FileClientService {
    /**
     *
     * @param src      源文件
     * @param dest     对方接收目录
     * @param senderId 发送者
     * @param getterID 接收者
     */
    public void sendFlieToOne(String src, String dest, String senderId, String getterID) {
        //设置消息
        final Message message = new Message();
        //时间格式化
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
        String time;
        message.setSendTime(time = sdf.format(new Date()));
        message.setMesType(MessageType.MESSAGE_FILE_MES);
        message.setSender(senderId);
        message.setGetter(getterID);
        message.setSrc(src);
        message.setDest(dest);
        //读取文件
        //把源文件读取做成bytes 数组 --> message
        FileInputStream fis = null;
        // 先按文件长度创建一个字节数组，再用它的长度强制转成 int
        byte[] fileBytes = new byte[(int) new File(src).length()];
        try {
            fis = new FileInputStream(src);
            //读取到filebytes中
            fis.read(fileBytes);
            //填入到message对象中
            message.setFileBytes(fileBytes);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //关闭流
            if (fis != null) {
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        System.out.println("私[" + time + "]:=> " + senderId + " 给 " + getterID +
                "发送文件 : " + src + "到对方的电脑目录" + dest);
        //发送
        //发送到服务器
        try {
            // 先根据发送方 id 找到对应的客户端服务线程，再拿到它的 Socket 输出流，
            // 把这个输出流包装成对象流，最后把 message 对象序列化后写出去
            new ObjectOutputStream(
                    ManageClientServerThread.getClilentServerThread(senderId) // 通过 senderId 找到对应的线程对象
                            .getSocket()      // 取该线程持有的 Socket
                            .getOutputStream() // 取 Socket 的输出流（字节流）
            ).writeObject(message);       // 包装成对象流并写出 message（序列化发送）
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}