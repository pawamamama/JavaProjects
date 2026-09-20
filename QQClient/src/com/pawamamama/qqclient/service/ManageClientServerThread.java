package com.pawamamama.qqclient.service;

import java.util.HashMap;

/**
 * Class: ManageClientServerThread
 *
 * <pre>管理客户端服务器线程
 * 管理客户端连接到服务器的线程的类
 * </pre>
 *
 * @author pawamamama
 * @date 2026/9/20
 */
@SuppressWarnings({""})
public class ManageClientServerThread {
    //把多个线程放入到HashMap中，key 就是用户id ，value 就是线程
    private static HashMap<String,ClientConnectServerThread> hm = new HashMap<>();

    //将某个线程加入到文件中
    public static void addClilenServerThread(String userId,ClientConnectServerThread cct) {
        hm.put(userId,cct);
    }
    //取出某个线程,通过id
    public static  ClientConnectServerThread getClilenServerThread(String userId) {
        return hm.get(userId);
    }

}