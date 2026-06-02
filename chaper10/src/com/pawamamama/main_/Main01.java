package com.pawamamama.main_;


public class Main01 {
    //静态变量属性
    private static String name = "wangweixin";

    //静态方法
    private static void hi() {
        System.out.println("Main01的 hi方法");
    }

    //非静态方法属性
    private int n1 = 1000;

    private void hello() {
        System.out.println("Main01的 hello方法");

    }

    //主方法本质是一个静态方法
    public static void main(String[] args) {
        //直接使用 name是静态成员
        //1.静态可以访问静态
        System.out.println("name = " + name);
        hi();
        //2.静态方法main 要访问非静态需要创建对象
        System.out.println(new Main01().n1);
        new Main01().hello();

    }
}
