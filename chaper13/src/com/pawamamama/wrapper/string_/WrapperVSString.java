package com.pawamamama.wrapper.string_;

/**
 * @author pawamamama
 * 包装类型和String类型的相互转换。
 *
 */
public class WrapperVSString {
    public static void main(String[] args) {
        //包装类(Integer)->String
        Integer i = 100;
        //方式1
        String str1 = i + "";
        //方式二
        String str2 = i.toString();
        //三
        String s = String.valueOf(i);

        System.out.println(str1);
        System.out.println(str2);
        System.out.println(s);

        //String->包装类(Integer)
        String str4 = "1234";
        int i1 = Integer.parseInt(str4 );//使用自动装箱
        Integer i2 = new Integer(str4);//利用构造器

    }
}
