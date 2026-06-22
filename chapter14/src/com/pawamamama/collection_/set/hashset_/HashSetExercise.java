package com.pawamamama.collection_.set.hashset_;

import java.util.HashSet;
import java.util.Objects;

public class HashSetExercise {
    public static void main(String[] args) {
        HashSet<Employee> set = new HashSet<>();
        Employee e1 = new Employee("Tom", 18);
        Employee e2 = new Employee("Tom", 18);
        Employee e3 = new Employee("Jack", 18);
        set.add(e1);
        set.add(e2);
        // 与 e1 相等，不会重复添加
        set.add(e3);
        System.out.println(set.size()); // 2
        System.out.println(set);
    }
}

class Employee {
    private String name;
    private int age;

    public Employee(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    /**
     * 判断两个 Employee 对象是否相等
     * 判断标准：
     * 只要 name 和 age 都相同，就认为两个对象相等。
     */
    @Override
    public boolean equals(Object o) {

        // ① 如果传入对象为 null，肯定不相等
        if (o == null)
            return false;

        // ② 如果不是同一个类型，也不相等
        // 例如 Employee 和 Student，即使属性一样也不是同一种对象
        if (getClass() != o.getClass())
            return false;

        // ③ 将 Object 转换成 Employee，方便访问成员变量
        Employee employee = (Employee) o;

        // ④ 比较成员变量
        // age：基本类型，用 == 比较
        // name：引用类型，用 Objects.equals() 比较内容（还能防止 null）
        //相同返回 true 不同返回false
        return age == employee.age
                && Objects.equals(name, employee.name);
    }

    /**
     * 根据对象的重要属性生成哈希值。
     * <p>
     * HashMap、HashSet 会先调用 hashCode()
     * 找到对象应该存放的桶(bucket)。
     * <p>
     * 注意：
     * 如果 equals() 返回 true，
     * 那么 hashCode() 必须相同。
     */
    @Override
    public int hashCode() {

        // 根据 name 和 age 计算哈希值（原来是对象）
        // name 或 age 任意一个变化，hashCode 一般也会变化
        return Objects.hash(name, age);
        //name + age = 唯一hash值
        //
    }
}