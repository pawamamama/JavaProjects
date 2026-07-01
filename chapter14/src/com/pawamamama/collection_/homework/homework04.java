package com.pawamamama.collection_.homework;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

/**
 * Class: homework04
 *
 * <pre>
 * HashSet 和 TreeSet 的去重机制总结：
 *
 * 1. HashSet：
 *    - 底层依赖 HashMap
 *    - 去重依赖：hashCode + equals
 *
 *    执行流程：
 *    (1) 先计算 hashCode() 定位存储桶
 *    (2) 如果桶为空 → 直接存入
 *    (4) 如果桶不为空 比较对象引用 ||  equals() 比较
 *        - equals() == true → 认为重复，不存
 *        - equals() == false → 继续存（链表 / 红黑树）
 *
 *
 *    结论：
 *    HashSet 去重 = hashCode 相同 + equals 相同 才算重复
 *
 *
 * 2. TreeSet：
 *    - 底层依赖 TreeMap（红黑树）
 *    - 去重依赖：compareTo / Comparator.compare
 *
 *    执行流程：
 *    (1) 按比较规则进行排序插入
 *    (2) 如果 compare(result) == 0
 *        → 认为是重复元素，不存入
 *    (3) compare(result) < 0 → 左子树
 *    (4) compare(result) > 0 → 右子树
 *
 *    结论：
 *    TreeSet 去重 = compareTo / compare 返回 0 即认为重复
 *
 *
 * 3. 核心区别：
 *    - HashSet：看内容是否“相等”（equals）
 *    - TreeSet：看排序规则是否“相等”（compare == 0）
 *
 * </pre>
 *
 * @author pawamamama
 * @date 2026/7/1
 */
@SuppressWarnings({"all"})
public class homework04 {

    public static void main(String[] args) {

        // =========================
        // HashSet 示例（去重：hashCode + equals）
        // =========================
        Set<String> hashSet = new HashSet<>();

        hashSet.add("tom");
        hashSet.add("jack");
        hashSet.add("mary");
        hashSet.add("tom"); // 重复元素（被hashSet自动去重）

        System.out.println("HashSet结果：");
        for (String s : hashSet) {
            System.out.println(s);
        }

        // =========================
        // TreeSet 示例（去重：compareTo / compare）
        // =========================
        Set<String> treeSet = new TreeSet<>();

        treeSet.add("tom");
        treeSet.add("jack");
        treeSet.add("mary");
        treeSet.add("tom"); // compareTo == 0 → 判定重复

        System.out.println("\nTreeSet结果：");
        for (String s : treeSet) {
            System.out.println(s);
        }
    }
}