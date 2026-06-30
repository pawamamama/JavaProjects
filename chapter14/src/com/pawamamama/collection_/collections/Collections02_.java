package com.pawamamama.collection_.collections;

import java.util.*;

/**
 * Class: Collections02_
 *
 * <pre>
 * Collections 工具类常用方法演示：
 *
 * 作用：
 * Collections 是 Java 提供的工具类，用于操作集合（List / Set 等）
 *
 * 特点：
 * 1. 所有方法均为 static 方法
 * 2. 不能实例化
 * 3. 提供对集合的统一操作：排序、查找、替换、复制等
 *
 * 本类演示内容：
 * 1. max / min（最大最小值）
 * 2. frequency（出现次数统计）
 * 3. copy（集合复制）
 * 4. replaceAll（元素替换）
 * </pre>
 *
 * @author pawamamama
 * @date 2026/6/30
 */
@SuppressWarnings({"all"})
public class Collections02_ {

    public static void main(String[] args) {

        // ==============================
        // 1. max / min（最大最小值）
        // ==============================
        /**
         * max(Collection)
         * 作用：返回集合中最大元素（自然排序）
         *
         * min(Collection)
         * 作用：返回集合中最小元素（自然排序）
         *
         * 前提：
         * - 元素必须实现 Comparable 接口
         * - 或提供 Comparator
         */
        List<Integer> list = new ArrayList<>(Arrays.asList(3, 1, 5, 2, 4));

        System.out.println("原集合: " + list);
        System.out.println("max = " + Collections.max(list));
        System.out.println("min = " + Collections.min(list));
        //根据指定的 Comparator 指定的顺序，返回给指定集合中最大的元素
        //比如长度大小
        List<String> strings = new ArrayList<>(Arrays.asList("pawa", "mamama", "hahahahha"));
        System.out.println("长度max==" + Collections.max(strings,new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.length() - o2.length();
            }
        }));
        System.out.println("长度min=="+ Collections.min(strings,new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.length() - o2.length();
            }
        }));

        // ==============================
        // 2. frequency（出现次数）
        // ==============================
        /**
         * frequency(Collection, Object)
         * 作用：统计指定元素在集合中出现的次数
         *
         * 底层原理：
         * 使用 equals() 进行比较
         */
        List<String> names = new ArrayList<>(
                Arrays.asList("tom", "jack", "tom", "mike", "tom")
        );

        System.out.println("\nnames: " + names);
        System.out.println("tom 出现次数 = " +
                Collections.frequency(names, "tom"));


        // ==============================
        // 3. copy（集合复制）
        // ==============================
        /**
         * copy(List dest, List src)
         * 作用：将 src 的内容复制到 dest 中
         *
         * ⚠ 注意：
         * 1. dest 长度必须 >= src
         * 2. 是“覆盖式复制”，不是追加
         */
        List<String> src = new ArrayList<>(Arrays.asList("A", "B", "C"));

        List<String> dest = new ArrayList<>(Arrays.asList("1", "2", "3"));

        System.out.println("\n复制前 dest: " + dest);
        Collections.copy(dest, src);
        System.out.println("复制后 dest: " + dest);


        // ==============================
        // 4. replaceAll（替换所有）
        // ==============================
        /**
         * replaceAll(List list, Object oldVal, Object newVal)
         * 作用：把 list 中所有 oldVal 替换为 newVal
         *
         * 底层：
         * 使用 equals() 匹配元素
         */
        List<String> list2 = new ArrayList<>(
                Arrays.asList("A", "B", "A", "C", "A")
        );

        System.out.println("\n替换前: " + list2);

        Collections.replaceAll(list2, "A", "Z");

        System.out.println("替换后: " + list2);
    }
}