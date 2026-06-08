package com.pawamamama.wrapper.stringbuilder_;

/**
 * StringBuilder01
 * <p>一个可变的字符序列 单线程中优先采用</p>
 * <pre>
 *     1.此类提供一个与StringBuffer 兼容的api ,但不保证同步(不是线程安全的)
 *     2.该类被设定作StringBuffer 的一个简易替换，用在字符串缓冲区被单个线程使用的时候，建议优先采用该类。
 *     3.在大多数实现中，它比StringBuffer要快。
 *     4.StringBuilder 和 StringBuffer 均代表可变的字符序列，方法是一样的，所以使用和StringBuffer一样
 *
 *<p> java.io.Serializable 接口：串行化：对象可以进行网络传输，也可以存放在文件中</p>
 *
 *<p>StringBuilder继承体系</p>
 *     1. StringBuilder直接父类是 AbstractStringBuilder
 *
 *     2. StringBuilder实现了 java.io.Serializable 接口
 *
 *     3. StringBuilder是可以串行化的可以进行网络编程
 *<p>StringBuilder类刨析</p>
 *     1.是final类不能被继承
 *     2.StringBuilder类的字符序列仍然是存放在其父类AbstractStringBuilder的 char[] value
 *     3.因此也是存放在堆中
 *     4.StringBuilder 没有做线程安全（互斥处理）synchronized这个关键字，因此推荐在单线程情况下使用
 * </pre>
 *
 * @author pawamamama
 * @since 2026/6/8
 */
public class StringBuilder01 {
    public static void main(String[] args) {

        StringBuffer sb = new StringBuffer();
    }
}