package com.pawamamama.qqclient.service;

import com.pawamamama.qqcommon.Message;

import java.io.IOException;
import java.io.ObjectOutputStream;
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
        message.setSender(senderId);
        message.setGetter(getterId);
        message.setContent(content);
        message.setSendTime(new Date().toString());//发送时间设置
        System.out.println(senderId + "对 " + getterId+"说: " + content);
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