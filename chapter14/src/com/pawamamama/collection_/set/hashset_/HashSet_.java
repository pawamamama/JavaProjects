package com.pawamamama.collection_.set.hashset_;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * Class: HashSet_
 *
 * <pre>
 * </pre>
 *
 * @author pawamamama
 * @date 2026/6/19
 */
public class HashSet_ {
    public static void main(String[] args) {
        //源码
        //1.构造器源码，底层是HashMap
        /*map = new HashMap<>();*/
        //2.可以允许空值，但是只能有一个null，元素不能重复
        Set set = new HashSet();
        set.add(null);
        set.add(null);
        //3.HashMap不保证存放的数据的是有序的，取决于hash后，确定索引的结果
        System.out.println("set = " + set);
        //案例1
        //1.执行add方法后，会返回一个boolean 值
        //2.添加成功后，返回true 否则返回false
        //3.remove 指定删除哪个对象
        System.out.println(set.add("pawa"));
        System.out.println(set.add("pawa"));
        System.out.println(set.add("wakflads;jf;"));
        System.out.println(set.add("dfdfdf"));
        set.remove("pawa");
        System.out.println("set = " + set);//不保证顺序一样


        set = new HashSet();
        //确保不是同一个对象
        System.out.println(set.add(new Dog("tom")));//t
        System.out.println(set.add(new Dog("tom")));//t
        System.out.println("set = " + set);
        //追源码,后面追
        System.out.println(set.add(new String("pawa")));//ok
        System.out.println(set.add(new String("pawa")));//no
        System.out.println("set = " + set);
    }

}
class Dog {
    private String name;

    public Dog(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Dog{" +
                "name='" + name + '\'' +
                '}';
    }
}