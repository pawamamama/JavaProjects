package com.pawamamama.final_;

public class FinalDetail02 {
    static void main(String[] args) {
        AAA.hihi();
        //这里编译器直接内联优化 成10;
        //百分百确定的静态常量就会直接优化
        System.out.println(AAA.N1);
    }
}
class AAA {
    //static final 搭配使用 就不会导致类被加载，底层做了优化,但是初始化在代码块就会初始化了
    public final static int N1 = 10;
    //final 只能确保不会被修改重写，还是会造成类加载
    public final static void  hihi() {
        System.out.println("hihi");
    }
    static {//
        System.out.println("静态代码块被加载");
    }
}
