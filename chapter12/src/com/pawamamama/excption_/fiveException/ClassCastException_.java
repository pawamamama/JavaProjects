package com.pawamamama.excption_.fiveException;

/**
 * @author pawamamama
 * 类型转换异常ClassCastException
 * 当视图将对象转换为不是目标对象的子类或父类
 * 抛出该异常
 *
 */
public class ClassCastException_ {
    public static void main(String[] args) {
        //向上转型
        A a = new B();
        //向下转型
        B b = (B) a;
        //抛异常
        C c = (C) a;
    }
}
class A {}
class B extends A {}
class C extends A {}