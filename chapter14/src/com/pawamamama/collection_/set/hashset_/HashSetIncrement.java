package com.pawamamama.collection_.set.hashset_;

import java.util.HashSet;

/**
 * Class: HashSetIncrement
 * HashSet 扩容机制与红黑树转换机制
 *
 * <pre>
 * 1. HashSet 底层基于 HashMap 实现。
 * 2. 第一次添加元素时，table 会初始化为长度 16。
 * 3. 默认负载因子（loadFactor）为 0.75，
 *    threshold = capacity × loadFactor = 16 × 0.75 = 12。
 * 4. 当元素个数达到 threshold 时，数组扩容为原来的 2 倍，
 *    新的 threshold 也会按新的容量重新计算。
 * 5. 当同一个桶（bucket）中的链表长度达到 8 时：
 *      - 如果 table 长度 >= 64，则链表转换为红黑树；
 *      - 如果 table 长度 < 64，则优先扩容，而不是树化。
 * 6. 触发扩容有两个地方，++size > threshold 阈值时，还有链表大于8尝试树化，但是还没size == 64 时
 *
 * 常量：
 * TREEIFY_THRESHOLD = 8      // 链表树化阈值
 * MIN_TREEIFY_CAPACITY = 64  // 最小树化容量
 * </pre>
 *
 * @author pawamamama
 * @date 2026/6/21
 */
@SuppressWarnings({"all"})
public class HashSetIncrement {
    public static void main(String[] args) {
        HashSet hashSet = new HashSet();
      /*  for (int i = 1; i < 100; i++) {
            hashSet.add(i);
        }*/
        //演示链表 8 个 然后树化
           for (int i = 1; i < 12; i++) {
            hashSet.add(new A(i));
        }
        System.out.println("hashSet: " + hashSet);
    }

}
class A {
    private int x;

    public A(int x) {
        this.x = x;
    }
    //重写 hashCode 返回hash一样使计算出的索引一样，equals 保证了对象不一样，所以形成 同桶链表
    @Override
    public int hashCode() {
        return 1000;
    }
}