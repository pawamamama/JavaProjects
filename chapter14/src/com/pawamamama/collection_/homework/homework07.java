package com.pawamamama.collection_.homework;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

/**
 * Class: homework07
 *
 * <pre>
 * Vector 和 ArrayList 比较总结：
 *
 * 1. 底层结构：
 *    - ArrayList：Object[] 动态数组
 *    - Vector：Object[] 动态数组（老版本集合）
 *
 * 2. 线程安全性：
 *    - ArrayList：线程不安全（效率高）
 *    - Vector：线程安全（方法加 synchronized）
 *
 * 3. 扩容机制：
 *    - ArrayList：
 *        默认容量 10
 *        扩容：1.5 倍
 *
 *    - Vector：
 *        默认容量 10
 *        扩容：
 *            默认：2倍扩容（或指定增量）
 *
 * 4. 性能对比：
 *    - ArrayList：快（无锁）
 *    - Vector：慢（加锁开销）
 *
 * 5. 使用场景：
 *    - ArrayList：单线程 / 高性能场景（推荐）
 *    - Vector：旧项目 / 需要线程安全但不推荐（已过时）
 *
 * 6. 替代方案：
 *    - 多线程推荐：
 *      Collections.synchronizedList
 *      或 CopyOnWriteArrayList
 *
 * </pre>
 */
@SuppressWarnings({"ALL"})
public class homework07 {

    public static void main(String[] args) {

        // =========================
        // ArrayList（非线程安全）
        // =========================
        List arrayList = new ArrayList();

        arrayList.add("tom");
        arrayList.add("jack");
        arrayList.add("mary");

        System.out.println("ArrayList: " + arrayList);

        // =========================
        // Vector（线程安全）
        // =========================
        List vector = new Vector();

        vector.add("tom");
        vector.add("jack");
        vector.add("mary");

        System.out.println("Vector: " + vector);

        /*
         * 核心区别演示：
         *
         * ArrayList：
         *   - 方法无 synchronized
         *   - 多线程可能出现数据不一致
         *
         * Vector：
         *   - 方法都加 synchronized
         *   - 保证线程安全，但性能较低
         */
    }
}