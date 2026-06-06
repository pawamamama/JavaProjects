package com.pawamamama.wrapper.string_.stringBuilder_and_stringbuffer;

/**
 * StringCommonMethods String类常用方法
 * @author pawamamama
 * @since 2026/6/6
 */
public class StringCommonMethods {
    public static void main(String[] args) {
        String s1 = " abca ";
        String s2 = " abca ";
        //equals 区分大小写，判断内容是否相等
        System.out.println(s1.equals(s2));
        //equalsIgnoreCase忽略大小写判断内容是否相等
        s2 = " ABCA ";
        System.out.println(s1.equalsIgnoreCase(s2));
        //length 获取字符的个数字符串的长度
        System.out.println(s2.length());
        //indexOf获取字符在字符串中第一次出现的索引,索引从0开始，如找不到返回-1
        System.out.println(s1.indexOf('a'));
        //也可以是字符串
        System.out.println("位置 "+s1.indexOf("abc"));//返回1
        //lastIndexOf获取字符在字符串中最后一次出现的缩引,索引从0开始，如找不到返回-1
        System.out.println(s1.lastIndexOf('a'));
        //subString 截取指定范围的字符串
        //0是索引数到2是起始下标（包含此值） 输出到末尾
        System.out.println(s1.substring(2));//截取" a"，然后输出开头后面所有的内容
        //0是起始下标包他 6是结束索引不要他 6-1 = 5
        //beginIndex -起始索引，包括起始索引。
        //endIndex -结束索引，排他不要他
        System.out.println(s1.substring(0,6));
        //trim去前后空格
        System.out.println(s1.trim());
        System.out.println(s1);//不会变化
        s1 = s1.trim();
        System.out.println(s1);//会变但是不是直接修改的方式而是value指向常量池新String对 象
        //charAt 获取某索引处的字符,注意不能使用Str[index]的方式
        System.out.println(s1.charAt(3));


    }
}