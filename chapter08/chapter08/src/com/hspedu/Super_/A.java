package com.hspedu.Super_;

// 父类 A
public class A extends Base {
    // 四种访问修饰符的变量
    //public int n1 = 100;
    protected int n2 = 200;
    int n3 = 300; // 默认（包访问权限）
    private int n4 = 400;

    public A() {
    }
    public A(String name) {
    }
    public A(String name,int age) {
    }
    /*public void cal() {
        System.out.println("A类的cal方法。。。");

    }*/


    // 四种访问修饰符的方法
    public void test100() {
        System.out.println("public 修饰符的 test100 方法");
    }

    protected void test200() {
        System.out.println("protected 修饰符的 test200 方法");
    }

    void test300() {
        System.out.println("默认 修饰符的 test300 方法");
    }

    private void test400() {
        System.out.println("private 修饰符的 test400 方法");
    }
}