package com.hspedu.extend;

import java.util.Arrays;

//输入 ctrl + h Object类是 所有类的基类
public class Sub extends Base {//继承Base 父类

    public Sub(String name, int age) {
        super();//
        //要调用父类无参构造器，显式定义或者什么都不写，默认调用super();
        System.out.println("子类Sub(String name, int age)构造器....");

    }

    public Sub() {
        //这里默认有 super();去调用父类无参构造器
        //如果父类没有默认无参构造器，super();就必须写清楚用哪个构造器
        super("100",100);

        System.out.println("子类Sub()无参构造器....");
    }
    public Sub(String name) {
        super("100",100);
        System.out.println("子类Sub(String name)构造器....");
    }


    public void sayOk() {//子类方法
        //父类的非私有private 属性 和 方法都可以访问
        //非私有的属性和方法可以在子类直接访问
        System.out.println(n1);
        System.out.println(n2);
        System.out.println(n3);
        //私有private属性 不能访问  System.out.println(n4);



        //方法
        test100();
        test200();
        test300();
        //私有private方法 不能访问test400();


        //通过父类提供的公共方法去访问
        //但是可以通过父类的getN4()方法去获取一个值，保护了数据
        System.out.println(getN4() + "通过父类的getN4方法获取的私有属性");
        //方法也一样
        getTest400();
    }
}
