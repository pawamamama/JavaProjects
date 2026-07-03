package com.pawamamama.generic;

import java.util.ArrayList;

/**
 * Class: Generic00
 *
 * <p>演示 Java 泛型与原始类型（raw type）的区别，以及泛型带来的核心优势。</p>
 *
 * <h2>一、背景说明</h2>
 * 在 Java 5 之前，集合（如 ArrayList）默认只能存储 Object 类型，
 * 因此任何对象放入集合后都会被“向上转型”为 Object，取出时必须强制类型转换。
 *
 * <h2>二、使用泛型前的问题（Raw Type）</h2>
 * <ul>
 *     <li>1. 类型不安全：可以向集合中随意加入不同类型的数据</li>
 *     <li>2. 取出数据必须强制类型转换（Object → 具体类型）</li>
 *     <li>3. 类型错误只能在运行时发现（ClassCastException）</li>
 *     <li>4. 编译器不会进行类型检查</li>
 * </ul>
 *
 * <p>例如：</p>
 * Dog -> Object（存入） -> Object（取出） -> Dog（强转）
 * 在取出时必须进行类型转换，否则无法使用子类特有方法
 *
 * <h2>三、使用泛型后的改进</h2>
 * <ul>
 *     <li>1. 编译期类型检查，保证只能存入指定类型</li>
 *     <li>2. 取出时自动转换，无需强转</li>
 *     <li>3. 避免 ClassCastException（类型安全）</li>
 *     <li>4. 提高代码可读性与维护性</li>
 * </ul>
 *
 * <p>例如：</p>
 * Dog -> Dog（存入） -> Dog（取出）
 * 全过程类型一致，不需要任何类型转换
 *
 * <h2>四、性能与效率说明</h2>
 * <ul>
 *     <li>1. 减少类型转换操作，提高执行效率（尤其在遍历时）</li>
 *     <li>2. 避免大量显式强转代码，提高代码简洁性</li>
 * </ul>
 *
 * <h2>五、总结</h2>
 * <ul>
 *     <li>泛型 = 编译期类型约束 + 自动类型推断</li>
 *     <li>Raw Type = 运行期靠开发者保证类型安全</li>
 *     <li>推荐始终使用泛型，避免原始类型</li>
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
        //1.ArrayList<Dog> 表示存放到 ArrayList 集合中的元素是 Dog类型
        //2.如果编译器发现添加的类型，不满足要求，就会报错
        //在遍历的时候可以直接取出dog类型而不是 Object类型
        ArrayList<Dog> list2 = new ArrayList<Dog>();

        list2.add(new Dog("C", 3));
        list2.add(new Dog("D", 4));

        System.out.println("使用泛型的for");
        for ( Dog dog : list2) {//直接取出
            System.out.println(dog.getName() + " " + dog.getAge());
        }
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