package com.pawamamama.hoemwork_;

/**
 * HomeWork05
 *
 * <p>本案例用于验证 String 常量池（String Pool）、堆内存对象、
 * new String、字符串拼接以及 intern() 方法的行为差异。</p>
 *
 * <h3>核心知识点：</h3>
 * <ul>
 *     <li>字符串常量池（String Pool）</li>
 *     <li>new String() 一定创建堆对象</li>
 *     <li>字符串拼接在运行期会使用 StringBuilder</li>
 *     <li>intern() 用于将字符串引用统一到常量池</li>
 * </ul>
 *
 * <h3>内存模型简述：</h3>
 * <pre>
 * String Pool（字符串常量池，JDK7+在堆中）
 * Heap（堆）
 *   - String 对象
 *   - char[] / byte[] 实际字符数据
 * </pre>
 *
 * @author pawamamama
 * @since 2026/6/13
 */
public class HomeWork05 {

    public static void main(String[] args) {

        /**
         * "pawamamama"：
         * 1. 进入字符串常量池（String Pool）
         * 2. str 指向池中的唯一字符串对象
         */
        String str = "pawamamama";

        /**
         * new String("pawamamama")：
         * 1. "pawamamama" 先在常量池中存在
         * 2. new String() 在堆中创建一个新的 String 对象
         * 3. str1 与 str 引用不同对象
         */
        String str1 = new String("pawamamama");

        // false：池对象 vs 堆对象
        System.out.println(str == str1);

        /**
         * String 拼接规则：
         *
         * 因为 str 是变量（运行期不可确定），所以：
         * 编译后等价于：
         *
         * StringBuilder sb = new StringBuilder();
         * sb.append("hello");
         * sb.append(str);
         * String t1 = sb.toString(); // 堆中新对象
         *
         * 结论：t1 在堆中，不在常量池
         */
        String t1 = "hello" + str;

        /**
         * 字符串常量：
         * "hellopawamamama" 在编译期确定
         * 直接进入字符串常量池
         */
        String t2 = "hellopawamamama";

        /**
         * intern() 方法行为：
         *
         * 1. 检查字符串常量池是否存在该内容
         * 2. 若存在 → 返回池中对象
         * 3. 若不存在 → 将堆中的字符串加入池，并返回引用
         *
         * 因为 t2 已经在池中：
         * t1.intern() 返回的就是 t2 的引用
         */
        System.out.println(t1.intern() == t2); // true
    }
}