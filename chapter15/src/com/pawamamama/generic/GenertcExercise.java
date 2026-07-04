package com.pawamamama.generic;

import java.util.*;
/**
 * Class: GenertcExercise
 *
 * <p>
 * 本类用于演示 Java 集合框架中泛型的综合使用，包括：
 * </p>
 *
 * <ul>
 *     <li>HashMap&lt;String, Student&gt; 的使用</li>
 *     <li>keySet() 遍历方式</li>
 *     <li>values() + Iterator 遍历方式</li>
 *     <li>entrySet()（推荐方式）遍历 Map</li>
 *     <li>HashSet + Iterator 遍历</li>
 * </ul>
 *
 * <h2>核心目的</h2>
 * <p>
 * 1. 理解泛型在集合中的作用（类型安全 + 消除强转）<br>
 * 2. 掌握 Map 三种遍历方式的区别与性能特点<br>
 * 3. 掌握 Set + Iterator 的标准使用方式
 * </p>
 *
 * <h2>Map 遍历方式总结</h2>
 * <ul>
 *     <li>keySet()：通过 key 再 get value（两次操作）</li>
 *     <li>values()：只遍历 value（无法获取 key）</li>
 *     <li>entrySet()：同时获取 key + value（推荐）</li>
 * </ul>
 *
 * <h2>entrySet 推荐原因</h2>
 * <p>
 * entrySet() 直接操作 Map.Entry，避免重复查找 key，提高遍历效率
 * </p>
 *
 * @author pawamamama
 * @date 2026/7/3
 */
@SuppressWarnings({"all"})
public class GenertcExercise {
    public static void main(String[] args) {
        //1.创建5个学生对象
        // 1. 创建5个学生对象
        Student s1 = new Student(1, "Alice");
        Student s2 = new Student(2, "Bob");
        Student s3 = new Student(3, "Cathy");
        Student s4 = new Student(4, "David");
        Student s5 = new Student(5, "Eve");
        //2.使用泛型 HashMap，此时已指定k-v
        HashMap<String, Student> map = new HashMap<>();
        map.put("s1", s1);
        map.put("s2", s2);
        map.put("s3", s3);
        map.put("s4", s4);
        map.put("s5", s5);
        //遍历并toString
        //1.增强for这里使用keySet (泛型为 String)
        Set<String> strings = map.keySet();
        for (String key : strings) {
            //取出value，此时map已经定义过泛型所以不用转换,get方法返回值就是Student，毋庸置疑
            Student value = map.get(key);
            System.out.println(key + ": " + value.toString());
        }
        //2.使用迭代器获取values
        Iterator<Student> iterator = map.values().iterator();
        while (iterator.hasNext()) {
            Student value = iterator.next();
            System.out.println(value + ": " + value.toString());
        }
        // 使用 entrySet() 获取 Map 的键值对集合（推荐方式）
        // Map.Entry<K, V> 表示 Map 中的一条“键值对记录”
        // 这里 K = String（key类型），V = Student（value类型）
        Set<Map.Entry<String, Student>> entries = map.entrySet();
        //HashMap已经指定过了k-v 所以entrySet 自动填充k-v
        //Set存放Map.Entry类型
        //Map.Entry里存放k and v 并且是指定类型，编译器知道所以不用转型
        //增强for
        for (Map.Entry<String, Student> entry : entries) {
            System.out.println(entry.getKey() + ": " + entry.getValue().toString());
        }
        //迭代器
        Iterator<Map.Entry<String, Student>> iterator2 = entries.iterator();
        while (iterator2.hasNext()) {//取出时就是Map.Entry<String, Student>
            Map.Entry<String, Student> entry = iterator2.next();
            System.out.println(entry.getKey() + ": " + entry.getValue().toString());
        }
        //hashSet
        HashSet<Student> students = new HashSet<>();
        students.add(s1);
        students.add(s2);
        students.add(s3);
        students.add(s4);
        students.add(s5);
        //增强for
        for (Student value : students) {
            System.out.println(value.toString());
        }
        //使用迭代器
        Iterator<Student> iterator1 = students.iterator();//接口泛型
        while (iterator1.hasNext()) {
            Student value = iterator1.next();//取出不用转型
            System.out.println(value.toString());
        }

    }
}

class Student {
    int id;
    String name;

    public Student(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}