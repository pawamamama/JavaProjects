package com.pawamamama.qqserver.service;

import com.pawamamama.qqcommon.User;

import java.util.HashMap;

/**
 * Class: ManageClientThread
 * 用于管理和客户端通讯线程
 *
 * <pre>
 * </pre>
 *
 * @author pawamamama
 * @date 2026/9/21
 */
@SuppressWarnings({"all"})
public class ManageClientThreads {
    //管理服务端线程
    private static HashMap< String , ServerConnectClientThread> hm = new HashMap<>();
    //添加线程
    public static void addClientThread(String userId,ServerConnectClientThread serverConnectClientThread){
        hm.put(userId,serverConnectClientThread);
    }
    //获取该线程，根据userid返回线程
    public static ServerConnectClientThread getServerConnectClientThread(String userId,ServerConnectClientThread serverConnectClientThread){
        return hm.get(userId);
    }
}