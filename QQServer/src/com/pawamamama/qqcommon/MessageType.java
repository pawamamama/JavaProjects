package com.pawamamama.qqcommon;
/**
 * 表示消息类型
 *
 *
 */
public interface MessageType {
    //1.在接口中定义了一些常量
    //2.不同常量值，表示不同的消息类型
    //3.接口中 字段默认 final static 修饰
    String MESSAGE_LOGIN_SUCCEED = "1";//表示登录成功
    String MESSAGE_LOGIN_FAIL = "2";//表示登录失败

}
