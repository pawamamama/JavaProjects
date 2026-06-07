package com.pawamamama.wrapper.string_.string_method;

/**
 * String类是保存字符串常量的，每次更新都需要重新开辟空间，效率较低。
 * 因此，Java设计者提供了 StringBuilder 和 StringBuffer 来增强字符串的功能，并提高效率。
 *
 * @author pawamamama
 * @version 1.0
 * @since 2026-06-06
 */
public class StringFor_0_80000 {
    public static void main(String[] args) {
        String s = new String("");
        for (int i = 0; i < 80000; i++) {
            s += "hello";
        }
    }
}