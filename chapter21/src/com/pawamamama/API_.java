package com.pawamamama;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.sql.SQLOutput;

/**
 * Class: API_
 *
 * <pre>演示InetAddress 类使用
 * </pre>
 *
 * @author pawamamama
 * @date 2026/8/29
 */
@SuppressWarnings({"all"})
public class API_ {
                                                    //未知主机异常
    public static void main(String[] args) throws UnknownHostException {
        //1.获取本机的InetAddress
        InetAddress localhost = InetAddress.getLocalHost();
        System.out.println(localhost);
        //LAPTOP-N0QJE165/192.168.129.2
        // 计算机名        地址
        //2.根据指定的主机名获取对象
        InetAddress ByName = InetAddress.getByName("LAPTOP-N0QJE165");
        System.out.println(ByName);
        //3.根据域名返回 InetAddress对象，比如 www.baidu.com
        InetAddress baidu = InetAddress.getByName("www.baidu.com");
        System.out.println(baidu);
        //www.baidu.com/110.242.69.21
        //4. 通过 InetAddress 对象的，获取对应的地址
        String hostAddress = baidu.getHostAddress();
        System.out.println(hostAddress);//ip 110.242.69.
        //5. 通过InetAddress对象，获取对应的主机名/或者域名
        String hostName = baidu.getHostName();
        System.out.println(hostName);//www.baidu.com       client

    }

}