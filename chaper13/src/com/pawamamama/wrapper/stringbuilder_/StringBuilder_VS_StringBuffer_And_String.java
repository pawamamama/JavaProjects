package com.pawamamama.wrapper.stringbuilder_;

/**
 * StringBuilder02
 * <p>String、StringBuffer、StringBuilder 比较</p>
 *
 * <pre>
 * 整体比较：
 * 类继承关系：
 *     - 公共继承接口：
 *         - java.lang.CharSequence
 *             表示可读的字符序列，提供 length()、charAt()、
 *             subSequence() 等方法。
 *         - java.io.Serializable
 *             标记接口，表示对象支持序列化，可转换为字节流进行
 *             存储或传输。
 *     - StringBuffer 和 StringBuilder 独有接口：
 *         - java.lang.Appendable
 *             表示对象支持追加字符操作，提供 append() 方法。
 * 特点对比：
 *     1. StringBuffer 和 StringBuilder 非常类似，都继承自抽象类（Abstract...类），方法实现基本相同。
 *     2. String 直接继承自 Object，实现的接口与 StringBuffer、StringBuilder 相同。
 *
 * 性能与特性：
 *     1. String：不可变字符序列，效率较低，但复用率高，内部使用 final char[] value 存储。
 *          1.1：复用率高String 在pool里 所有的String对象都可以指向该常量池对象。
 *     2. StringBuffer：可变字符序列，存储在堆中，增删改查效率较高，线程安全。
 *     3. StringBuilder：可变字符序列，存储在堆中，效率最高，但线程不安全。
 *使用原则
 *     1. 如果字符串存在大量的修改操作，一般使用StringBuffer 或者 StringBuilder
 *     2.如果字符串存在大量的修改操作，单线程使用 StringBuilder 多线程使用 StringBuffer
 *     3.字符串很少修改，被多个对象引用，使用String ，比如配置信息等
 *
 *
 *
 *          </pre>
 *
 * @author pawamamama
 * @since 2026/6/8
 */
public class StringBuilder_VS_StringBuffer_And_String {
    //效率测试
    public static void main(String[] args) {
        int n = 100_000; // 拼接次数

        // ---------- String ----------
        long start1 = System.currentTimeMillis();
        String str = "";
        for (int i = 0; i < n; i++) {
            str += "a"; // 每次都会创建新对象
        }
        long end1 = System.currentTimeMillis();
        System.out.println("String: " + (end1 - start1) + " ms");

        // ---------- StringBuffer ----------
        long start2 = System.currentTimeMillis();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < n; i++) {
            sb.append("a"); // 线程安全
        }
        long end2 = System.currentTimeMillis();
        System.out.println("StringBuffer: " + (end2 - start2) + " ms");

        // ---------- StringBuilder ----------
        long start3 = System.currentTimeMillis();
        StringBuilder sbld = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sbld.append("a"); // 非线程安全，最快
        }
        long end3 = System.currentTimeMillis();
        System.out.println("StringBuilder: " + (end3 - start3) + " ms");
    }
}
