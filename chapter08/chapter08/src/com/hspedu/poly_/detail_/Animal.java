package com.hspedu.poly_.detail_;

public class Animal {

    String name = "动物"; // 动物的名字
    int number = 10;     // 数字属性

    // 睡觉方法
    void sleep() {
        System.out.println("动物正在睡觉");
    }

    // 跑步方法
    void run() {
        System.out.println("动物正在跑步");
    }

    // 吃方法
    void eat() {
        System.out.println("动物正在吃东西");
    }

    // 显示方法
    protected void show() {
        System.out.println("你好");
    }
}

