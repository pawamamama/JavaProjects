package com.pawamamama.interface_;

public class Interface {
}

interface Interface02 {
    //写属性
    public int n1 = 10;

    //写方法 ,在接口中 抽象方法可以省去abstract
    public void hi();

    //在jdk8 后可以有默认的实现方法,需要使用default关键字修饰
    default void ok() {
        System.out.println("ok");
    }

    //在jdk8 后可以有静态方法
    public static void cry() {
        System.out.println("cry");
    }
}

//一个类 实现了一个接口需要将该接口的所有抽象方法都实现
class A implements Interface02 {
    @Override
    public void hi() {
        System.out.println("hi");
    }
}