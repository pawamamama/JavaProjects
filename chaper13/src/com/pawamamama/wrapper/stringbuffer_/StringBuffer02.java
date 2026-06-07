package com.pawamamama.wrapper.stringbuffer_;

/**
 * StringBuffer02
 * <p>StringBuffer的构造器</p>
 * <pre>
 *     1.
 *     new StringBuffer();构造一个其中不带字符的字符串缓冲区，其初始容量为16个字符。
 *     其构造器里的super(16); 父类构造器    value = new char[capacity];
 *     解读：创建了一个大小为16的 char[] ,用于存放字符串内容
 *     2.
 *     new StringBuffer(100);对char[]大小进行指定
 *     3.
 *     new StringBuffer("hello");
 *     构造指定Str.length +16 的一个StringBuffer对象
 *
 *
 *
 *
 * </pre>
 *
 * @author pawamamama
 * @since 2026/6/7
 */
public class StringBuffer02 {
    public static void main(String[] args) {
        //1.无参
        StringBuffer stringBuffer = new StringBuffer();
        //2.指定容量
        StringBuffer stringBuffer1 = new StringBuffer(100);
        //3.通过 String 创建 char[]大小是 str.length +16
        StringBuffer sb = new StringBuffer("hello");

    }
}