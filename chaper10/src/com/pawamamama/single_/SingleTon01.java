package com.pawamamama.single_;

public class SingleTon01 {
    //单例设计模式饿汉式
    //饿汉式可能造成创建了对象但是没有使用

    static BoyFriend boyFriend = BoyFriend.getBoyFriend();
    static BoyFriend boyFriend2 = BoyFriend.getBoyFriend();
    public static void main(String[] args) {
        System.out.println("私の友達　は　"+boyFriend+"さんです");
        System.out.println(boyFriend == boyFriend2);
        //为什么叫饿汉式
        //只要类加载了对象就创建
        System.out.println(BoyFriend.n3);
    }

}

//有一个类 BoyFriend 必须专一
//只能有一个男朋友
class BoyFriend {
    //test
    static {
        System.out.println("BoyFriend被加载，private static BoyFriend boyFriend = new BoyFriend(\"刘轩宇\");前");
    }
    public static  int n3= 0;
    public int n2 = 20;
    //如何保障我们只能创建一个 GirlFriend对象
    private String name;

    //1.构造器私有化
    private BoyFriend(String name) {
        this.name = name;
    }

    //2.类内部直接创建自己的私有对象
    //为了能够在静态方法中使用，返回gf对象，需要将其修饰为static  final后面学
    private static BoyFriend boyFriend = new BoyFriend("刘轩宇");

    static {
        System.out.println("boy对象被创建     private static BoyFriend boyFriend = new BoyFriend(\"刘轩宇\");语句后");
    }

    //类加载和对象创建
    //3.提供一个公共的静态方法，返回gf对象
    public static BoyFriend getBoyFriend() {
        return boyFriend;
    }

    public String toString() {
        return name;
    }
}