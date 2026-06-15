package com.pawamamama.collection_.list;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Class: ListExercise
 *
 * <pre>
 * List 常用方法练习
 *
 * 1. 编译类型为 List，运行类型为 ArrayList
 * 2. 添加 10 个元素
 * 3. 在指定位置插入元素
 * 4. 获取指定位置元素
 * 5. 删除指定位置元素
 * 6. 修改指定位置元素
 * 7. 使用 Iterator 迭代器遍历集合
 *
 * 涉及方法：
 * add()
 * get()
 * remove()
 * set()
 * iterator()
 * </pre>
 *
 * @author pawamamama
 * @date 2026/6/15
 */
@SuppressWarnings({"all"})
public class LIstExericse {
    public  static void main(String[] args) {

        // 编译类型 List，运行类型 ArrayList
        List list = new ArrayList();
        //循环添加元素
        for (int i = 1; i <11 ; i++) {
            list.add("hello"+i);
        }
        // 添加 10 个元素
        list.add("Tom");
        list.add("Jack");
        list.add("Smith");
        list.add("Mary");
        list.add("Pawa");
        list.add("Java");
        list.add("Linux");
        list.add("Git");
        list.add("IDEA");
        list.add("Spring");
        //1.add
        list.add(1,"王微信牛逼");
        //2.get
        System.out.println("list的第五个元素是"+list.get(4));
        //3.remove
        list.remove(5);
        //4.set
        list.set(6,"修改了");
        //5.迭代器遍历
        Iterator it = list.iterator();
        while (it.hasNext()) {
            Object next =  it.next();
            System.out.println(next);
        }
    }
}