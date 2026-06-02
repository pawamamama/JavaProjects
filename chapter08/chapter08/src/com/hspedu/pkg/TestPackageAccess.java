package com.hspedu.pkg;

import com.hspedu.modifier.A;

public class TestPackageAccess {
    //包访问测试
    static void main(String[] args) {
        A a = new A();
        //不同包访问
        System.out.println(" public n1 = " + a.n1 + "  在不同包下，只能访问public修饰的属性或方法 ");
        //方法
        //只能访问public a.m();

    }
}
