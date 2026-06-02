package com.hspedu.poly_;
public class PloyMethod {
    public static void main(String[] args) {
        //方法重载体现多态
        //这里我们传入不同的参数,就会调用不同的sum方法
        A a = new A();
        System.out.println(a.sum(10,20));
        System.out.println(a.sum(10,20,30));
        //方法重写体现多态
        B b = new B();
        a.say();
        b.say();

    }
}
// 父类 B
class B {
    public void say() {
        System.out.println("B 类的 say 方法被调用");
    }
}

// 子类 A，继承 B
class A extends B {
    // 方法重载：两个参数
    public int sum(int n1, int n2) {
        return n1 + n2;
    }

    // 方法重载：三个参数
    public int sum(int n1, int n2, int n3) {
        return n1 + n2 + n3;
    }
    //方法重写
    @Override
    public void say() {
        System.out.println("A 类的 say 方法被调用");
    }

}