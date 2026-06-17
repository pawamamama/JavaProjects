package com.pawamamama.collection_.list.arrayList;

import java.util.ArrayList;

/**
 * Class: ArrayListSource（ArrayList 源码结构与扩容机制说明）
 *
 * <pre>
 * 1. ArrayList 底层维护一个 Object 类型数组：elementData
 *
 *    transient Object[] elementData;
 *
 *    - transient：表示该字段不参与默认序列化
 *    - ArrayList 实际上会自定义序列化逻辑，避免无效容量被写入
 *
 * ------------------------------------------------------------
 *
 * 2. 无参构造器创建 ArrayList 时：
 *
 *    - 初始 elementData = 空数组
 *    - 第一次 add 时才真正分配容量
 *    - 默认初始容量扩展为 10
 *
 *    扩容流程：
 *      0 → 10 → 15 → 22 → 33 ...（每次约 1.5 倍增长）
 *
 * ------------------------------------------------------------
 *
 * 3. 指定容量构造器：
 *
 *    new ArrayList(int initialCapacity)
 *
 *    - elementData 初始容量为指定大小
 *    - 后续扩容仍按 1.5 倍增长
 *
 * ------------------------------------------------------------
 *
 * 4. 扩容规则总结：
 *
 *    newCapacity = oldCapacity + (oldCapacity >> 1)
 *    即：1.5 倍扩容
 *
 * ------------------------------------------------------------
 *
 * 5. 建议：
 *
 *    - 可以 debug ArrayList 的 add 方法
 *    - 重点观察：
 *        size（实际元素个数）
 *        capacity（数组容量）
 *        elementData 的变化过程
 *
 * </pre>
 *
 * @author pawamamama
 * @date 2026/6/16
 */
@SuppressWarnings({"all"})
public class ArrayListSource {
    public static void main(String[] args) {

        //老韩解读源码

        //注意，注意，注意，Idea 默认情况下，Debug 显示的数据是简化后的，如果希望看到完整的数据

        //需要做设置.

        //使用无参构造器创建ArrayList 对象

        //ArrayList list = new ArrayList();

          ArrayList list = new ArrayList(10);
        //使用for 给list 集合添加1-10 数据
        for (int i = 1; i <= 10; i++) {
            list.add(i);
        }

        //使用for 给list 集合添加11-15 数据
        for (int i = 11; i <= 15; i++) {
            list.add(i);
        }

        list.add(100);

        list.add(200);

        list.add(null);

    }

}
