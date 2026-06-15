package com.pawamamama.collection_;
import java.util.ArrayList;
import java.util.Collection;

/**
 * Class: CollectionFor
 *
 * <pre>
 *     for循环增强（foreach）
 *
 *     本质：迭代器 Iterator 的简化写法
 *     只能用于：数组 / 集合
 * </pre>
 *
 * @author pawamamama
 * @date 2026/6/15
 */
public class CollectionFor {

    public static void main(String[] args) {

        // 创建集合
        Collection<Book2> col = new ArrayList<>();

        // 添加数据
        col.add(new Book2("Java基础", 50));
        col.add(new Book2("数据结构", 80));
        col.add(new Book2("算法", 120));

        // =========================
        // 增强 for 循环（核心）
        // =========================
        for (Book2 book : col) {
            System.out.println(book);
        }
        //增强 for 遍历数组
        int[] arr = {10, 20, 30, 40, 50};
        for (int num : arr) {
            System.out.println(num);
        }
    }
}

/**
 * Book 类
 */
class Book2 {
    String name;
    int price;

    public Book2(String name, int price) {
        this.name = name;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Book{name='" + name + "', price=" + price + "}";
    }
}