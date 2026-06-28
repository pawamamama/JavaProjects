package com.pawamamama.collection_.set.treeset_;

import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

/**
 * <pre>
 * Class: TreeSet01
 *        1. 使用无参构造器，创建TreeSet时，仍然是无序的（指存入取出时是无序的）
 *        2. 希望添加的元素，按照字符串大小来排序
 *        3. 使用TreeSet提供的一个构造器,可以传入一个比较器(传入 Comparator匿名内部类)
 *           并指定排序规则
 * </pre>
 *
 * @author pawamamama
 * @date 2026/6/27
 */
@SuppressWarnings({"all"})
public class TreeSet01 {
    public static void main(String[] args) {
        //Set set= new TreeSet();
        //使用 比较器
        TreeSet set = new TreeSet(new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                //顺序排，逆向排序换o的位置
                //调用字符串重写过的compareTo方法，默认是按照字符串大小来比较的
                //return ((String)o1).compareTo((String)o2);


                //按照字符串长度大小来比较，两个长度一样的加入不进去
                return ((String)o1).length()-((String)o2).length();
            }
        });
        //添加数据
        set.add("a");
        set.add("b");
        set.add("c");
        set.add("d");
        set.add("jack");
        set.add("tom");
        set.add("pawa");
        set.add("mamam");
        System.out.println("treeSet = " + set);
        /*  1. 构造器把传入的比较器对象给到  TreeSet 的底层的TreeMap构造器
        *   public TreeMap_(Comparator<? super K> comparator) {
                this.comparator = comparator;
            }
            2. TreeSet的add方法，其实走的是TreeMap 的 put方法
            public boolean add(E e) {
                return m.put(e, PRESENT)==null;
            }
            3.调用 set.add("施主") 时，底层会执行到
            Comparaor<? super K> cpr = comparator;
            if (cpr != null) {..cpr就是我们的匿名内部类
                do {
                    parent = t;
                    cmp = cpr.compare(key, t.key);//会动态绑定到 匿名内部类重写过的compare 方法
                    if (cmp < 0)
                        t = t.left;
                    else if (cmp > 0)
                        t = t.right;
                    else //如果相等数据是加入不进去的，说明相等value直接替换，key加入不了
                        return t.setValue(value);
                } while (t != null);
            }
        *
        *
        * */
    }
}