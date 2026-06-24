package com.pawamamama.collection_.map_;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Class: MapSource
 *
 * <pre>
 * Map 结构底层源码分析示例：
 *
 * 目标：
 * 1. 理解 HashMap 存储结构（Node）
 * 2. 理解 entrySet / keySet / values 的本质
 * 3. 理解 Node 与 Map.Entry 的关系
 * </pre>
 *
 * @author pawamamama
 * @date 2026/6/24
 */
@SuppressWarnings({"all"})
public class MapSource {

    public static void main(String[] args) {

        Map<String, String> map = new HashMap<>();

        map.put("no1", "make");
        map.put("no2", "Jack");

        /**
         * =========================
         * 1. HashMap 存储结构本质
         * =========================
         *
         * put 过程：
         * HashMap 内部会创建 Node 对象：
         *
         * Node<K,V> implements Map.Entry<K,V>
         *
         * 真实存储位置：
         * table 数组 + 链表 / 红黑树
         */

        /**
         * =========================
         * 2. entrySet() 的本质
         * =========================
         *
         * entrySet 不是数据容器，而是：
         * 👉 HashMap 的“视图对象”
         *
         * 内部结构：
         * Set<Map.Entry<K,V>> entrySet;
         *
         * 实际实现类：
         * HashMap.EntrySet
         *
         * 特点：
         * - 不存数据
         * - 不复制 Node
         * - 依赖 HashMap.table
         */

        Set<Map.Entry<String, String>> set = map.entrySet();

        System.out.println("entrySet class = " + set.getClass());

        /**
         * =========================
         * 3. 遍历 entrySet
         * =========================
         *
         * 遍历流程：
         * HashMap.table(Node)
         *        ↓
         * Iterator.nextNode()
         *        ↓
         * 返回 Node
         *        ↓
         * 当作 Map.Entry 使用（多态）
         */
        for (Map.Entry<String, String> entry : set) {

            System.out.println(
                    "key = " + entry.getKey() +
                            " value = " + entry.getValue()
            );
        }

        /**
         * =========================
         * 4. keySet 视图
         * =========================
         *
         * 只暴露 key，不包含 value
         * 本质也是 HashMap 的视图
         */
        Set<String> keySet = map.keySet();
        System.out.println("keySet class = " + keySet.getClass());

        /**
         * =========================
         * 5. values 视图
         * =========================
         *
         * 只暴露 value
         * 同样不是副本，是实时视图
         */
        Collection<String> values = map.values();
        System.out.println("values class = " + values.getClass());
    }
}