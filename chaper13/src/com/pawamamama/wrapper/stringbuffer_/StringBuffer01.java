package com.pawamamama.wrapper.stringbuffer_;

/**
 * StringBuffer01
 * <pre>
 * 介绍
 *  1.java.lang.StringBuffer代表可变的字符序列，可以对字符串进行增删
 *  2.很多方法跟String 相同，但是StingBuffer是可变长度的
 *  3.StringBuffer是一个容器
 *  </pre>
 * <p>继承关系</p>
 * <pre>
 *
 *  1. StringBuffer直接父类是 AbstractStringBuilder
 *
 *  2. StringBuffer实现了 java.io.Serializable 接口
 *
 *  3. StringBuffer是可以串行化的可以进行网络编程
 *
 *  </pre>
 * <p>StringBuffe类解读和与父类AbstractStringBuilder和属性value</p>
 * <pre>
 *
 * 4.在父类 AbstractStringBuilder 有属性 char[] value 不是final类型，
 * 该value 数组存放字符串内容，存放在堆中
 *
 * 5.StringBuffer是final类是一个不可继承类
 * </pre>
 *
 *
 *<p>String VS StringBuffer</p>
 *
 * <pre>
 *     1.String保存的是字符串常量,这个值不能更改，每次String类的更新实际上就是更改地址，效率较低。
 *     2.StringBuffer保存的是字符串变量里面的值可以更改，每次StringBuffer的更新实际上可以更新内容，不用每次更新地址（不是每次创建新对象），效率高于
 *     3.StringBuffer 放在堆中 而String通常在pool 中 只要更新了string每次修改都是指向新地址
 * </pre>
 * @author pawamamama
 * @since 2026/6/6
 */
public class StringBuffer01 {
    public static void main(String[] args) {


        StringBuffer sb = new StringBuffer("hello");
        String str = new String("hello");
    }
}