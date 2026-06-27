package com.pawamamama.collection_.map_.hashmap;

import java.util.HashMap;
/**
 * HashMap 小结 + 示例
 *<pre>
 * 1. Map常见实现：HashMap / Hashtable / Properties
 * 2. HashMap是最高效的Map实现
 * 3. 底层结构：JDK8后 数组 + 链表 + 红黑树
 * 4. key不能重复，value可以重复，可存null
 * 5. 如果key重复，会覆盖旧value（本质是修改操作）
 * 6. 不保证顺序（与HashSet类似）
 * 7. 线程不安全，没有synchronized
 *
 * 小结：
 * HashMap以 key-value 方式存储数据，
 * 当 key 重复时不会新增节点，而是替换旧 value。</pre>
 */
  @SuppressWarnings({"all"})
public class HashMapDemo {

    public static void main(String[] args) {

        HashMap<String, String> map = new HashMap<>();

        // 第一次放入
        map.put("1001", "张三");
        map.put("1002", "李四");

        System.out.println("初始：" + map);

        // key重复 —— 演示第5点：覆盖value
        String oldValue = map.put("1001", "王五");

        System.out.println("覆盖后：" + map);
        System.out.println("被替换掉的旧value：" + oldValue);
    }
}