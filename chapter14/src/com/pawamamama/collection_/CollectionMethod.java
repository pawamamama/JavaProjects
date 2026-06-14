package com.pawamamama.collection_;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
/**
 * Class: CollectionMethod
 *
 * <p>
 * 本类用于演示 Java Collection 接口常用方法（以 ArrayList 为实现类）
 * </p>
 *
 * <pre>
 * Collection 接口特点：
 * public interface Collection&lt;E&gt; extends Iterable&lt;E&gt;
 *
 * 1) Collection 实现子类可以存放多个元素，每个元素可以是 Object
 * 2) 有些 Collection 的实现类可以存放重复元素，有些不可以
 * 3) 有些 Collection 的实现类是有序的（List），有些不是有序的（Set）
 * 4) Collection 接口没有直接实现类，是通过子接口 List 和 Set 间接实现的
 * </pre>
 *
 * <pre>
 * Collection 常用方法说明：
 *
 * 1. add(E e) - 添加单个元素到集合末尾
 * 2. remove(Object o) / remove(int index)
 *    - remove(int)：按索引删除元素
 *    - remove(Object)：按元素内容删除（基于 equals）
 * 3. contains(Object o) - 判断集合中是否存在指定元素（基于 equals）
 * 4. size() - 返回集合中元素的个数
 * 5. isEmpty() - 判断集合是否为空（size == 0）
 * 6. clear() - 清空集合中所有元素
 * 7. addAll(Collection c) - 添加另一个集合的所有元素
 * 8. containsAll(Collection c) - 判断是否包含另一个集合所有元素
 * 9. removeAll(Collection c) - 删除与另一个集合相同的所有元素
 *
 * 注意：
 * - List 是有序集合，可以存放重复元素
 * - ArrayList 底层基于动态数组实现
 * </pre>
 *
 * @author pawamamama
 * @date 2026/6/14
 */
public class CollectionMethod {
    @SuppressWarnings({"all"})
    public static void main(String[] args) {
        //创建一个ArrayList
        List list = new ArrayList();
        //add:添加单个元素
        list.add("String");
        list.add(10);//会有一个自动装箱 基本数据类型变成包装类
        list.add(100.1);//相当于 list.add(new Double(100.1));
        list.add(null);
        list.add(true);
        list.add(true);
        System.out.println("list = " + list);//放入之后不对是基本数据类型而是对象
        //remove:删除指定元素（可按索引删除，也可按对象删除）
          list.remove(1);//删除第一个元素
        System.out.println("list = " + list);
        list.remove("String");//指定删除某个元素
        System.out.println("list = " + list);
        list.remove(true);//删除true
        System.out.println("list = " + list);
        //contains:查找元素是否存在
        System.out.println(list.contains("String"));
        if (list.contains(true)) {
            System.out.println("true 存在" + list);
        }else {
            System.out.println("true 不存在" + list);
        }
        //size:获取元素个数
        System.out.println("list is size = " + list.size());
        //isEmpty:判断是否为空
        System.out.println("Is the ArrayList object \"list\" empty?" + list.isEmpty());
        //clear:清空集合
        list.clear();
        System.out.println("list = " + list);
        //addAll:添加多个元素 添加集合
        //只要是实现了 Collection 接口的集合对象都能添加
        ArrayList arrayList = new ArrayList();
        arrayList.add("我是sb");
        arrayList.add("我是sb");
        arrayList.add("我是sb");
        arrayList.add("我是sb");
        //传入对象
        list.addAll(arrayList);
        System.out.println("list = " + list);
        // containsAll: 判断当前集合是否包含另一个集合中的所有元素
        // 返回值：true 表示 list 中包含 arrayList 中的所有元素（包括重复与否按 equals 判断）
        // 注意：只要有一个元素不存在，就返回 false
        System.out.println(list.containsAll(arrayList));
        //removeAll:删除多个元素
        //
        list.add("刘轩宇是小南娘");
        list.removeAll(arrayList);
        System.out.println("list = " + list);
        //说明：以ArrayList实现类来演示
    }

}