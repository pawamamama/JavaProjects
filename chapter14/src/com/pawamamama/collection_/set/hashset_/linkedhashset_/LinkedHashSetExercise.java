package com.pawamamama.collection_.set.hashset_.linkedhashset_;

import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;

/**
 * Class: LinkedHashSetExercise
 *
 * <pre>
 * LinkedHashSet 特性演示：
 * 1. 底层：HashMap + LinkedList
 * 2. 特点：
 *    - 不允许重复（依赖 hashCode + equals）
 *    - 保持插入顺序（Linked 结构）
 * 3. 应用场景：
 *    - 既要去重，又要保持顺序的数据结构
 * </pre>
 *
 * @author pawamamama
 * @date 2026/6/24
 */
public class LinkedHashSetExercise {

    public static void main(String[] args) {

        Set<Car> cars = new LinkedHashSet<>();

        cars.add(new Car("BMW", 500000));
        cars.add(new Car("Tesla", 300000));
        cars.add(new Car("Toyota", 200000));

        // 重复对象（name + price 相同）
        cars.add(new Car("BMW", 500000));

        // 输出
        System.out.println("LinkedHashSet内容：");
        for (Car car : cars) {
            System.out.println(car);
        }
    }
}

/**
 * Car 类：
 * 用于演示 LinkedHashSet 去重机制
 */
class Car {
    private String name;
    private double price;

    public Car(String name, double price) {
        this.name = name;
        this.price = price;
    }

    /**
     * hashCode：用于快速定位桶位置
     */
    @Override
    public int hashCode() {
        return Objects.hash(name, price);
    }

    /**
     * equals：用于解决 hash 冲突后的精确比较
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        Car other = (Car) obj;
        return Double.compare(price, other.price) == 0
                && Objects.equals(name, other.name);
    }

    /**
     * toString：方便打印对象内容
     */
    @Override
    public String toString() {
        return "Car{name='" + name + "', price=" + price + "}";
    }
}