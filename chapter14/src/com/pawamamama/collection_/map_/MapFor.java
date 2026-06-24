package com.pawamamama.collection_.map_;

import java.util.*;

/**
 * Class: MapFor
 *
 * <pre>
 * </pre>
 *
 * @author pawamamama
 * @date 2026/6/24
 */
@SuppressWarnings({"all"})
public class MapFor {
    public static void main(String[] args) {
        Map map = new HashMap();
        map.put("邓超", "孙俪");
        map.put("王宝强", "马蓉");
        map.put("宋喆", "马蓉");
        map.put("刘令博", null);
        map.put(null, "刘亦菲");
        map.put("鹿晗", "关晓彤");
        //第一组: 先取出所有的Key , 通过Key 取出对应的Value
        Set keyset = map.keySet();
        //(1) 增强for
        System.out.println("======第一种方式=======");
        for (Object key : keyset) {
            System.out.println(key + ": " + map.get(key));

        }
        //(2) 迭代器
        System.out.println("======第二种方式=======");
        Iterator iterator = keyset.iterator();
        while (iterator.hasNext()) {
            Object key = iterator.next();

        }
        //第二组 获取Value 但是获取不了key
        Collection values = map.values();
        //可以使用所有 Collection使用的遍历方法
        //(1) 增强for
        for (Object value : values) {
            System.out.println(value);
        }
        //(2) 迭代器
        Iterator iterator1 = values.iterator();
        while (iterator1.hasNext()) {
            Object value = iterator1.next();
            System.out.println(value);
        }
        //通过 entrySet 获取 k-v
        Set set = map.entrySet();
        // (1) 增强 for 遍历 EntrySet
        System.out.println("====使用EntrySet 的 增强for");
        for (Object o : set) {  // 本质：增强 for = Iterator 语法糖

            /*
             * ① set 来源：
             * map.entrySet()
             *
             * entrySet() 返回的是 HashMap 的 EntrySet 视图（view）
             * 不是数据拷贝，而是“映射到 HashMap 内部结构”的集合
             *
             * 底层结构链路：
             * HashMap
             *   ↓
             * Node<K,V>[] table（数组）
             *   ↓
             * Node（链表 / 红黑树节点）
             *   ↓
             * EntrySet（对 Node 的封装视图）
             *   ↓
             * Iterator（HashIterator）
             */

            /*
             * ② 增强 for 底层机制：
             * 等价于：
             *
             * Iterator it = set.iterator();
             * while (it.hasNext()) {
             *     Object o = it.next();
             * }
             */

            /*
             * ③ set 中的元素本质：
             * Map.Entry<K,V> 的实现对象
             *
             * 在 HashMap 中运行时实际是：
             * - HashMap$Node（链表节点）
             * - 或 HashMap$TreeNode（红黑树节点）
             *
             * 但对外统一暴露为 Map.Entry 接口
             * （封装内部结构，避免直接操作 Node）
             */

            Map.Entry entry = (Map.Entry) o;

            // ④ 通过 Entry 接口方法获取 key-value
            System.out.println(entry.getKey() + ":" + entry.getValue());
        }
        //(2)迭代器
        Iterator iterator3 = set.iterator();
        while (iterator3.hasNext()) {
            //转型
            Map.Entry entry = (Map.Entry)iterator3.next();//next()返回Object
            System.out.println(entry.getKey() + ":" + entry.getValue());
        }

    }

}