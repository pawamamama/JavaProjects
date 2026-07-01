package com.pawamamama.collection_.homework;

import java.util.HashSet;

/**
 * Class: homework06
 *
 * <pre>
 * 本题核心考点：
 *
 * 1. HashSet 底层是 HashMap
 * 2. Person 重写 hashCode + equals
 * 3. hashCode 依赖字段：id + name
 * 4. 修改 name 会改变 hashCode → 影响桶位置
 *
 * 关键结论：
 * 修改参与 hashCode 的字段后：
 * → 对象“逻辑相等”，但“物理位置不一致”
 * → remove / add 都可能失败或产生重复数据
 *
 * </pre>
 */
@SuppressWarnings({"all"})
public class homework06 {

    public static void main(String[] args) {

        // =========================
        // 1. 初始状态（插入两个对象）
        // =========================

        HashSet set = new HashSet();

        // p1：id=1001, name=AA
        Person p1 = new Person(1001, "AA");

        // p2：id=1002, name=BB
        Person p2 = new Person(1002, "BB");

        // add p1
        set.add(p1);  // hash(p1)=1001+AA → 放入桶A

        // add p2
        set.add(p2);  // hash(p2)=1002+BB → 放入桶B

        // =========================
        // 2. 修改 p1.name
        // =========================

        // ⚠️关键点：name 是 hashCode 参与字段
        // 所以修改后 hashCode 会变化
        p1.name = "CC";

        /*
         * 此时发生了什么：
         *
         * 修改前：
         *   p1 -> hash(1001,"AA") -> 桶位置 A
         *
         * 修改后：
         *   p1 -> hash(1001,"CC") -> 新桶位置 C
         *
         * ❗问题：
         * HashSet 中仍然存放的是“旧位置的 p1”
         * 但 p1 本身已经“变成另一个 hash 值”
         *
         * → 导致：逻辑上还在 set，但物理定位失效
         */

        // =========================
        // 3. remove(p1)（删除失败）
        // =========================

        set.remove(p1);

        /*
         * remove 流程：
         *
         * (1) 计算 p1 当前 hash（1001,CC）
         * (2) 去新桶位置 C 查找
         * (3) 但真正存储的是旧桶 A
         *
         * → 找不到 → 删除失败
         *
         * ❗结论：
         * 修改 hashCode 参与字段后：
         * remove 会失效
         */

        System.out.println(set); // 输出：2（p1还在，p2正常）

        // =========================
        // 4. 添加 new Person(1001,"CC")
        // =========================

        set.add(new Person(1001, "CC"));

        /*
         * 分析：
         *
         * 新对象：
         *   hash(1001,"CC")
         *
         * set 中已有：
         *   p2
         *   p1（旧位置，hash(AA)）
         *
         * 执行过程：
         *
         * (1) 先根据 hash 找桶
         *     → 1001,CC 找到“空桶”
         *
         * (2) 进入 equals 比较：
         *
         *     与 p1 比较：
         *     hash 不同 / equals 不同 → 不同元素
         *
         *     与 p2 比较：
         *     id不同 → 不同元素
         *
         * (3) 直接插入链表
         *
         * ❗结果：
         * 不会覆盖 p1，而是“挂在链表后面”
         */

        System.out.println(set); // 输出：3

        // =========================
        // 5. 再次添加 new Person(1001,"AA")
        // =========================

        set.add(new Person(1001, "AA"));

        /*
         * 分析：
         *
         * 注意：
         * 这个对象 hash = (1001,"AA")
         * 但是 set 中的 p1 已经被改成 CC
         *
         * 所以：
         *
         * (1) 进入 AA 的桶
         * (2) 找到 p1（AA→CC 已变）
         *
         * equals 比较：
         *   p1: (1001,CC)
         *   new: (1001,AA)
         *
         * → equals false
         *
         * ❗因此：
         * 不认为重复 → 继续插入
         * → 链表继续增长
         */

        System.out.println(set); // 输出：4
    }
}

/**
 * Person 类（关键：hashCode + equals 依赖 id + name）
 */
class Person {

    int id;
    String name;

    public Person(int id, String name) {
        this.id = id;
        this.name = name;
    }

    // hashCode 依赖 id + name
    @Override
    public int hashCode() {
        return id + name.hashCode();
    }

    // equals 依赖 id + name
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Person)) return false;

        Person p = (Person) obj;
        return this.id == p.id && this.name.equals(p.name);
    }

    @Override
    public String toString() {
        return "(" + id + "," + name + ")";
    }
}