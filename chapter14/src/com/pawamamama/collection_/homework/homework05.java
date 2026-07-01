package com.pawamamama.collection_.homework;

import java.util.TreeSet;

/**
 * Class: homework05
 *
 * <pre>
 * TreeSet 底层机制与类型要求说明：
 *
 * 1. TreeSet 底层结构：
 *    - 基于 TreeMap 实现
 *    - 底层是 红黑树（自平衡二叉搜索树）
 *
 * 2. TreeSet 特点：
 *    - 自动排序
 *    - 自动去重（依赖比较规则）
 *
 * 3. 去重与排序规则：
 *    - 依赖 compareTo() 或 Comparator.compare()
 *    - 如果 compare(result) == 0 → 判定为重复元素
 *
 * 4. 重要限制（本例错误原因）：
 *    - 存入 TreeSet 的对象必须“可比较”
 *    - 即：
 *        ✔ 实现 Comparable 接口
 *        或
 *        ✔ 提供 Comparator
 *
 * 5. 本代码错误分析：
 *    - person 类没有实现 Comparable 接口
 *    - TreeSet 在插入时需要调用 compareTo
 *    - 由于无法比较 → 运行时报 ClassCastException
 *
 * 6. 本质原因：
 *    TreeSet 在插入元素时会进行强制比较：
 *    (1) 将新元素与已有节点比较
 *    (2) 若对象不可比较 → 直接抛异常
 *
 * 7. 结论：
 *    TreeSet 不允许“不可排序对象”直接存入
 *
 * </pre>
 *
 * @author pawamamama
 * @date 2026/7/1
 */
@SuppressWarnings({"all"})
public class homework05 {

    public static void main(String[] args) {

        TreeSet treeSet = new TreeSet();

        // 尝试存入 person 对象
        treeSet.add(new person());

        /*
         * ❗运行结果：ClassCastException（类型转换异常）
         *
         * 原因：
         * TreeSet 在插入元素时会进行比较操作：
         *
         *   (1) 试图将元素转换为 Comparable
         *   (2) 调用 compareTo() 方法
         *
         * 但 person 类：
         *   - 没有实现 Comparable 接口
         *   - 没有 compareTo 方法
         *
         * 所以在运行时发生异常：
         *
         *   java.lang.ClassCastException:
         *   person cannot be cast to java.lang.Comparable
         *
         * 本质：
         * TreeSet 要求元素必须“可排序”
         */
    }
}

/**
 * class person
 *
 * <pre>
 * 当前类问题：
 * - 没有实现 Comparable 接口
 * - 不能提供自然排序规则
 * - 因此不能直接存入 TreeSet
 *
 * 正确做法：
 * 1. 实现 Comparable<Person>
 *    或
 * 2. 创建 TreeSet 时传入 Comparator
 * </pre>
 */
class person {
}