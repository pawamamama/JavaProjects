package com.pawamamama.collection_;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Class: CollectionExercise
 *
 * <pre>
 * </pre>
 *
 * @author pawamamama
 * @date 2026/6/15
 */
@SuppressWarnings({"all"})
public class CollectionExercise {
    public static void main(String[] args) {
        List list = new ArrayList();
        list.add(new Dog("吴俊希", 100));
        list.add(new Dog("张三", 80));
        list.add(new Dog("李四", 90));
        list.add(new Dog("王五", 70));
        list.add(new Dog("赵六", 85));
        //1.迭代器
        //1.1获取迭代器
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            Object next =  iterator.next();
            System.out.println(next);
        }
        System.out.println("===========================");
        //2.for增强
        for (Object o :list) {
            System.out.println(o);
        }

    }

}
class Dog {
    private String name;
    private int age;
    public Dog(String name, int age) {
        this.name = name;
        this.age = age;
    }
    @Override
    public String toString() {
        String str = "Dog: " + name + ", age: " + age;
        return str;
    }
}