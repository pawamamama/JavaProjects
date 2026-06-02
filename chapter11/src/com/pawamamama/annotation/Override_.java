package com.pawamamama.annotation;
//@interface 表示一个 注解类
//@Target 是修饰注解的注解，称之为元注解
/**
 * ===============================
 * @Override 注解笔记
 * ===============================
 *
 * 1. @Override 是 Java 内置注解（Annotation）
 *    - 用于标记方法，表示该方法重写了父类的方法
 *
 * 2. 作用：
 *    - 编译器检查方法是否真正重写了父类的方法
 *    - 增强代码可读性
 *    - 防止拼写错误或方法签名错误导致重写失败
 *
 * 3. 使用规则：
 *    - 只能修饰方法
 *    - 方法签名必须与父类或接口方法一致
 *
 * 4. 注意事项：
 *    - @Override 不是关键字，不改变方法功能
 *    - 仅用于编译时检查和提示
 *
 * 5. 相关经典注解：
 *    - @Deprecated
 *    - @SuppressWarnings
 *
 * 6. 运行示例：
 */
public class Override_{

    public static void main(String[] args) {
        Animal a = new Animal();
        a.cry();   // 输出: Animal cries...

        Dog d = new Dog();
        d.cry();   // 输出: Dog says: 汪汪汪

        // 多态示例
        Animal ad = new Dog();
        ad.cry();  // 输出: Dog says: 汪汪汪
        // 因为 Dog 重写了 cry() 方法，多态生效
    }
}
class Animal {
    public void cry() {
        System.out.println("Animal cries...");
    }
}

class Dog extends Animal {

    // 使用 @Override，告诉编译器这是重写父类方法
    @Override
    public void cry() {
        System.out.println("Dog says: 汪汪汪");
    }

    // 如果方法签名错误，编译器会报错
    // @Override
    // public void cry(int times) {
    //     System.out.println("This will cause a compile error!");
    // }
}
