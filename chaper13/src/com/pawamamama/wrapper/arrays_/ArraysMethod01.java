package com.pawamamama.wrapper.arrays_;

import java.util.Arrays;
import java.util.Comparator;

/**
 * ArraysMethod01
 *
 * <p>演示 Arrays 工具类常用方法：
 * <ul>
 *     <li>Arrays.toString()：返回数组的字符串形式</li>
 *     <li>Arrays.sort()：自然排序和自定义 Comparator 排序</li>
 * </ul>
 *
 * <p>重点：自定义排序和 Comparator 的使用
 *
 * @author pawamamama
 * @since 2026/6/8
 */
public class ArraysMethod01 {
    public static void main(String[] args) {
        //1.toStirng() 返回数组的字符串形式
        int [] intArray = {1,2,3,4,5};
        String sIntArray = Arrays.toString(intArray);
        System.out.println(Arrays.toString(intArray));
        //2. sort排序 (自然排序和定制排序)
        Integer [] intArray2 = {-15,32,37,-84,56,4};
        //进行排序，可以使用冒泡 但是太麻烦直接用 sort方法
        Arrays.sort(intArray2);//因为数组是引用类型，所以过方法排序后影响到实参
        System.out.println(Arrays.toString(intArray2));
        //3.sort是重载的，也可以传入一个接口 Comparator 实现定制排序
        //定制排序
            //3.1调用定制排序时，传入两个参数  (1)要排序的数组 (2) 实现了Comparator 接口的匿名内部类
                //要求是实现 compare 方法
            //3.2这里实现了接口编程
                //sort调用了TimSort.sort 里面继续调用 binarySort方法 binarySort方法底层会调c.compare用c.compare(pivot, a[mid])
                /*while (left < right) {
                    int mid = (left + right) >>> 1;
                    if (c.compare(pivot, a[mid]) < 0)//这里小于零就走逆序
                        right = mid;
                    else
                        left = mid + 1; //默认和大于就走正常排序
                }*/
            // 实现了Comparator接口的对象重写的compare方法，来决定排序内容
                //再通过Object.compare通过调换 Object o1, Object o2 位置升序降序来实现
            //默认是升序 返回  0

            //这样是升序 返回值> 0
            //return Integer.compare((Integer)o1,(Integer)o2);
            //这样是降序 返回值< 0
            //return  Integer.compare((Integer)o2,(Integer)o1);
                //Integer.compare底层是一个简单的if判断
                // 直观看到配合c.compare然后再配合binarySort方法方法实现就能进行对排序的选择
                /*public static int compare(int x, int y) {
                    return (x < y) ? -1 : ((x == y) ? 0 : 1);
                }*/
            //定制排序完成
        Integer [] intArray3 = {-15,32,37,-84,56,4};
        Arrays.sort(intArray3,new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
               return 0;
            }
        });
        System.out.println("==================");
        System.out.println(Arrays.toString(intArray3));
    }


}