package com.pawamamama.generic;

/**
 * Class: CustomMethodGeneric
 *
 * <pre>
 * 自定义泛型方法示例说明：
 *
 * 1. 泛型方法基本语法：
 *    修饰符 <T, R, ...> 返回类型 方法名(参数列表) {
 *        // 方法体
 *    }
 *
 * 2. 泛型方法特点：
 *    - 泛型方法可以定义在普通类中，也可以定义在泛型类中
 *    - 泛型方法的类型参数独立于类的泛型
 *    - 调用时由传入参数自动推断类型
 *
 * 3. 泛型方法与类泛型区别：
 *    - 类泛型：在创建对象时确定类型
 *    - 方法泛型：在调用方法时确定类型
 *
 * 4. 注意事项：
 *    1) 泛型方法声明的 <T, R> 必须写在返回值前面
 *    2) 静态方法可以使用泛型方法（但不能使用类泛型）
 *    3) 调用时通常无需显式指定类型，编译器会自动推断
 *    4) 泛型方法在编译后会进行类型擦除
 *
 * 5. 典型应用场景：
 *    - 通用工具方法（如打印、转换、拷贝）
 *    - 数据处理函数
 *    - 返回不同类型结果的通用逻辑
 *
 * 示例结构：
 *    class Bird<T, R, M> {
 *        public <E> void fly(E e) {
 *            System.out.println(e);
 *        }
 *    }
 *
 *    class Fish {
 *        public <A> A show(A a) {
 *            return a;
 *        }
 *    }
 *
 * </pre>
 *
 * @author
 * @date 2026/7/4
 */
@SuppressWarnings({"all"})
public class CustomMethodGeneric {
    public static void main(String[] args) {
        //泛型方法使用
        //1.使用时要指定泛型，或者直接传入，编译器会直接根据实参判断
        String mamama2 = new Fish().show("mamama");//等价
        String mamama = new Fish().<String>show("mamama");//等价
        new Fish().show(222);

        // T = Double R = Fish M = String
        // A = Character
        new Bird<Double, Fish, String>().eat1('S', 1.1, new Fish(),"String");
    }

}

//1.泛型方法定义在普通类中
class Fish {
    //泛型提供给泛型方法使用
    public <A> A show(A a) {
        System.out.println("a 值= " + a);
        System.out.println("a的类型 = " + a.getClass().getSimpleName());
        return a;
    }
}

//2.泛型方法定义在泛型类
class Bird<T, R, M> {
    //泛型方法
    //提供给 fly方法使用的
    public <E> void fly(E e) {
        System.out.println(e);
    }


    //3.修饰符后没有<泛型>，不是泛型方法，而是使用了泛型
    // 是eat方法使用了类声明的 泛型
    public void eat(M m) {
        System.out.println(m);
    }

    //泛型方法可以使用类声明1的泛型，也可以使用自己声明的泛型
    public <A> void eat1(A a, T t, R r, M m) {
        System.out.println("方法泛型 A = " + a.getClass().getSimpleName());
        System.out.println("类泛型 t = " + t.getClass().getSimpleName());
        System.out.println("类泛型 r =" + r.getClass().getSimpleName());
        System.out.println("类泛型 m = " + m.getClass().getSimpleName());
    }

}
