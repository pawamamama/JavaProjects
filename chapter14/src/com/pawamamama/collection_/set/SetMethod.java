package com.pawamamama.collection_.set;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * Class: SetMethod Set 接口常用方法
 *
 * <pre>
 * 学习内容：
 * 1. HashSet 作为 Set 接口的典型实现类。
 * 2. add(E e) 添加元素。
 * 3. Iterator 迭代器遍历。
 * 4. 增强 for 循环遍历。
 *
 * Set 接口特点：
 * 1. 不允许存放重复元素。
 * 2. 最多只能存放一个 null。
 * 3. 无索引，不能使用普通 for 循环遍历。
 * 4. 元素存放无序（添加顺序 ≠ 存储顺序）。
 * 5. 元素取出顺序通常是固定的（同一次运行期间未发生结构变化时），
 *    但不保证与添加顺序一致，也不保证不同运行之间一定相同。
 *
 * 常见遍历方式：
 * 1. Iterator 迭代器。
 * 2. 增强 for（foreach）。
 *
 * 后续源码学习目标：
 * 1. HashSet 为什么不能存放重复元素？
 * 2. HashSet 为什么只能存放一个 null？
 * 3. HashSet 底层为什么使用 HashMap？
 * 4. add() 底层如何判断元素是否重复？
 * 5. hashCode() 与 equals() 在去重中的作用。
 * </pre>
 *
 * @author pawamamama
 * @date 2026/6/18
 */
public class SetMethod {
    public static void main(String[] args) {
        //1. 以Set 接口的实现类HashSet 来讲解Set 接口的方法
        //2. set 接口的实现类的对象(Set 接口对象), 不能存放重复的元素, 可以添加一个null
        //3. set 接口对象存放数据是无序(即添加的顺序和取出的顺序不一致)
        //4. 注意：取出的顺序的顺序虽然不是添加的顺序，但是他取出时候固定
        Set set = new HashSet();
        set.add("john");
        set.add("lucy");
        set.add("john");//重复
        set.add("jack");
        set.add("hsp");
        set.add("mary");
        set.add(null);//
        set.add(null);//再次添加null
        System.out.println(set);
        //遍历方式
        //1. itertor迭代
        Iterator iterator = set.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
        //2.增强for
        System.out.println("=========================");
        for (Object o :set) {
            System.out.println(o);
        }
        //Set 不能用 普通for

    }

}