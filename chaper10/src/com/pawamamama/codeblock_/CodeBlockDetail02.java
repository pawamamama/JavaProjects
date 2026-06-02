package com.pawamamama.codeblock_;

public class CodeBlockDetail02 {
    static void main() {
        //1.调用静态代码块和静态属性初始化 （注意静态代码块和静态属性初始化的调用优先级一样，
        // 如果有多个静态代码块和多个静态变量的初始化则按照他们定义的顺序调用 ）
        //按照顺序执行
        A a = new A();// (1)A 静态代码块 --> (2)A类 静态getN1方法被调用
        //(3)A类 普通getN2方法被调用 --> (4)A 普通代码块 -->(5)构造器
        //2.调用普通代码块和普通属性的初始化（注意普通代码块和普通属性的初始化调用的优先级一样，
        // 如果有多个普通代码块和多个普通属性初始化则按定义的顺序调用 ）
        //3.调用构造器
    }
}

class A {
    private int n2 = getN2();

    {
        System.out.println("A 普通代码块");

    }

    static {
        System.out.println("A 静态代码块");
    }

    //静态属性初始化
    private static int n1 = getN1();

    public static int getN1() {
        System.out.println("A类 静态getN1方法被调用");
        return 100;
    }

    public int getN2() {
        System.out.println("A类 普通getN2方法被调用");
        return 200;
    }

    public A() {
        System.out.println("A类 构造器被调用");
    }
}

