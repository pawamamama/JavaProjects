package com.pawamamama.annotation;
/**
 * 这是一个示例类，用于演示 @Deprecated 注解的使用
 * 1.过时不代表不能使用
 * 2.可以修饰方法，类，属性，包，参数，等々 可以查看源码
 * 3.可以做版本升级过渡使用
 */
public class DeprecatedDemo {
    @Deprecated
    public int n1 = 0;
    /**
     * 这是一个旧版本的方法，不推荐使用
     * @deprecated 从1.1版本开始，不推荐使用。请使用 newGreet() 方法
     */
    @Deprecated
    public void oldGreet() {
        System.out.println("Hello from oldGreet! (Deprecated)");
    }

    /**
     * 新版本的方法，推荐使用
     */
    public void newGreet() {
        System.out.println("Hello from newGreet! (Recommended)");
    }

    /**
     * 主方法，演示调用
     */
    public static void main(String[] args) {
        DeprecatedDemo demo = new DeprecatedDemo();

        // 调用旧方法，IDE 或编译器会给出警告
        demo.oldGreet(); // ⚠️ 这个方法已经被废弃
        System.out.println(demo.n1);
        // 调用新方法，推荐使用
        demo.newGreet();
    }
}