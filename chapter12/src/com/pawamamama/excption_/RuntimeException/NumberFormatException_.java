package com.pawamamama.excption_.RuntimeException;

/**
 * @author pawamamama
 * 数字格式不正确异常
 * 当应用程序试图将字符串转换成一种数值类型
 * 但该字符串不能 转换为适当格式就会抛出该异常
 * 使用该异常我们可以确保输入的是满足条件的数字
 */
public class NumberFormatException_ {
    public static void main(String[] args) {
        String name = "pawamama";
        //将String 转换成整数，抛异常
        int num = Integer.parseInt(name);
    }
}
