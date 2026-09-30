package com.pawamamama.qqcommon;

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
    //文件相关的
    private byte[] fileBytes;//字节数组
    private int fileLen;//长度
    private String dest;//传输到哪里
    private String src;//源文件路径

    public byte[] getFileBytes() {
        return fileBytes;
    }

    public void setFileBytes(byte[] fileBytes) {
        this.fileBytes = fileBytes;
    }

    public int getFileLen() {
        return fileLen;
    }

    public void setFileLen(int fileLen) {
        this.fileLen = fileLen;
    }

    public String getDest() {
        return dest;
    }

    public void setDest(String dest) {
        this.dest = dest;
    }

    public String getSrc() {
        return src;
    }

    public void setSrc(String src) {
        this.src = src;
    }

    public Message() {
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