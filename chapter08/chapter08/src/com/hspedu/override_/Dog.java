package com.hspedu.override_;

public class Dog extends Animal {
    public void cry() {
        System.out.println("小狗汪汪汪");
    }

    //子类的返回类型和父类方法返回类型一样。或者父类是父类返回类型的子类
    //比如 父类返回类型是Object ,子类方法返回类型是String也构成方法重写
    public String m1() {
        return "构成方法重写";
    }

    //这里Obj 不是 String的子类 ，因此编译错误
    /*public Object m2() {
        return "Dog类 m2方法";

    }*/
   /* public AAA m3() {//构成方法重写
        return null;
    }*/
    public BBB m3() {//构成方法重写，因为返回的那个类型是
        return null;
    }

    //细节子类方法不能缩小父类方法的访问权限
    //public > protected > 默认> private
    protected void eat() {
    //不能缩小但是可以放大访问权限
    }
}

class AAA {

}

class BBB extends AAA {

}
