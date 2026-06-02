package com.pawamamama.excption_.fiveException;

/**
 * @author pawamamama
 * 演示空指针异常NullPointerException
 * 当程序试图需要在对象的地方使用null，抛出该异常
 */
public class NullPointerException_ {
    public static void main(String[] args) {
        //没问题
       /* String name  = "wangweixin";
        System.out.println(name.length());*/
        //这里有问题抛空指针异常NullPointerException
        String name = null;
        System.out.println(name.length());
    }
}