package com.pawamamama.generic;

/**
 * Class: Generic03
 *
 * <p>本类用于说明 Java 泛型（Generic）的基本概念、作用以及优势。</p>
 *
 * <h2>一、什么是泛型</h2>
 * <p>
 * 泛型（Generic），又称参数化类型（Parameterized Type），是 JDK 5 引入的新特性。
 * 用于在<strong>编译期</strong>约束数据类型，从而提高程序的安全性。
 * </p>
 *
 * <p>常见泛型形式：</p>
 * <ul>
 *     <li>Integer</li>
 *     <li>String</li>
 *     <li>Dog（自定义类型）</li>
 * </ul>
 *
 * <h2>二、泛型的作用</h2>
 *
 * <ol>
 *     <li>
 *         <b>类型安全</b><br>
 *         在编译阶段就能发现类型错误，避免运行时 ClassCastException。
 *     </li>
 *
 *     <li>
 *         <b>消除强制类型转换</b><br>
 *         使用泛型后，取出数据时不需要再进行类型转换。
 *     </li>
 *
 *     <li>
 *         <b>代码更简洁</b><br>
 *         减少重复的类型判断和强转代码，提高可读性。
 *     </li>
 * </ol>
 *
 * <h2>三、泛型的本质理解</h2>
 * <p>
 * 泛型的本质是：<b>类型参数化</b>。
 * 在类、接口或方法中，通过一个“类型标识符”来代表某种未知类型，
 * 在使用时再指定具体类型。
 * </p>
 *
 * <p>例如：</p>
 * <pre>
 * ArrayList&lt;Dog&gt; list = new ArrayList&lt;&gt;();
 * </pre>
 *
 * <p>
 * 表示：这个集合中只能存放 Dog 类型对象。
 * </p>
 *
 * <h2>四、泛型带来的保证</h2>
 *
 * <ul>
 *     <li>编译期检查类型是否正确</li>
 *     <li>运行期不会因为类型问题导致 ClassCastException</li>
 *     <li>代码更加健壮</li>
 * </ul>
 *
 * <h2>五、总结</h2>
 * <ul>
 *     <li>泛型 = 编译期类型约束机制</li>
 *     <li>解决 Object 容器带来的类型不安全问题</li>
 *     <li>核心价值：安全 + 简洁 + 可读性</li>
 * </ul>
 *
 * @author pawamamama
 * @date 2026/7/3
 */
@SuppressWarnings({"all"})
public class Generic03 {
    public static void main(String[] args) {
        // pulic class ArrayList<E> {} E 是泛型 可以把数据类型（String Integer Dog）指定给E

        //E 具体数据类型在定义时指定，编译期间就确定了，所以编译器可以检查
        //1. E 全部换成 String
        Person2<String> string = new Person2<>("String");
        System.out.println(string.getS());
        //2  E 全部换成 Integer
        Person2<Integer> integerPerson2 = new Person2<Integer>(11111);
        System.out.println(integerPerson2.getS());
        //3 使用getClass 看E指定的类型（运行类型）
        string.show();
        integerPerson2.show();
        //person 本身不变
        System.out.println("person = " + string.getClass());
    }
}
class Person {
    String s;//有时希望s不是String 而是 Integer
}
/*  泛型的作用是 ：1.可以在类声明时通过一个标识表示类中某个属性的类型
    或是2.某个方法的返回值的类型，或者是参数类型
* */
class Person2<E> {//
    E s;//1.指定这个属性的数据类型时是在创建或定义该对象时指定类型,即在编译期去指定

    public Person2(E s) {//2.参数
        this.s = s;
    }
    public E getS() {
        return s;//2.返回值
    }
    public void show() {
        System.out.println(s.getClass());
    }
}