package com.pawamamama.collection_.map_;

import java.util.HashMap;
import java.util.Map;

/**
 * Class: Map_
 * <p>
 * 核心笔记整理（JDK8 Map 接口特点）：
 * 1) Map与Collection并列存在。用于保存具有映射关系的数据: Key-Value (双列元素)
 * 2) Map中的 key 和 value 可以是任何引用类型的数据，会封装到HashMap$Node对象中
 * 3) Map中的 key 不允许重复，原因和HashSet一样（底层使用hashCode和equals判断）
 * 4) Map中的 value 可以重复
 * 5) Map的key可以为null，value也可以为null。注意：key为null只能有一个，value为null可以多个
 * 6) 常用String类作为Map的key
 * 7) key和value之间存在单向一对一关系，即通过指定的key总能找到对应的value
 *
 * @author pawamamama
 * @date 2026/6/24
 */
@SuppressWarnings({"all"})
public class Map_ {
    public static void main(String[] args) {
        // 1. Map 与 Collection 并列存在，保存 Key-Value 键值对
        // 6. 常用 String 类作为 Map 的 key
        Map map = new HashMap<>();

        // 2. key 和 value 可以是任何引用类型
        map.put("id", 1001); // 自动装箱为 Integer 引用类型
        map.put("name", "Jack");

        // 3. key 不允许重复（若重复，新 value 会覆盖旧 value）
        map.put("id", 1002); // 此时 "id" 对应的 value 变为 1002

        // 4. value 可以重复
        map.put("nickname", "Jack"); // "name" 和 "nickname" 的 value 都是 "Jack"

        // 5. key只能有  一个 null，value 可以有多个 null
        map.put(null, "nullValue");
        map.put(null, "newNullValue"); // 覆盖前一个 null key
        map.put("empty1", null);
        map.put("empty2", null); // 多个 key 的 value 都可以是 null
        //6.通过get方法传入一个K会返回对应的V
        System.out.println(map.get("id"));//1002
        System.out.println(map);
    }
}