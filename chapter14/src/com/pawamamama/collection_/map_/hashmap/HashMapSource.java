package com.pawamamama.collection_.map_.hashmap;

import java.util.HashMap;

/**
 * Class: HashMapSource
 *
 * <pre>
 * =========================
 * HashMap 底层结构与原理
 * =========================
 *
 * 1. 底层数据结构
 *    - JDK7：数组 + 单向链表
 *    - JDK8：数组 + 链表 + 红黑树
 *
 * 2. 核心结构
 *    Node<K,V>[] table
 *    Node 实现 Map.Entry<K,V>
 *
 *    Node包含：
 *    - int hash
 *    - K key
 *    - V value
 *    - Node next（用于链表）
 *
 * ------------------------------------
 * 3. put(K,V) 执行流程
 * ------------------------------------
 * ① 计算 key 的 hash 值（扰动函数优化）
 * ② 通过 (n - 1) & hash 计算索引位置
 * ③ 判断 table[index]：
 *
 *    情况1：null
 *       -> 直接创建 Node 放入
 *
 *    情况2：非 null（发生 hash 冲突）
 *       -> 判断 key 是否相同
 *          - 相同：直接覆盖 value
 *          - 不同：挂到链表或红黑树
 *
 * ④ 链表处理：
 *    - JDK7：头插法
 *    - JDK8：尾插法
 *
 * ⑤ 树化条件（JDK8）：
 *    - 链表长度 >= TREEIFY_THRESHOLD (默认 8)
 *    - 且 table容量 >= MIN_TREEIFY_CAPACITY (默认 64)
 *    -> 转为红黑树
 *
 * ------------------------------------
 * 4. 扩容机制 resize()
 * ------------------------------------
 * - 默认容量：16
 * - 负载因子：0.75
 * - 阈值 threshold = capacity * loadFactor
 *
 * 当 size > threshold 时触发扩容：
 *    - capacity 扩大为 2 倍
 *    - threshold 也同步翻倍
 *    - 所有元素重新 hash 分布（rehash）
 *
 * ------------------------------------
 * 5. 为什么容量必须是 2 的幂？
 * ------------------------------------
 * - index = (n - 1) & hash
 * - 2的幂可以让 n-1 二进制全为 1
 * - 保证 hash 分布均匀，减少冲突
 *
 * ------------------------------------
 * 6. hash 冲突解决策略
 * ------------------------------------
 * - 链表法（拉链法）
 * - 红黑树优化（高冲突场景）
 *
 * ------------------------------------
 * 7. JDK7 vs JDK8 核心区别
 * ------------------------------------
 * JDK7：
 *   数组 + 链表（头插法）
 *   扩容容易倒序
 *
 * JDK8：
 *   数组 + 链表 + 红黑树（尾插法）
 *   结构更稳定，查询优化
 *
 * </pre>
 *
 * @author pawamamama
 * @date 2026/6/26
 */
@SuppressWarnings({"all"})
public class HashMapSource {
    public static void main(String[] args) {
        HashMap map = new HashMap();
        map.put("java",10);
        map.put("php",10);
        map.put("java",20);
        System.out.println(map);
    }
}