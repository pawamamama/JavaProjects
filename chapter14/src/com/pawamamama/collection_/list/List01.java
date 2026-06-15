package com.pawamamama.collection_.list;

import java.util.ArrayList;
import java.util.List;

/**
 * Class: List01
 *
 * <pre>
 * List 接口（Collection 子接口）核心特点：
 *
 * 1. 有序（添加顺序 = 取出顺序）
 *    - 允许重复元素
 *
 * 2. 每个元素都有索引（支持下标访问）
 *    - 可以通过 index 获取元素
 *
 * 3. List 中元素按整数索引存储
 *    - 从 0 开始编号
 *    - 支持根据索引获取 / 修改 / 删除
 *
 * 4. 常见实现类：
 *    - ArrayList：底层数组，查询快
 *    - LinkedList：底层链表，增删快
 *    - Vector：线程安全（已过时）
 *
 * 5. 常用方法：
 *    - add(E e)          添加元素
 *    - add(int index,E)  指定位置插入
 *    - get(int index)    获取元素
 *    - set(int index,E)  修改元素
 *    - remove(int index) 删除元素
 *    - size()            获取长度
 *
 * 6. 示例：
 *    List list = new ArrayList();
 *    list.add("tom");
 *    list.add("jack");
 *    list.add("mary");
 *
 *    System.out.println(list);
 *    System.out.println(list.get(2)); // mary
 *
 * </pre>
 *
 * @author pawamamama
 * @date 2026/6/15
 */
public class List01 {
    @SuppressWarnings({"all"})
    public static void main(String[] args) {
        ///1. 有序添加顺序 = 取出顺序 一致 而且允许重复元素
        List list = new ArrayList();
        list.add("mama");
        list.add("pawa");
        list.add("pawa");
        System.out.println(list);
        //2. 每个元素都有索引（支持下标访问）从零开始
        System.out.println(list.get(0));
        System.out.println(list.get(1));
    }

}