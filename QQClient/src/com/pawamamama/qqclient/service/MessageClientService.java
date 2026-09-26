package com.pawamamama.qqclient.service;

import com.pawamamama.qqcommon.Message;
import com.pawamamama.qqcommon.MessageType;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
/**
 * Class: MessageClientService
 *
 * <pre>
 *     该类提供消息相关的服务方法（私聊，群聊，文件）
 * </pre>
 *
 * @author pawamamama
 * @date 2026/9/25
 */
@SuppressWarnings({"all"})
public class MessageClientService {

    //私聊代码
    /**
     *
     * @param content 内容
     * @param senderId 发送用户
     * @param getterId 接收用户
     */
    public void sendMessageToOne(String content,String senderId,String getterId) {
        //构建message
        final Message message = new Message();
        //设置类型
        message.setMesType(MessageType.MESSAGE_COMM_MES);//普通私聊
        message.setSender(senderId);
        message.setGetter(getterId);
        message.setContent(content);
        //时间格式化
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
        String time;
        message.setSendTime(time = sdf.format(new Date()));
        // 私聊
        System.out.println("私聊[" + time + "]:=> " + senderId + " 对 " + getterId + " 说: " + content);
        //发送给服务端
        //拿到socket
        try {
            final ObjectOutputStream oos =
                    new ObjectOutputStream(
                            ManageClientServerThread.getClilentServerThread(senderId)
                                    .getSocket().getOutputStream());
            oos.writeObject(message);//发送
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    //群发消息方法
    /**
     *
     * @param content 消息内容
     * @param senderId 发送者
     */
    public void sendTOAll(String content,String senderId) {
        //构建message
        final Message message = new Message();
        //设置类型
        message.setMesType(MessageType.MESSAGE_TO_ALL_MES);//群发消息
        message.setSender(senderId);
        message.setContent(content);
        //时间格式化
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
        String time;
        message.setSendTime(time = sdf.format(new Date()));
        // 群发
        System.out.println("群发[" + time + "]:=> " + senderId + " 对大家说: " + content);
        //发送给服务端
        //拿到socket
        try {
            final ObjectOutputStream oos =
                    new ObjectOutputStream(
                            ManageClientServerThread.getClilentServerThread(senderId)
                                    .getSocket().getOutputStream());
            oos.writeObject(message);//发送
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}