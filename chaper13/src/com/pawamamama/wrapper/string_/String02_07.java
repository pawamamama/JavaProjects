package com.pawamamama.wrapper.string_;

/**
 * @author pawamamama
 * Date: 2026/6/5
 * 创建String象的两种方式
 * 1.直接赋值 String s = "pawamamama";
 * 先从常量池查看是否有"pawamamama"数据空间,如果有直接指向,如果没有则重新创建，然后指向。s最终指向的是常量池的空间地址
 * 2.调用构造器 String s = "pawamamama"
 * 先在堆中创建空间里面维护了value属性指向常量池的"pawamamama"空间。
 * 如果常量池中没有hsp.重新创建，如果有直接通过value指向。最终指向的是堆中的空间地址。
 *
 */

public class String02_07 {
    public static void main(String[] args) {
        String s = "pawa";
        String s1 = "pawa";
        System.out.println(s.equals(s1));//true
        System.out.println(s == s1);//true


        System.out.println(s == s1.intern());//true
        //调用intern方法时，如果池已经包含一个等于此String对象的字符串（用equals(Object)）方法确认,则返回池中用字符串
        //否则，将此次String对象添加到池中，并返回Stirng对象的引用
        //false true true false true true
        String s2 = new String("hello");
        String s3 = new String("hello");
        System.out.println(s2 == s3);//false，不是同一个对象，value是各自copy常量池的 针对java8
        String s4 = s2.intern(); //intern() 会返回 常量池中已有的 "hello" 的引用
        String s5 = "hello";
        System.out.println(s4 == s5); // true
        //s4 和直接写 "hello" 的 s5 引用同一个常量池对象 → == 为 true
        String  string = "hello" +" word";
        //编译器会优化成等价于 String  srting = "hello word";
        //所以是在常量池里面创建了一个对象，并返回引用
        //1.先创建一个 StringBuilder sb  = new StringBuilder();
        //2.执行StringBuilder append(String str) 方法追加了一个 sb.append("pawa")
        //3.再次执行StringBuilder append(String str) 方法追加了一个 sb.append("mamama")
        //4.最后调用sb.toString 方法，value是"pawamamama";
        //  toString里再去return new String(value, 0, count)
        //5.Stirng = sb.toString();
        String string1 = "pawa";
        String string2 = "mamama";
        String string3 = string1 + string2;//堆中对象
        String string4 = "pawamamama";//创建 pool 中对象 值是pawamamama
        System.out.println(string3 == string4);//false
        //这里不会创建对象，而是拼接之后创建一个在堆中的String对象value[]是pawamamama
        // 常量池里没有 想要有就intern();方法 intern使用后会把堆中的对象放进pool中
        String string5 = new String("pa");//在堆
        String string6 = string5.intern();//发现pool没有就把string5放进pool中,有就返回引用
        System.out.println(string6 == string5);//true
        System.out.println("nihao1");


    }
}
