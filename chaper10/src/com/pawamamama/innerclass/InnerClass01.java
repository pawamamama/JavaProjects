package com.pawamamama.innerclass;

public class InnerClass01 {//外部其他类
    static void main(String[] args) {
        //内部类
        //定义在外部类的局部位置上(方法内)
        //1.局部内部类
        //2.匿名内部类
        //
        //定义在外部类的成员位置上
        //成员内部类 （没用static）
        //静态内部类


    }
}
class Outer{//外部类
    private int n1 = 100;//属性

    public Outer(int n1) {//构造器
        this.n1 = n1;
    }

    public void m1() {//方法
        System.out.println("m1()");
    }
    {//代码块
        System.out.println("代码块...");
    }
        class Inner {//内部类

        }

}