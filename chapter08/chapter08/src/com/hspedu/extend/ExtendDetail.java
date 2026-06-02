package com.hspedu.extend;

public class ExtendDetail {
    static void main(String[] args) {
        //创建子类对象时，一定是先调用父类的构造器
        System.out.println("---------第一个对象---------");
        Sub sub = new Sub();
//        sub.sayOk();
        System.out.println("---------第二个对象---------");
        Sub sub1 = new Sub("mama");
        System.out.println("---------第三个对象---------");
        Sub sub2 = new Sub("mamama",18);


    }
}
