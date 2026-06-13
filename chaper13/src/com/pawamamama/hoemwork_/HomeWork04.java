package com.pawamamama.hoemwork_;

/**
 * HomeWork04
 *
 * <pre>
 * 统计字符串中：
 * 1. 大写字母个数
 * 2. 小写字母个数
 * 3. 数字个数
 * </pre>
 *
 * @author pawamamama
 * @since 2026/6/13
 */
public class HomeWork04 {
    public static void main(String[] args) {
        String str = "ajklfdj30349DGDGWERegqgrWEGREWRG0";
        try {
            sumString(str);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * 统计字符串中的大写字母、小写字母和数字个数
     *
     * @param str 待统计的字符串
     * @throws IllegalArgumentException 当字符串为 null 或空字符串时抛出
     */
    public static void sumString(String str) {
        if (str == null || str.isEmpty()) {
            throw new IllegalArgumentException("字符串不能为空");
        }
        //char数组化
        char[] charArray = str.toCharArray();
        int index = 0;
        int uppercase = 0;
        int lowercase = 0;
        int number = 0;

        while (index < charArray.length) {
            //判断时候不可能出现一个字符既是大写，又是小写，又是数字的所以用else-if
            if (charArray[index] >= 'a' && charArray[index] <= 'z') {
                lowercase++;
            }
            else if (charArray[index] >= 'A' && charArray[index] <= 'Z') {
                uppercase++;
            }
           else if (charArray[index] >= '0' && charArray[index] <= '9') {
                number++;
            }
            index++;
        }
        System.out.printf(
                "大写字母 = %d%n小写字母 = %d%n数字 = %d%n",
                uppercase,
                lowercase,
                number
        );
    }
}
