package com.pawamamama.codeblock_;

public class CodeBlockDetail01 {
    static void main(String[] args) {
        // 类加载的几种情况：
        // 1. 创 建对象实例时，会触发类的加载（若类尚未加载）
        // new BB(); // 示例：创建父类对象

        // 2. 创建子类对象时，先加载父类，再加载子类
        AA aa = new AA(); // 加载 BB -> 加载 AA -> 执行构造/代码块

        // 3. 使用类的静态成员时，如果类尚未加载，会触发类加载
        Cat.setN1(100);
        System.out.println(Cat.n1);

        // 4. 创建对象时，如果类已加载，则执行普通代码块；若未加载，则先加载类
        new Cat();

        // 静态代码块只会在类加载时执行一次
        DD dd = new DD();
        DD dd2 = new DD();

        // 普通代码块在创建对象实例时执行，每创建一个对象调用一次
        // 注意：仅使用类的静态成员时，普通代码块不会执行
        System.out.println(DD.n1);
    }
}

// DD 类演示静态块和普通代码块
class DD {
    public static int n1 = 100; // 静态属性

    // 静态方法
    public static void setN1(int n1) {
        DD.n1 = n1;
    }

    // 静态代码块：类加载时执行，只执行一次
    static {
        System.out.println("DD 的静态代码块被执行");
    }

    // 普通代码块：创建对象时执行，每创建一个对象执行一次
    {
        System.out.println("DD 的普通代码块被执行");
    }
}

// 动物类演示父类与子类普通和静态代码块
class Animal {
    // 静态代码块：类加载时执行，只执行一次
    static {
        System.out.println("静态代码块动物父类~");
    }

    // 普通代码块：创建对象时执行，每创建一个对象执行一次
    {
        System.out.println("普通代码块动物父类~");
    }
}

class Cat extends Animal {
    public static int n1 = 999; // 静态属性

    public static void setN1(int n1) {
        Cat.n1 = n1;
    }

    // 静态代码块：类加载时执行，只执行一次
    static {
        System.out.println("静态代码块猫猫~");
    }

    // 普通代码块：创建对象时执行，每创建一个对象执行一次
    {
        System.out.println("普通代码块猫猫~");
    }
}

// 父类 BB
class BB {
    static {
        System.out.println("父类BB 的静态代码块被执行");
    }
}

// 子类 AA
class AA extends BB {
    // 静态代码块：类加载时执行，只执行一次
    static {
        System.out.println("子类AA 的静态代码块");
    }

    // 普通代码块：创建对象时执行，每创建一个对象执行一次
    {
        System.out.println("子类AA 的非静态代码块");
    }
}