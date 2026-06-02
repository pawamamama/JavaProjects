package com.pawamamama.codeblock_;

public class CodeBlockDetail03 {
    static void main() {
        B b = new B();
        /*《一》父类加载加载静态成员（这个没有调用的语句   类加载默认执行）
        父类AAAA.n1 =10 -->(2) 父类静态代码块AAAA.n1 = 10
        *《二》 子类加载静态成员
        *(3)子类B.n1 = 30 -->(4)子类静态代码块B.n1 = 30
        * 《三》构造器
        *从子类构造器通过super() --> 父类构造器 --> 调用普通成员的语句(非static的属性和普通代码块)
        *(5)AAAA父类普通代码块200 执行完所有的非static属性和代码块-->(6)AAAA()父类无参构造器
        《四》回到子类super()调用处然后根据上面的规定执行
        与方法无关
        * */
    }
}
class AAAA {
    private static int n1 = 10;
    private int n2 = 200;
    static {
        System.out.println("AAAA父类静态代码块 " + "父类静态属性显示初始化n1 = " + n1 );
    }
    {
        System.out.println("AAAA父类普通代码块"+n2);
    }
    public AAAA() {
        //隐藏的执行要求
        // (1)super();
        //(2)调用普通代码块的语句 （普通代码块是跟创建对象相关所以要把普通代码块先执行）
        System.out.println("AAAA()父类无参构造器");
    }
}
class B extends AAAA {
    private static int n1 = 30;
    static {
        System.out.println("B类静态代码块 " + "子类静态属性显示初始化n1 = " + n1 );
    }
    {
        System.out.println("B子类普通代码块");
    }
    public B() {
         //隐藏的执行要求
        // (1)super();
       //(2)调用普通代码块的语句 （普通代码块是跟创建对象相关所以要把普通代码块先执行）
        System.out.println("B()子类无参构造器");
    }
}
/*
类加载
*
* 静态成员sam初始化
static块执行
sam1初始化
test构造器

*
*
*
*
* */