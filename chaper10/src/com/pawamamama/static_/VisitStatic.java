package com.pawamamama.static_;

public class VisitStatic {
    static void main(String[] args) {
        //类名.类变量
        //类变量随着类的加载而创建，即使没有创建对象的实例也可以访问
        System.out.println(A.name);
        //也可以通过对象实例来进行访问，
        // 但是对象实例没有该静态类变量的引用
        // 而是编译器自动帮你翻译成类名.类变量
        //不推荐这样用因为会不好
        A a = new A();
        System.out.println(a.name);


    }
}
class A {
    //类变量
    //访问必须遵守相关的访问权限
    public static String name = "wangweixin";


}