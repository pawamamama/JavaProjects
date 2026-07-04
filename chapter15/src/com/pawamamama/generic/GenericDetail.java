package com.pawamamama.generic;

import java.util.ArrayList;
import java.util.List;

/**
 * Class: GenericDetail
 *
 * <pre>
 * 泛型使用的注意事项：
 *
 * 1. 泛型中的类型参数（如 T、E）只能是引用类型，不能是基本数据类型
 *    例如：
 *    List<Integer> list = new ArrayList<Integer>(); // 正确
 *    List<int> list2 = new ArrayList<int>();         // 错误（不能使用基本类型）
 *
 * 2. 在给泛型指定具体类型后，可以传入该类型或其子类对象
 *
 * 3. 泛型的简写形式（菱形语法）：
 *    List<Integer> list1 = new ArrayList<Integer>();
 *    List<Integer> list2 = new ArrayList<>(); // 编译器自动推断类型
 *
 * 4. 如果不写泛型（使用原始类型 raw type）：
 *    List list3 = new ArrayList();
 *    默认泛型为 Object，可以存放任意类型，但存在类型安全隐患
 * </pre>
 *
 * @author pawamamama
 * @date 2026/7/4
 */
@SuppressWarnings({"all"})
public class GenericDetail {
    public static void main(String[] args) {
        //接口<泛型> = new 实现泛型的类<泛型>
        List<Integer> list = new ArrayList<Integer>(); // 正确
        //List<int> list2 = new ArrayList<int>();         // 错误（不能使用基本类型）

        new AnimalDogList().test();//2.子类


        //3. 泛型使用的形式
        List<Integer> list1 = new ArrayList<Integer>();
        //实际开发中这样写
        List<Integer> list2 = new ArrayList<>(); // 编译器自动推断类型


        //4.默认泛型是 Object
    }

}

/**
 * 用来验证第2条：泛型只能放指定类型或子类
 */
class Animal {
}

class Dog2 extends Animal {
}

class AnimalDogList {
    public void test() {
        List<Animal> list = new ArrayList<>();

        list.add(new Animal()); // OK
        list.add(new Dog2());     // OK（子类可以放进去）

        System.out.println("Animal list size = " + list.size());
        for (Animal animal : list) { //实际运行类型是animal的子类型Dog
            System.out.println(animal.getClass());
        }

    }
}
