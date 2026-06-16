package com.pawamamama.collection_.list;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ListTraverse {

    public static void main(String[] args) {

        // 创建 List（多态写法）
        List<String> list = new ArrayList<>();

        list.add("A");
        list.add("B");
        list.add("C");
        list.add("D");

        System.out.println("=== 方式1：普通 for 循环（下标遍历）===");
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }

        System.out.println("=== 方式2：增强 for（for-each）===");
        for (String s : list) {
            System.out.println(s);
        }

        System.out.println("=== 方式3：Iterator 迭代器遍历 ===");
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            String s = it.next();
            System.out.println(s);
        }
    }
}