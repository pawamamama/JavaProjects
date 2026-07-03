package com.pawamamama.generic;

import java.util.ArrayList;

/**
 * Class: Generic00
 *
 * <p>演示 Java 泛型与原始类型（raw type）的区别：
 *      1.不能对加入到集合 ArrayList中的数据类型进行约束（不安全）
 *      2.遍历的时候，转型，数据量大时候会影响效率
 * </p>
 *
 * <ul>
 *     <li>不使用泛型：需要强制类型转换，存在运行时风险</li>
 *     <li>使用泛型：编译期类型检查，避免 ClassCastException</li>
 * </ul>
 *
 * @author pawamamama
 * @date 2026/7/3
 */
@SuppressWarnings({"all"})
public class Generic00 {
    public static void main(String[] args) {

        // =========================
        // 1. 不使用泛型（原始类型）
        // =========================
        ArrayList list = new ArrayList();

        list.add(new Dog("A", 1));
        list.add(new Dog("B", 2));

        // 需要强转
        Dog d1 = (Dog) list.get(0);
        System.out.println(d1.getName() + " " + d1.getAge());

        // 如果乱加类型，会出问题
        list.add("hello"); // 编译不报错，但埋雷

        // Dog d2 = (Dog) list.get(2); // 运行时可能 ClassCastException


        // =========================
        // 2. 使用泛型（推荐）
        // =========================
        ArrayList<Dog> list2 = new ArrayList<>();

        list2.add(new Dog("C", 3));
        list2.add(new Dog("D", 4));

        // 不需要强转
        Dog d3 = list2.get(0);
        Dog d4 = list2.get(1);

        System.out.println(d3.getName() + " " + d3.getAge());
        System.out.println(d4.getName() + " " + d4.getAge());
    }
}

class Dog {
    private String name;
    private int age;

    public Dog(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "Dog{name='" + name + "', age=" + age + "}";
    }
}