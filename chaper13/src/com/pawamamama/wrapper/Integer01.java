package com.pawamamama.wrapper;

/**
 * @author pawamamama
 * 包装类和基本数据的转换
 * 1.JDK5前的手动装箱和拆箱的方式
 * 装箱：基本类型->包装类型,反之是拆箱
 * 2.JDK5以后含JDK5，的自动装箱和拆箱的方式
 * 自动装箱底层调用的是valueOf方法，比如Integer.valueOf();
 */
public class Integer01 {
    public static void main(String[] args) {
        //演示int<--->integer
        //jdk5前是手动装箱和拆箱

        //手动装箱 int-->integer
        int n1 = 100;
        Integer integer = new Integer(n1);
        Integer integer2 = Integer.valueOf(n1);

        //手动拆箱 integer-->int
        int i = integer.intValue();

        //jdk5后，就可以自动装箱和拆箱

        //自动装箱 int-->integer
        int n2 = 2;
        Integer integer3 = n2;//底层仍然使用 Integer.valueOf(n2),没有变自动帮你装

        //自动拆箱 integer-->int
        int n3 = integer3;//底层仍然使用 integer.intValue();
        Double d = 1.0;
        double d2 = d;
    }
}
