package com.pawamamama.collection_.map_;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Map 接口常用方法演示
 *
 * <p>涵盖内容：
 * <ul>
 *     <li>put（添加 / 替换）</li>
 *     <li>remove（删除）</li>
 *     <li>get（获取）</li>
 *     <li>size（大小）</li>
 *     <li>isEmpty（是否为空）</li>
 *     <li>clear（清空）</li>
 *     <li>containsKey（是否包含键）</li>
 * </ul>
 *
 * @author demo
 */
@SuppressWarnings({"all"})
public class MapMethod{

    public static void main(String[] args) {

        // 创建 HashMap（多态写法）
        Map<String, Object> map = new HashMap<>();

        // put：添加键值对
        map.put("A", new Book("Java基础", 100));
        map.put("A", "B"); // key重复 → value覆盖（替换）

        map.put("B", "ValueB");
        map.put("C", "ValueC");
        map.put("D", null);
        map.put(null, "NullKeyValue");
        map.put("E", "ValueE");
        map.put("F", "ValueF");

        System.out.println("map = " + map);

        // remove：根据 key 删除
        map.remove(null);
        System.out.println("after remove null key: " + map);

        // get：根据 key 获取 value
        Object value = map.get("E");
        System.out.println("get E = " + value);

        // size：元素个数
        System.out.println("size = " + map.size());

        // isEmpty：是否为空
        System.out.println("isEmpty = " + map.isEmpty());

        // clear：清空所有元素
        // map.clear();
        // System.out.println("after clear = " + map);

        // containsKey：是否存在某个 key
        System.out.println("containsKey('F') = " + map.containsKey("F"));

    }
}

/**
 * 简单 Book 类（用于测试 value 存储对象）
 */
class Book {

    /** 书名 */
    private String name;

    /** 数量 / 编号 */
    private int num;

    /**
     * 构造方法
     *
     * @param name 书名
     * @param num  数量或编号
     */
    public Book(String name, int num) {
        this.name = name;
        this.num = num;
    }

    /**
     * 字符串表示
     */
    @Override
    public String toString() {
        return "Book{name='" + name + "', num=" + num + "}";
    }
}