package com.pawamamama.collection_.map_.hashtable;

import java.util.Hashtable;

/**
 * Class: HashTableExercise
 *
 * <pre>
 * Hashtable 特性演示：
 * 1. key/value 不能为 null
 * 2. put 会覆盖旧值
 * 3. 线程安全（synchronized）
 * </pre>
 */
@SuppressWarnings({"all"})
public class HashTableExercise {
    public static void main(String[] args) {

        Hashtable table = new Hashtable();

        // 1. 正常插入
        //table.put("john", 100); // ok

       /* // 2. key 不能为 null -> 运行时 NullPointerException
        try {
            table.put(null, 100);
        } catch (NullPointerException e) {
            System.out.println("key 不能为 null -> " + e);
        }

        // 3. value 不能为 null -> 运行时 NullPointerException
        try {
            table.put("john", null);
        } catch (NullPointerException e) {
            System.out.println("value 不能为 null -> " + e);
        }
*/
        // 4. 正常数据
        /*table.put("lucy", 100);
        table.put("lic", 100);

        // 5. key 重复 -> value 会被替换
        table.put("lic", 88);
*/


        //扩容问题
        for (int i = 0; i < 11 ; i++) {
            table.put(Integer.toString(i), i);
        }

        /**
         * <pre>
         *     简单说明一下Hashtable的底层。
         *     1. 底层有一个数组,HashTable$Entry[]初始化大小为 11
         *     2. (临界值) threshold 8 = 11 * 0.75f
         *     3. (扩容) 按照一个扩容机制来进行
         *     3.1 为什么扩容会是 大小为23（11 *2 +1 = 23） 而不是22（两倍扩容）
         *     3.2 put方法里 addEntry(hash, key, value, index);方法添加k-v，封装到Entry
         *     3.3 count >= threshold 进入 rehash();
         *     3.4 int newCapacity = (oldCapacity << 1) + 1; (左移一位( *2 ) +1)
         *     3.4 真正进行扩容  Entry<?,?>[] newMap = new Entry<?,?>[newCapacity];
         * </pre>
         *
         *
         * */

        // 输出结果
        System.out.println(table);
    }
}