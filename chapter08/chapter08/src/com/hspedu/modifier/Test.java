package com.hspedu.modifier;

public class Test {
    static void main(String[] args) {
        //同类访问
        System.out.println("同类访问");
        A a = new A();
        a.m();
        //同包访问
        System.out.println("同包访问");
        B b = new B();
        b.b();
        //子类访问 ，以后讲



        //不同包访问 ，只能访问公开的public

        //方法访问和属性访问都一样
        a.m2();
        a.m3();
        // private a.m4();
    }
}
