package com.pawamamama.collection_.list.vector_;

import java.util.Vector;

/**
 * Vector类（线程安全的动态数组）
 *
 * <p>1. Vector底层是 Object[] 数组实现，支持动态扩容</p>
 *
 * <p>2. Vector是线程安全的（所有方法都使用 synchronized 修饰）</p>
 *
 * <p>3. 扩容机制：</p>
 * <ul>
 *     <li>默认初始容量：10</li>
 *     <li>无参构造：满了后扩容2倍</li>
 *     <li>指定容量：满了后仍按2倍扩容</li>
 * </ul>
 *
 * <p>4. 特点：</p>
 * <ul>
 *     <li>线程安全</li>
 *     <li>效率较低（因为加锁）</li>
 *     <li>已较少使用，通常被 ArrayList 替代</li>
 * </ul>
 *
 * <p>5. 使用场景：</p>
 * <ul>
 *     <li>需要线程同步的旧代码中</li>
 *     <li>现代开发推荐使用 ConcurrentHashMap / CopyOnWriteArrayList</li>
 * </ul>
 */
@SuppressWarnings({"all"})
public class vector {
    public static  void main(String[] args) {

        Vector result = new Vector(8);
        for (int i = 0; i <10 ; i++) {
            result.add(i);
        }
        result.add(100);
    }

}