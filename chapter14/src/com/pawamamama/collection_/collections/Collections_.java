package com.pawamamama.collection_.collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
/**
 * Collections 工具类说明
 *
 * <p>Collections 是 Java 提供的一个操作集合（Set、List、Map等）的工具类</p>
 *
 * <p>主要功能：</p>
 * <ul>
 *     <li>提供一系列静态方法，用于对集合进行排序、查找、修改等操作</li>
 * </ul>
 *
 * <p>注意：Collections 中的方法全部为 static 方法</p>
 */
@SuppressWarnings({"all"})
public class Collections_ {
    public static void main(String[] args) {
        //创建ArrayList 用于测试
        List list = new ArrayList();
        list.add("tom");
        list.add("jack");
        list.add("lucy");

        System.out.println("原始：" + list);

        // 1. reverse 反转
        Collections.reverse(list);
        System.out.println("reverse：" + list);

        // 2. shuffle 随机打乱
        for (int i = 0; i < 5; i++) {
            Collections.shuffle(list);
            System.out.println("shuffle：" + list);

        }
        // 3. sort 自然排序（升序）
        Collections.sort(list);
        System.out.println("sort：" + list);

        // 4. swap 交换 0 和 1
        Collections.swap(list, 0, 1);
        System.out.println("swap：" + list);

        // 5. sort + Comparator（字符串长度大小来排序）
        Collections.sort(list, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.length() - o2.length(); // 升序
            }
        });

        System.out.println("自定义排序(字符串长度大小来排序)：" + list);
    }
}