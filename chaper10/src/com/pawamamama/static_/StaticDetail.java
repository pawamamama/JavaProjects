package com.pawamamama.static_;
class B {
    // ===== 类变量（静态变量） =====
    // 特点：
    // 1. 使用 static 修饰
    // 2. 生命周期：随着类加载而开始，随着类卸载而销毁
    // 3. 存储位置：方法区（共享内存区），不在堆中
    // 4. 所有对象共享同一份数据
    // 5. 可以通过类名直接访问，也可以通过对象访问（不推荐）
    static int n2 = 100;

    // ===== 普通成员变量（对象属性） =====
    // 特点：
    // 1. 每创建一个对象就会创建一份
    // 2. 生命周期：随着对象创建而分配内存，随着对象被垃圾回收而销毁
    // 3. 存储位置：堆内存
    // 4. 每个对象拥有独立副本，互不干扰
    int n1 = 50;
}

public class StaticDetail {
    public static void main(String[] args) {
        // ---- 静态变量访问 ----
        System.out.println(B.n2); // ✅ 推荐：类名直接访问
        B b1 = new B();
        System.out.println(b1.n2); // ✅ 可用对象访问，但共享同一份数据，不推荐

        // ---- 普通成员变量访问 ----
        System.out.println(b1.n1); // ✅ 必须通过对象访问
        B b2 = new B();
        b2.n1 = 200;
        System.out.println(b1.n1); // 输出 50，b1 和 b2 的普通成员变量互不干扰

        // ---- 类变量共享性演示 ----
        b1.n2 = 500; // 修改静态变量，所有对象都能看到
        System.out.println(B.n2); // 输出 500
        System.out.println(b2.n2); // 输出 500
    }
}