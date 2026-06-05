package com.pawamamama.wrapper.string_;

/**
 * @author pawamamama
 * Date: 2026/6/5
 */
public class String09 {
    public static void main(String[] args) {
        String str = "pawa";
        String str1 = "mamama";
        String str2 = (str + str1).intern();
        String str3 = "pawamamama";
        System.out.println(str2 == str3);//true
        //相当于(拼接后返回的堆中对象).intern();把堆中对象放到pool之后直接返回引用
        String str4 = "wangwei";
        String str5 = "xin";
        String str6 = "wangweixin";//池
        String str7 = (str4 + str5).intern();
        //查找到池中有wangweixin 所以返回该对象引用
        System.out.println(str6 == str7);//true

    }

}