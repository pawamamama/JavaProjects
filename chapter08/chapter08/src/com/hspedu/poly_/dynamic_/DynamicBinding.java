package com.hspedu.poly_.dynamic_;

public class DynamicBinding {
    static void main() {
        A a = new B();
        System.out.println(a.sum());
        System.out.println(a.sum1());
        B b = (B)a;
        System.out.println(b.sum());
        System.out.println(b.sum1());
    }
}
//java 的动态绑定
// 当调用对象方法的时候，该方法会和该对象的内存地址/运行类型绑定
//当调用对象属性时，没有动态绑定机制，哪里声明哪里使用，就近原则       =去。,,L
class A {
    public int i = 10;

    public int sum() {
        return getI() + 10;
    }

    public int sum1() {
        return i + 10;
    }

    public int getI() {
        return i;
    }
}

class B extends A {
    public int i = 20;

  /*  @Override
    public int sum() {
        return i + 20;
    }*/
    @Override
    public int getI() {
        return i;
    }

    @Override
    public int sum1() {
        return i + 10;
    }

}
