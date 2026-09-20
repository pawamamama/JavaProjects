package com.pawamamama.qqcommon.qqcommon;

import java.io.Serializable;

/**
 * Class: Message
 *
 * <pre>
 *     表示客户端和服务端通信的消息对象
 * </pre>
 *
 * @author pawamamama
 * @date 2026/9/20
 */
@SuppressWarnings({"all"})
public class Message  implements Serializable {

    private static final long serialVersionUID = 1L;
    private String sender;//发送方
    private String getter;//接收者
    private String content;//内容
    private String sendTime;//发送时间
    private String mesType;//消息类型 -可以在接口中定义消息类型（图片，视频，纯消息）

    public Message(String sender, String getter, String content, String sendTime, String mesType) {
        this.sender = sender;
        this.getter = getter;
        this.content = content;
        this.sendTime = sendTime;
        this.mesType = mesType;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public String getGetter() {
        return getter;
    }

    public void setGetter(String getter) {
        this.getter = getter;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getSendTime() {
        return sendTime;
    }

    public void setSendTime(String sendTime) {
        this.sendTime = sendTime;
    }

    public String getMesType() {
        return mesType;
    }

    public void setMesType(String mesType) {
        this.mesType = mesType;
    }
}