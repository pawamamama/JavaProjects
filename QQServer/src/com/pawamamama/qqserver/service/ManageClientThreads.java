package com.pawamamama.qqserver.service;

import com.pawamamama.qqcommon.User;

import java.util.HashMap;
import java.util.Set;

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
    //根据id删除线程
    public static void removeClientThread(String userId){
        hm.remove(userId);
    }
    //获取所有线程

    public static HashMap<String, ServerConnectClientThread> getHm() {
        return hm;
    }

    //获取该线程，根据userid返回线程
    public static ServerConnectClientThread getServerConnectClientThread(String userId){
        return hm.get(userId);
    }
    //编写方法，返回在线用户列表
    public static String getOnlineUser() {
        String allUser = "";
        //遍历集合的key
        for (String s : hm.keySet()) {
            allUser += s + " ";
        }
        return allUser;
    }
}