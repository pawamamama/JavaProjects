package com.pawamamama.wrapper.arrays_;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * ArraysMethod02 Arrays 其他方法
 *
 * <pre>
 *     1.Arrays.binarySearch()
 *          1.1通过二分搜索法进行查找，要求有序数组
 *          1.2如果该数组是无序的，不能使用binarySearch 不会报错但是查找会错
 *          1.3  binarySearch 的返回值设计
 *          Arrays.binarySearch 不会简单返回 -1，而是返回 -(插入点) - 1
 *              1.3.1
 *                  插入点就是保持数组排序的情况下，key 应该放的位置
 *              1.3.2
 *                  这个设计方便你直接在 保持排序的数组中插入元素。
 *
 *              1.3.4底层真正返回return -(low + 1);  // key not found.
 *                  返回的是 -( 末尾元素 +1) = 该元素应应该存在的位置,取负数是为了和索引区分
 *                  方法进行我们插入数据
 *      2.copyOf 数组元素的复制
 *          2.1 Integer [] newArr = Arrays.copyOf(arr, arr.length);
 *              2.1.1 从 arr 数组中拷贝 arr.length 个元素到newArr
 *              2.1.2 newArr是独立存在的
 *          2.2 arr.length 控制copy个数
 *              2.2.1 拷贝长度 > arr.length  会给你在尾部增加 null 没有数值存放但是 可以自行赋值
 *              2.2.2 拷贝长度 == 0  返回该对象的空数组 new Object[newLength] 底层直接返回
 *              2.2.3 拷贝长度 < 0  抛异常 java.lang.NegativeArraySizeException 负的数组大小异常
 *              2.2.4 该方法底层用的System.arraycopy方法
 *      3.fill 数组元素填充
 *          3.1 Arrays.fill(arr2,999);
 *              3.1.1 用999填充改写 arr2 数组 arr里面所有的数值现在都是999
 *              3.1.2 替换原来的元素
 *      4.equals 比较两个数组 内容是否完全一致
 *          4.1 bool值
 *             4.1.1 两个数组元素一样，返回 true
 *             4.1.2不一样返回 false
 *      5.asList 将一组值转换成 list
 *          5.1 List 是一个接口
 *              5.1.1 list 运行类型是 class java.util.Arrays$ArrayList
 *              5.1.2 list 编译类型是 List 接口类型
 *              //ArrayList 是一个静态内部类 在 Arrays中
 *          List<Integer> list =  Arrays.asList(2,3,4,5,6);
 *         System.out.println("asList = " + list);
 *
 *
 *
 *
 *
 * </pre>
 *
 * @author pawamamama
 * @since 2026/6/9
 */
public class ArraysMethod02 {
    public static void main(String[] args) {
        //1.
        Integer [] arr ={1,2,3,4,5,6 };
        int i = Arrays.binarySearch(arr, 1);//找到了返回下标
        //1.3.4演示
        int i1 = Arrays.binarySearch(arr, 20);
        if (i1<0) {
            System.out.println("没找到，插入点：" + -i1);
        }
        System.out.println(i);
        //2.
        Integer [] newArr = Arrays.copyOf(arr, arr.length);
        Integer [] newArr2 = Arrays.copyOf(arr, arr.length-1);//这里可以控制copy的元素
        Integer [] newArr3 = Arrays.copyOf(arr, arr.length+1);//这里可以控制copy的元素 null
        System.out.println("=======================");
        System.out.println(Arrays.toString(newArr));
        System.out.println("=======================");
        System.out.println(Arrays.toString(newArr2));
        System.out.println("=======================");
        System.out.println(Arrays.toString(newArr3));
        System.out.println("=======================");
        newArr3[newArr3.length-1] = 100;//还可以添加
        System.out.println(Arrays.toString(newArr3));
        //3.数组填充
        Integer[] arr2 = {1,2,3,4,5,6};
        Arrays.fill(arr2,999);
        System.out.println(Arrays.toString(arr2));
        //4.equals
        Integer[] arr3 = {1,2,3,4,5,6};
        boolean equals = Arrays.equals(arr,arr3);
        System.out.println(equals);
        //5
        List<Integer> list =  Arrays.asList(2,3,4,5,6);
        System.out.println("asList = " + list);
        //查看运行类型
        System.out.println("asList = " + list.getClass());


    }

}