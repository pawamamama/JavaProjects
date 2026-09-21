package com.pawamamama.qqclient.view;

import com.pawamamama.qqclient.service.UserClientService;
import com.pawamamama.qqclient.utils.Utility;

/**
 * Class: QQView
 *
 * <pre>客户端登录界面/菜单
 * </pre>
 *
 * @author pawamamama
 * @date 2026/9/20
 */
@SuppressWarnings({"all"})
public class QQView {
    //控制显示循环
    private boolean loop = true;
    private String key = "";//接收用户键盘输入
    //用于登录服务器，注册用户
    private UserClientService userClientService = new UserClientService();

    public static void main(String[] args) {
        new QQView().mainMenu();
        System.out.println("客户端退出系统");
    }

    //现实主菜单
    private void mainMenu() {
        while (loop) {
            System.out.println("========== 欢迎登录网络通讯系统 ==========");
            System.out.println("\t\t 1 登录系统");
            System.out.println("\t\t 9 退出系统");
            System.out.print("请输入你的选择：");
            key = Utility.readString(1);
            //根据用户输入处理不同情况
            switch (key) {
                case "1":
                    System.out.print("请输入用户号：");
                    String userId = Utility.readString(20);
                    System.out.print("请输入密码：");
                    String userPwd = Utility.readString(20);
                    //需要到服务端该用户是否合法
                    //这里编写一个类 UserClientService[用户登录/注册]
                    //使用该类检查用户
                    if (userClientService.checkUser(userId,userPwd)) {//先把逻辑打通，这里调用方法，把userId and pwd 发给服务器
                        System.out.println("========== 欢迎" + userId + " 登录成功 ==========");
                        //二级菜单
                        while (loop) {
                            System.out.println("\n========== 网络通讯系统二级菜单(用户 " + userId + ") ==========");
                            System.out.println("\t\t 1 显示在线用户列表");
                            System.out.println("\t\t 2 群发消息");
                            System.out.println("\t\t 3 私聊消息");
                            System.out.println("\t\t 4 发送文件");
                            System.out.println("\t\t 9 退出系统");
                            System.out.print("请输入你的选择：");
                            key = Utility.readString(1);
                            switch (key) {
                                case "1":
                                    System.out.println("显示在线用户列表");
                                    break;
                                case "2":
                                    System.out.println("\t\t 2 群发消息");
                                    break;
                                case "3":
                                    System.out.println("\t\t 3 私聊消息");
                                    break;
                                case "4":
                                    System.out.println("\t\t 4 发送文件");
                                    break;
                                case "9":
                                    loop = false;
                                default:
                                    System.out.println("输入错误，请重新输入");
                                    break;
                            }
                        }
                    } else {
                        System.out.println("========== 登录失败 ==========");
                    }
                    break;
                case "9":
                    System.out.println("退出系统");
                    loop = false;
                    break;
                default:
                    System.out.println("输入错误，请重新输入");
                    break;
            }

        }
    }


}