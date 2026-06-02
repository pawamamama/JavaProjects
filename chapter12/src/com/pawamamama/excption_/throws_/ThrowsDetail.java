package com.pawamamama.excption_.throws_;

/**
 * @author pawamamama
 * 1.对于程序编译异常，程序中必须处理，比如try-catch 或者 throws
 * 2.对于运行时异常程序中如果没有处理，默认就是throws的方式处理到obj
 * 3.子类重写父类的方法时，抛出异常的规定
 *   ：子类重写的方法所抛出的异常类型要么和父类抛出的异常一致，要么为父类抛出的异常类型的子类型
 * 4.如果抛出的是运行异常则不用程序员显式处理，有默认处理机制
 */
public class ThrowsDetail {
    public static void main(String[] args) {

    }
    public static void f2() {
       /* //2B
        int n1 = 10;
        int n2 = 0;
        double res = n1/n2;*/
    }
    public static void f1() {
        f();//有默认处理机制
    }
    public static void f()throws RuntimeException {}
}
//3c 子类重写的方法所抛出的异常类型要么和父类抛出的异常一致，要么为父类抛出的异常类型的子类型
class Father{
    public void method() throws RuntimeException{}
}
class Son extends Father{
    @Override
    public void method() throws  NullPointerException{}
}

