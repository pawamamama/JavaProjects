package com.project.small;

import java.text.SimpleDateFormat;
import java.util.Date;//日期包
import java.util.Scanner;

public class SmallChangeSys {
    //1.显示菜单 ，可以选择，给出对应的提示信息
    //2.零钱通明细
    //3.收益入账
    //4.消费
    static void main() {
        //设计变量
        boolean loop = true;
        Scanner scanner = new Scanner(System.in);
        String key = "";//方法内得自己初始化


        //2.零钱通明细
        String details = "-------------明细-------------";
        //3.
        //定义新的变量
        double money = 0;
        double balance = 0;
        Date date = null;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm"); //可以用于日期格式化
        //4.
        //定义新变量 保存消费
        String note;
        do {
            System.out.println("\n=========零钱通菜单=========");
            System.out.println("\t\t1.零钱通明细");
            System.out.println("\t\t2.收益入账");
            System.out.println("\t\t3.消费情况");
            System.out.println("\t\t4.退     出");

            System.out.print("请选择（1~4）");
            key = scanner.next();
            //使用switch分支
            switch (key) {
                case "1":
                    System.out.println(details);
                    break;
                case "2":
                    System.out.print("收益入账金额:");
                    money = scanner.nextDouble();
                    //money 值范围校验
                    //找出不正确的金额条件 给出提示 就直接break
                    if (money <= 0 ) {
                        System.out.println("入帐金额不能小于等于零");
                        break;
                    }
                    //低耦合高内聚，少if 一个代码块一个功能做好模块排序


                    balance += money;
                    //拼接收益入账信息
                    date = new Date(); //获取当前日期
                    details += "\n收益入账\t+" + money + "\t" + sdf.format(date) + "\t" + balance;
                    break;
                case "3":
                    System.out.println("消费金额:");
                    money = scanner.nextDouble();
                    //money
                    //先找金额不正确的 不能为零 和负数 和 消费金额大于持有金额
                    if (money <= 0 || money > balance) {
                        System.out.println("你的消费金额应该在 0~" + balance+ "之间");
                        break;
                    }
                    System.out.println("消费说明:");
                    note = scanner.next();
                    balance -= money;
                    //拼接入账信息到details
                    date = new Date();
                    details += "\n" + note + "\t-" + money + "\t" + sdf.format(date) + "\t" + balance;
                    break;
                case "4":
                    //  退出确定
                    //1. 定义变量 choice  ，接收用户的输入
                    String choice = "";
                    while (true) {
                        System.out.println("你确定要退出吗y/n");
                        choice = scanner.next();
                        if ("y".equals(choice) || "n".equals(choice)) {
                            break;
                        }
                    }
                    if ("y".equals(choice)){//一段代码完成一个功能
                        loop = false;
                    }
                    break;
                default:
                    System.out.println("输入的数值有误");
            }

        } while (loop);
    }

}
