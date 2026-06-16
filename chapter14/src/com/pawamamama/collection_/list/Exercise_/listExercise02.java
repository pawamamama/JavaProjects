package com.pawamamama.collection_.list.Exercise_;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;


/**
 * Class: listExercise02
 *
 * <p>
 * 本类用于演示 List 集合的基本操作以及自定义排序算法的实现。
 * 示例中使用冒泡排序（Bubble Sort）按照 Book 的 price 进行升序排序。
 * </p>
 *
 * <p>
 * 涉及知识点：
 * <ul>
 *     <li>List 的基本使用</li>
 *     <li>Object 向下转型</li>
 *     <li>集合元素交换（set）</li>
 *     <li>简单排序算法（冒泡排序）</li>
 * </ul>
 * </p>
 *
 * @author pawamamama
 * @date 2026/6/16
 */
public class listExercise02 {
    public static void main(String[] args) {
        List books = new ArrayList<>();
        books.add(new Book("Book One", 210));
        books.add(new Book("Book Two", 30));
        books.add(new Book("Book Three", 400));
        books.add(new Book("Book four", 40));


        //使用
        sort(books);
        System.out.println("排序后");
        for (Object book : books) {
            System.out.println(book);
        }
    }

    public static void sort(List list) {
        int size = list.size();
        for (int i = 0; i < size - 1; i++) {
            for (int j = i; j < size - 1 - i; j++) {
                //取处对象向下转型
                Book book1   = (Book) list.get(j);
                Book book2   = (Book) list.get(j + 1);
                if (book1.getPrice() > book2.getPrice()) {
                    //这里不用tmp保存已经有book指向了
                   list.set(j, book2);
                   list.set(j+1, book1);
                }
            }
        }
    }

}

class Book {
    String name;
    int price;

    public Book(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public int getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Book{name='" + name + "', price=" + price + "}";
    }
}