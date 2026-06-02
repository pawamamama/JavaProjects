package com.pawamamama.static_;

/**
 * 演示静态方法与非静态方法的使用规则
 */
class StaticMethodDetail {

public               static void main(String[] args) {
        // 静态方法可以通过类名直接调用
        D.hi();

        // 非静态方法不能通过类名调用
        // D.say(); // 错误

        // 通过匿名对象调用非静态方法
        new D().say(); // 正确
    }
}

class D {
    private int n1 = 100;       // 实例变量（对象变量）
    private static int n2 = 100; // 类变量（静态变量）

    // 非静态方法：属于对象，可以访问实例变量和静态变量
    public void say() {
        System.out.println("非静态方法 say()");
    }

    // 静态方法：属于类，只能访问静态成员
    public static void hi() {
        System.out.println("静态方法 hi()");

        // 错误示例：静态方法中不能使用 this 或 super
        // System.out.println(this.n1);
    }

    /**
     * 静态方法访问规则：
     * 1. 可以访问类变量（静态变量）
     * 2. 可以调用其他静态方法
     * 3. 不能直接访问实例变量或非静态方法
     */
    public static void hello() {
        // 访问静态变量
        System.out.println(n2);
        System.out.println(D.n2);

        // System.out.println(this.n2); // 错误：静态方法中不能使用 this

        // 调用静态方法
        hi();

        // say(); // 错误：静态方法不能调用非静态方法
    }

    /**
     * 非静态方法可以访问实例变量和静态变量，
     * 也可以调用非静态方法和静态方法
     */
    public void ok() {
        // 访问实例变量
        System.out.println(n1);
        // 调用非静态方法
        say();

        // 访问静态变量
        System.out.println(n2);
        // 调用静态方法
        hello();
    }
}