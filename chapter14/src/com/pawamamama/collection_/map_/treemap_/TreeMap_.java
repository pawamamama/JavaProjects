package com.pawamamama.collection_.map_.treemap_;

import java.util.TreeMap;
/**
 * TreeMap 默认排序规则演示
 *
 * <p>TreeMap 是基于红黑树实现的有序 Map。
 * 默认情况下，它会按照 key 的“自然顺序（Natural Ordering）”进行排序。</p>
 *
 * <h3>排序规则：</h3>
 * <ul>
 *     <li>String：按 Unicode 字典序排序</li>
 *     <li>Integer / Long：按数值升序排序</li>
 *     <li>自定义对象：必须实现 Comparable 接口</li>
 * </ul>
 *
 * <h3>底层原理：</h3>
 * <p>通过 compareTo() 方法决定 key 的插入位置：</p>
 * <ul>
 *     <li>&lt; 0：左子树</li>
 *     <li>&gt; 0：右子树</li>
 *     <li>= 0：认为是同一个 key，会覆盖 value</li>
 * </ul>
 *
 * <h3>注意：</h3>
 * <ul>
 *     <li>TreeMap 不允许 null key</li>
 *     <li>默认构造器使用自然排序</li>
 * </ul>
 */
@SuppressWarnings({"all"})
public class TreeMap_ {
    public static void main(String[] args) {
        //1.使用默认构造器 ，创建TreeMap
        TreeMap map = new TreeMap();
        // key = 英文名，value = 中文名
        //这里默认按照String按 Unicode 字典序排序
        map.put("Tom", "汤姆");
        map.put("Alice", "爱丽丝");
        map.put("Bob", "鲍勃");
        map.put("John", "约翰");
        map.put("Cathy", "凯西");
        // 输出
        System.out.println(map);
        //2.调用put方法
        //2.1 第一次添加，把k-v 封装到 Entry 对象，放入 root
        /* Entry<K,V> t = root;
        if (t == null) {
            //检查key是否为空，如果自己重写的
            compare(key, key); // type (and possibly null) check

            root = new Entry<>(key, value, null);
            size = 1;
            modCount++;
            return null;
        }
        //2.2以后添加
         Comparator<? super K> cpr = comparator;（动态绑定到我们匿名内部类的compare方法比较）
        if (cpr != null) {
            do {/遍历所用key ，给当前key找到适当的位置
                parent = t;
                cmp = cpr.compare(key, t.key);
                if (cmp < 0)
                    t = t.left;
                else if (cmp > 0)
                    t = t.right;
                else//如果遍历过程中，发现准备添加key和当前已有的key相等，就不添加
                    return t.setValue(value);
            } while (t != null);
        }
        //3.默认情况下（没有自定义比较器）
        else {
            if (key == null)//3.1 如果该key == null 则报错
                throw new NullPointerException();
            @SuppressWarnings("unchecked")
                Comparable<? super K> k = (Comparable<? super K>) key;
                // 强制要求 key 必须具备自然排序能力,为后续 compareTo 调用提供类型保证,在运行时提前失败
            do {
                parent = t;
                cmp = k.compareTo(t.key);
                if (cmp < 0)
                    t = t.left;
                else if (cmp > 0)
                    t = t.right;
                else
                    return t.setValue(value);
            } while (t != null);
        }

        */

    }
}