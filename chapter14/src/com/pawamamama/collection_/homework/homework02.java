package com.pawamamama.collection_.homework;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Class: homework02
 *
 * <pre>
 * 作业说明：
 * 本练习主要测试 ArrayList 常用 API 的使用
 *
 * 涉及内容：
 * 1. add / addAll（添加元素）
 * 2. remove（删除元素）
 * 3. contains / containsAll（判断是否包含）
 * 4. size（获取长度）
 * 5. isEmpty（判断是否为空）
 * 6. clear（清空集合）
 * 7. 遍历方式：
 *    - 增强for循环
 *    - Iterator 迭代器
 *
 * 目的：
 * 熟悉 ArrayList 常用操作及遍历方式
 * </pre>
 *
 * @author pawamamama
 * @date 2026/6/30
 */
@SuppressWarnings({"all"})
public class homework02 {

    public static void main(String[] args) {

        // =========================
        // 1️⃣ 创建 Car 对象
        // =========================
        Car car = new Car("宝马", 400000);
        Car car2 = new Car("法拉利", 90909090);
        Car car3 = new Car("pawa", 112212090);

        // =========================
        // 2️⃣ ArrayList 基本操作
        // =========================
        ArrayList arrayList = new ArrayList();

        arrayList.add(car);
        arrayList.add(car2);
        arrayList.add(car3);

        // 删除索引为1的元素
        System.out.println("remove(1) = " + arrayList.remove(1));

        // 输出当前集合
        System.out.println("list = " + arrayList);

        // 判断是否包含某个对象（基于 equals）
        System.out.println("contains(car) = " + arrayList.contains(car));

        // 获取大小
        System.out.println("ArrayList.size = " + arrayList.size());

        // 判断是否为空
        System.out.println("isEmpty = " + arrayList.isEmpty());

        // 清空集合
        arrayList.clear();
        System.out.println("clear后 = " + arrayList);

        // =========================
        // 3️⃣ addAll / containsAll
        // =========================
        List list = new ArrayList();
        list.add(car);
        list.add(car2);
        list.add(car3);

        // 批量添加
        arrayList.addAll(list);
        System.out.println("addAll后 = " + arrayList);

        // 判断是否包含整个集合
        System.out.println("containsAll = " + arrayList.containsAll(list));

        // =========================
        // 4️⃣ 遍历方式 1：增强 for
        // =========================
        System.out.println("增强for遍历：");
        for (Object o : arrayList) {
            System.out.println(o);
        }

        // =========================
        // 5️⃣ 遍历方式 2：Iterator
        // =========================
        System.out.println("Iterator遍历：");
        Iterator iterator = arrayList.iterator();
        while (iterator.hasNext()) {
            Object next = iterator.next();
            System.out.println(next);
        }
    }
}

/**
 * Car 类（汽车实体类）
 *
 * 用于演示 ArrayList 存储自定义对象
 */
class Car {

    private String name;   // 汽车名称
    private double price;  // 汽车价格

    /**
     * 构造器
     *
     * @param name  汽车名称
     * @param price 汽车价格
     */
    public Car(String name, double price) {
        this.name = name;
        this.price = price;
    }

    /**
     * 输出对象信息
     */
    @Override
    public String toString() {
        return "Car{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}