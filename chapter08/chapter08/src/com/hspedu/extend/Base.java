package com.hspedu.extend;

// 父类 Base
public class Base extends TopBass {
    //
    public String name;
    public int age;
    // 1. 公有属性
    public String n1 = "public 属性";

    // 2. 受保护属性
    protected String n2 = "protected 属性";

    // 3. 默认（包访问权限）属性
    String n3 = "default 属性";

    // 4. 私有属性
    private String n4 = "private 属性";

    //base 方法
    public Base() {//无参构造器
        System.out.println("父类无参构造器base......");
    }

    public Base(String name) {
        System.out.println("父类Base(String name)构造器......");
    }

    public Base(String name, int age) {
        System.out.println("父类Base(String name,int age)构造器......");
    }

    //过父类提供的的方法 去访问的私有方法
    //父类提供一个public方法返回了n4
    public String getN4() {
        return n4;
    }

    // test100：public 方法
    public void test100() {
        System.out.println("test100：public 方法");
    }

    // test200：protected 方法
    protected void test200() {
        System.out.println("test200：protected 方法");
    }

    // test300：默认方法（不写修饰符）
    void test300() {
        System.out.println("test300：default 方法");
    }

    // test400：private方法
    private void test400() {
        System.out.println("test400：private 方法");
    }

    public void getTest400() {
        test400();
    }
}