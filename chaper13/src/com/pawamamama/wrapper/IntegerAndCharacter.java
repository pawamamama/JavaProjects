package com.pawamamama.wrapper;

/**
 * @author pawamamama
 */
public class IntegerAndCharacter {
    public static void main(String[] args) {
        //获取最大值最小值
        System.out.println(Integer.MIN_VALUE);
        System.out.println(Integer.MAX_VALUE);
        //Character
        //判断是不是数字
        System.out.println(Character.isDefined('a'));
        //判断是不是字母
        System.out.println(Character.isLetter('a'));
        //判断是不是大写和小写
        System.out.println(Character.isUpperCase('a'));
        System.out.println(Character.isLowerCase('a'));
        //判断是不是空格
        System.out.println(Character.isWhitespace(' '));
        //转换成大写
        System.out.println(Character.toUpperCase('a'));
        //转换成小写
        System.out.println(Character.toLowerCase('A'));
    }
}
