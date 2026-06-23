package com.pawamamama.collection_.set.hashset_.linkedhashset_;

import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

/**
 * Class: LinkedHashSetSource
 * LinkedHashSet 底层源码与实现机制分析。
 *
 * <pre>
 * LinkedHashSet 底层原理：
 *
 * 1. LinkedHashSet 继承自 HashSet。
 * 2. HashSet 内部维护一个 Map，而 LinkedHashSet 将该 Map 替换为 LinkedHashMap。
 * 3. 底层数据结构：
 *    - Hash 表（数组 table）数组是 HashMap$Node[] 存放的是 LindedHashMap$Entry 类型，多态现象
 *
 *    - 桶（Bucket）
 *    - 节点不是 Node 是 LindedHashMap$Entry 类型
 *          Entry 是 LinkedHashMap的静态内部类，该类继承了HashMap.Node类
 *              所以能用 HashMap$Node[]类型的数组有继承关系（继承关系是在类的内部发生）
 *    - 单向链表（next，用于解决 Hash 冲突）
 *    - 红黑树（树化后，提高查找效率）
 *    - 全局双向链表（before、after，维护插入顺序）
 *
 * 4. 节点(Node)维护的信息：
 *    hash      ：元素哈希值
 *    key       ：存储的元素
 *    value     ：固定为 PRESENT（HashSet 特点）
 *    next      ：桶中的下一节点
 *    before    ：双向链表前驱节点
 *    after     ：双向链表后继节点
 *
 * 5. LinkedHashMap 维护：
 *    - table[] 数组
 *    - head（双向链表头节点）
 *    - tail（双向链表尾节点）
 *
 * 6. 维护两条逻辑结构：
 *    (1) Hash 桶中的 next 链（或红黑树）
 *        用于根据 hash 快速定位元素，平均查找 O(1)。
 *
 *    (2) 全局双向链表（before、after）
 *        用于维护元素的插入顺序，使遍历顺序与插入顺序一致。
 *
 * 7. 添加元素流程：
 *    (1) 计算 hash 值。
 *    (2) 定位到 table 对应桶。
 *    (3) 判断元素是否已存在。
 *    (4) 不存在则插入桶中。
 *    (5) 同时追加到双向链表尾部。
 *
 * 8. 树化机制：
 *    - 桶中节点数量 >= 8
 *    - table 长度 >= 64
 *    满足条件后，桶中的单向链表转换为红黑树。
 *    双向链表不会发生变化，仍负责维护遍历顺序。
 *
 * 9. 特点：
 *    - 元素唯一，不允许重复。
 *    - 保证插入顺序。
 *    - 查找效率接近 HashSet。
 *    - 比 HashSet 占用更多内存（维护 before、after）。
 *
 * 本类用于阅读 LinkedHashSet / LinkedHashMap 源码，理解其底层实现机制。
 * </pre>
 *
 * @author pawamamama
 * @date 2026/6/23
 */
@SuppressWarnings({"all"})
public class LinkedHashSetSource {
    public static void main(String[] args) {

        Set set = new LinkedHashSet();

        set.add("AA");
        set.add(456);
        set.add(123);
        set.add("HSP");

        // 重复元素
        set.add(456);
        set.add("AA");

        // 自定义对象
        set.add(new Customer("刘", 18));
        set.add(new Customer("张", 20));

        System.out.println(set);
    }
}

class Customer {

    private String name;
    private int age;

    public Customer(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}