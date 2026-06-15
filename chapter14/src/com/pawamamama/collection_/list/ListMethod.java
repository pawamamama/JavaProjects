package com.pawamamama.collection_.list;

import java.util.ArrayList;
import java.util.List;

/**
 * Class: ListMethod
 *
 * <pre>
 * </pre>
 *
 * @author pawamamama
 * @date 2026/6/15
 */
public class ListMethod {
    @SuppressWarnings({"all"})
    public static void main(String[] args) {
        List list = new ArrayList();
        list.add("pawa");
        list.add("pawamamama");
        list.add("wangweixin");


        // 1. add(int index, Object ele)
        // 在指定 index 位置插入元素 ele
        //在 index = 1 的地方插入对象
        list.add(1, "插入1");
        System.out.println(list);


        // 2. addAll(int index, Collection eles)
        // 从指定 index 位置开始，将集合 eles 中所有元素插入
        List newList = new ArrayList();
        newList.add("new1");
        newList.add("new2");
        newList.add("new3");
        list.addAll(0, newList);
        System.out.println(list);//其他元素向后移动


        // 3. get(int index)
        // 获取指定 index 位置的元素
        System.out.println(list.get(2));

        // 4. indexOf(Object obj)
        // 返回 obj 在集合中第一次出现的位置
        int index = list.indexOf("pawa");
        System.out.println("pawa = " + index);
        int index1 = list.indexOf("pawamamama");
        System.out.println("pawamamama = " + index1);


        // 5. lastIndexOf(Object obj)
        // 返回 obj 在集合中最后一次出现的位置
        int lastIndex = list.lastIndexOf("pawamamama");
        System.out.println("最后出现的pawamamama位置是 = " + lastIndex);

        // 6. remove(int index)
        // 删除指定 index 位置的元素，并返回该元素
        Object object = list.remove(0);
        System.out.println("被删除的元素是" + object);//编译类型是obj 运行类型是有动态绑定机制的
        // 7. set(int index, Object ele)
        // 将指定 index 位置的元素替换为 ele，并返回原元素，替换必须存在
        System.out.println("替换前"+list);
        Object oldObject = list.set(1, "set替换后");
        System.out.println("原来索引为1的为" + oldObject);
        System.out.println("现在索引为1的被set替换了\n" + list);
        // 8. subList(int fromIndex, int toIndex)
        // 返回从 fromIndex 到 toIndex（左闭右开）的子集合
        List listcopy = list.subList(3,list.size());
        System.out.println("截取过的"+listcopy);
        System.out.println("原集合"+list);
    }


}