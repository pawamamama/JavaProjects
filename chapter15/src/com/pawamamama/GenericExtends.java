package com.pawamamama;

import java.util.ArrayList;
import java.util.List;

/**
 * Class: GenericExtends
 *
 * <pre>
 * 泛型的继承与通配符说明：
 *
 * 1. 泛型不具备继承性（重点）
 *    - List<Object> 和 List<String> 没有继承关系
 *    - 不能直接赋值：
 *        List<Object> list = new ArrayList<String>(); // ❌错误
 *
 * 2. 通配符 ? 的作用
 *    - ? 表示任意类型（未知类型）
 *    - 用于解决“泛型不具备继承性”的限制问题
 *
 * 3. ? extends A（上限通配符）
 *    - 表示：A及其子类
 *    - 例如：List<? extends Number>
 *      可以接收：List<Integer>, List<Double>
 *    - 特点：只能读取，不能随意添加（安全性限制）
 *
 * 4. ? super A（下限通配符）
 *    - 表示：A及其父类
 *    - 例如：List<? super Integer>
 *      可以接收：List<Integer>, List<Number>, List<Object>
 *    - 特点：可以添加A及其子类对象，但读取时通常为Object
 *
 * 5. 核心总结：
 *    - 泛型：编译期类型安全 + 运行期类型擦除
 *    - 继承关系：不直接作用于泛型容器
 *    - 通配符：用于解决泛型之间的“灵活赋值问题”
 *
 * </pre>
 */
@SuppressWarnings({""})
public class GenericExtends {
    public static void main(String[] args) {
        //泛型没有继承性
        //List<Object> list = new ArrayList<String>();//错
        //说明下面三个方法的使用
        List<Object> list1 = new ArrayList<>();
        List<String> list2 = new ArrayList<>();
        List<AA> list3 = new ArrayList<>();
        List<BB> list4 = new ArrayList<>();
        List<CC> list5 = new ArrayList<>();

        //使用下面的
        // 方法1 是 List<?> - 都可以接收任意类型的泛型类型
        printCollection1(list1);
        printCollection1(list2);
        printCollection1(list3);
        printCollection1(list4);
        printCollection1(list5);

        //方法2 是 ? extends AA 表示上限，可以接受AA 或者AA 子类
        //printCollection2(list1);//不行
        //printCollection2(list2);//不行
        printCollection2(list3);//ok
        printCollection2(list4);//ok
        printCollection2(list5);//ok
        //方法3 是? super 子类类名AA:支持AA 类以及AA 类的父类，不限于直接父类，
        printCollection3(list1);//AA 默认继承 Obj
        //printCollection3(list2);//String无法被继承
        printCollection3(list3);//支持自己
        //printCollection3(list4);//不支持自己的子类
        //printCollection3(list5);//不支持自己的子类


    }

    //看方法
    //说明: List<?> 表示任意的泛型类型都可以接受
    public static void printCollection1(List<?> c) {
        for (Object object : c) { // 通配符，取出时，就是Object
            System.out.println(object);
        }
    }

    // ? extends AA 表示上限，可以接受AA 或者AA 子类
    public static void printCollection2(List<? extends AA> c) {
        for (Object object : c) {
            System.out.println(object);
        }
    }

    // ? super 子类类名AA:支持AA 类以及AA 类的父类，不限于直接父类，
    //规定了泛型的下限
    public static void printCollection3(List<? super AA> c) {
        for (Object object : c) {
            System.out.println(object);
        }
    }
}

class AA {
}

class BB extends AA {
}

class CC extends BB {
}