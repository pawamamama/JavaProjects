package com.pawamamama.hoemwork_;

import java.util.Locale;
/**
 * Homework03
 * <pre>
 * 字符串练习：
 * 将姓名按照指定格式输出。
 *
 * 输入：
 *     wang wei xin
 *
 * 输出：
 *     xin,wang .W
 *
 * 涉及知识点：
 *     1. String.split()
 *     2. String.format()
 *     3. Character.toUpperCase()
 *     4. 异常处理
 * </pre>
 *
 * @author pawamamama
 * @since 2026/6/13
 */
public class Homework03 {
    public static void main(String[] args) {
        String name = "wang wei xin";
        try {
            System.out.println(printName(name));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    /**
     * 将姓名格式转换为：
     * <pre>
     * 输入：
     *     wang wei xin
     *
     * 输出：
     *     xin,wang .W
     * </pre>
     *
     * 姓名必须由三部分组成，中间使用空格分隔。
     *
     * @param name 姓名字符串，格式为 "first middle last"
     * @return 格式化后的姓名字符串
     * @throws NullPointerException 当 name 为 null 时抛出
     * @throws RuntimeException 当姓名格式不正确（不是三部分）时抛出
     */
    public static String printName(String name){
        if(name == null) {
           throw  new NullPointerException("name 是空");
        }
        String[] arr = name.split(" ");
        if (arr.length != 3) {
           throw new RuntimeException("name 格式不对");
        }
        return String.format("%s,%s .%c",arr[2],arr[0],arr[1].toUpperCase().charAt(0));
    }
}