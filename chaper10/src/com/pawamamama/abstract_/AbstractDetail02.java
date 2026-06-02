package com.pawamamama.abstract_;

public class AbstractDetail02 {
    static void main(String[] args) {

    }
}
abstract class Animal1 {
    //但是允许写静态类变量
    public final static int num = 100;
    //抽象方法不能使用private final 和 static来修饰 这些关键字都是和重写相违背的
     abstract public void eat();
}
class Cat1 extends Animal1 {

    @Override
    public void eat() {

    }
}

//抽象类本质还是类 能使用普通类任何的东西
abstract class JK {
    public int n1 = 10;
    public static  int n2 = 100;

    public JK(int n1) {
        this.n1 = n1;
    }

    public void hi() {

    }
    public final static int n3() {
        return JK.n2;
    }
    public abstract void eat();

}
