package com.pawamamama.collection_.list.arrayList;

import java.util.ArrayList;
/**
 * Class: ArrayListDetail（ArrayList 注意事项总结）
 *
 * <pre>
 * 1. ArrayList 允许存放所有元素，包括 null，且可以存放多个 null
 *
 * 2. ArrayList 底层基于数组实现数据存储（动态数组）
 *    - 扩容机制后续可结合源码理解
 *
 * 3. ArrayList 与 Vector 基本类似
 *    - 区别：ArrayList 线程不安全，但执行效率更高
 *    - Vector 线程安全，但效率较低（方法多为 synchronized）
 *
 * 4. 使用建议：
 *    - 单线程环境优先使用 ArrayList（性能更好）
 *    - 多线程环境若无外部同步控制，不建议直接使用 ArrayList
 * </pre>
 *
 * @author pawamamama
 * @date 2026/6/16
 */
@SuppressWarnings({"all"})
public class ArrayListDetail {
    public static void main(String[] args) {
      ArrayList arrayList = new ArrayList();
      //1.
      arrayList.add(null);
      arrayList.add(null);
      arrayList.add("jack");
      arrayList.add(null);
      System.out.println(arrayList);
      //2.
      new ArrayList();
    }
}