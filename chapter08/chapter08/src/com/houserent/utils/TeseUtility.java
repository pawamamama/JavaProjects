package com.houserent.utils;

public class TeseUtility {
    public void main(String[] args) {
        //输入一个字符串，长度最大是3
        /*String s = Utility.readString(3);
        System.out.println(s);*/
//要求输入一个字符串 ，长度最大为10.如果用户直接回车，就给一个默认值（hspedu）
        String s2 = Utility.readString(10,"hspdeu");
        System.out.println(s2);
        //方法是static时 是静态方法直接可以通过类名调用

    }
}
