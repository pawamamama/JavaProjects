package com.pawamamama.collection_.set.hashset_;

import java.util.HashSet;

/**
 * Class: HashSetSource
 * HashSet 底层源码分析
 *
 * <pre>
 * 1. HashSet 底层实际上是 HashMap。
 * 2. 添加元素时，先调用 hashCode() 计算哈希值。
 * 3. 再通过扰动算法计算出数组(table)中的索引位置。
 * 4. 若该位置为空，则直接存入。
 * 5. 若该位置已有元素：
 *    - 调用 equals() 判断是否为同一个对象。
 *    - 相同：放弃添加（HashSet 不允许重复元素）。
 *    - 不同：以链表（Java 8 中可能转为红黑树）的形式继续存储。
 * 6. 当链表节点个数 >= TREEIFY_THRESHOLD(8)，并且
 *    数组容量(table.length) >= MIN_TREEIFY_CAPACITY(64) 时，
 *    链表会树化(Treeify)为红黑树，提高查找效率。
 *
 * 核心流程：
 * hashCode() → hash() → index → equals() → 链表 → 红黑树
 *
 * 常量：
 * TREEIFY_THRESHOLD = 8      // 链表树化阈值
 * MIN_TREEIFY_CAPACITY = 64  // 最小树化容量
 * </pre>
 *
 * @author pawamamama
 * @date 2026/6/19
 */
@SuppressWarnings({"all"})
public class HashSetSource {
  public static void main(String[] args) {
    HashSet set = new HashSet();

    set.add("java");
    set.add("php");
    set.add("java"); // 重复元素

    System.out.println("最终set: " + set);
    /*
    * 源码解读、
    * 1. 构造器 内部  map = new HashMap<>();
    * 2.执行add方法
    *     public boolean add(E e) {E 泛型 e = java
            return map.put(e, PRESENT)==null;
            * PRESENT的解读 PRESENT 始终是  new Object();
              private static final Object PRESENT = new Object();
            * 用于占位的空对象，表示 HashSet 中实际存储的“值”（所有元素共用）
          }
      3.执行put
      *   public V put(K key, V value) {key = "java" value = PRESENT
            return putVal(hash(key), key, value, false, true);
          }
      4.   return putVal(hash(key), key, value, false, true);
      *   4.1 先去 hash
      *     static final int hash(Object key) {
              int h;                          //计算索引
              return (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
            }
      5.得到 hash 值后去 putVal
      *  final V putVal(int hash, K key, V value, boolean onlyIfAbsent,
                   boolean evict) {
        Node<K,V>[] tab; Node<K,V> p; int n, i;//定义了辅助变量
        //table 就是 HashMap 的 一个数组 ,类型是 Node[]
        //if 语句表示如果当前table 是 null ，或者大小为 0
        * //就是第一次扩容，16个空间 使用 resize方法初始化或以两倍大小扩容表
        if ((tab = table) == null || (n = tab.length) == 0)
            n = (tab = resize()).length;
        //（1）根据得到的key得到hash 去计算key应该存放到table表的哪个索引位置
        //把位置的对象引用赋值给p
        //（2）判断p 是否为null
        // （2.1）p == null  没有存放过元素，就创建一个 new Node

        if ((p = tab[i = (n - 1) & hash]) == null)
            tab[i] = newNode(hash, key, value, null);
        //Node (hash = key 的 hash用于对比，key = "java"， value = 占位的空对象 ,next = 链表下一个节点目前是null)
        else {//允许单独else 语句，含义是 上面if 都不执行就执行这里的else的代码块
        //开发技巧：需要局部变量（辅助用变量）时，在创建，比较好
            Node<K,V> e; K k;//辅助变量
            * 三层判定链 hash + 对象引用 + equals 判断
            if (p.hash == hash &&//对比hash值，p实际是 与当前准备添加的对象用hash计算出相同索引（桶）中的对象
            //p.hash == 当前对象hash时 认为此对象与索引桶中第一个对象的hash相等（hash 相等不等于没变化） hash一样吗
            //并且 满足下边两条之一
             (1) k = p.key == 当前要添加的对象（引用对比） 是同一对象吗
             (2)  当前要添加的对象 ！= null 或者 equals内容相同(动态绑定) 内容一样吗
            //实际是做了三层判定是否同一hash + 是同一对象 + 同一内容
            //如果都一样就不去添加
                ((k = p.key) == key || (key != null && key.equals(k))))
                e = p;//一样进入这里，不一样就不执行这里
            //判断 p 是不是一棵红黑树，是就按照红黑树方式去比较，复杂以后学
            else if (p instanceof TreeNode)//上一个if == true 的话这里和后面的else不执行
                e = ((TreeNode<K,V>)p).putTreeVal(this, tab, hash, key, value);
            else {//table 对应索引位置是一个链表，使用for 去比较
                  //1. 依次和该链表的每一个元素比较后，都不相同，则加入到最后 然后跳出
                  * 2.相同就break 跳出
                for (int binCount = 0; ; ++binCount) {
                    if ((e = p.next) == null) {//如果该索引（桶）里的对象的next 是 null 那就把当前要添加的对象直接挂到后面
                        p.next = newNode(hash, key, value, null);// 生成节点并挂载
                        if (binCount >= TREEIFY_THRESHOLD - 1) // -1 for 1st
                        //节点超过八树化尝试（不保证树化）
                            treeifyBin(tab, hash);
                        break;//添加后退出
                    }
                    if (e.hash == hash &&//不等于null走这里比较，如果有一 个相同跳出
                        ((k = e.key) == key || (key != null && key.equals(k))))
                        break;//相同元素退出
                    p = e;//更新next
                }
            }
            //e == null 时就是正常添加
            //e == 实际对象时（相同对象），就去更新value=是占位对象
            if (e != null) { // existing mapping for key
                V oldValue = e.value;
                if (!onlyIfAbsent || oldValue == null)
                    e.value = value;
                afterNodeAccess(e);
                return oldValue;//返回一个对象就代表失败
            }
        }
        ++modCount;//修改次数
        if (++size > threshold)//size 大于threshold（负载因子（默认 0.75））时去扩容
            resize();
        afterNodeInsertion(evict);//留给LinkedHashSet子类去实现的方法（通过动态绑定机制）父类 HashSet 里面是{}
        return null; //返回空代表成功，不成功返回 key = "java"
    }
    * return map.put(e, PRESENT)==null; add这里真正会返回 true 和 false
      *
    * */
  }
}