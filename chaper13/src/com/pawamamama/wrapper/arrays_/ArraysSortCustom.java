package com.pawamamama.wrapper.arrays_;

import java.util.Arrays;
import java.util.Comparator;

/**
 * ArraysSortCustom 使用冒泡排序实现自定义排序
 *
 * <pre>
 * Comparator.compare(o1, o2)
 *
 * 返回值说明：
 * < 0 : o1 应该排在 o2 前面
 * = 0 : 两者位置无所谓
 * > 0 : o1 应该排在 o2 后面
 *
 * 冒泡排序核心逻辑：
 *
 * if(compare(arr[j], arr[j + 1]) > 0){
 *     //交换
 * }
 *
 * 因此冒泡排序本身无需关心升序还是降序，
 * 只负责根据 compare() 的返回值决定是否交换。
 *
 * 升序：
 * compare(a,b)
 * a < b -> -1 -> 不交换
 * a > b -> 1  -> 交换
 *
 * 降序：
 * compare(b,a)
 * a < b -> 1  -> 交换
 * a > b -> -1 -> 不交换
 *
 * 本质：
 * 调换 compare() 参数顺序，
 * 就相当于改变了排序规则。
 *
 * 例如：
 *
 * Integer.compare(o1,o2) -> 升序
 * Integer.compare(o2,o1) -> 降序
 *
 * 核心思想：
 * 排序流程固定，
 * 比较规则可替换。
 *
 * 将"谁应该排在前面"的判断
 * 从排序算法中抽离出来，
 * 这正是策略模式(Strategy Pattern)的思想。
 *
 * 收获：
 * 冒泡排序只写一套逻辑，
 * 通过传入不同 Comparator 实现不同排序规则。
 * </pre>
 *
 * @author pawamamama
 * @since 2026/6/9
 */
public class ArraysSortCustom {
    public static void main(String[] args) {
        int [] intArray3 = {-15,32,37,-84,56,4};
        bubbleSort(intArray3);
        System.out.println(Arrays.toString(intArray3));
        //定制排序
        int [] intArray4 = {-15,-32,37,-84,56,4};
        bubbleSort2(intArray4, new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                return Integer.compare((Integer)o2,(Integer)o1);
                // return (x < y) ? -1 : ((x == y) ? 0 : 1);
                //-1和0 是默认升序
                //-1 说明 是有序升序
                //0  说明 是相等不用调换
                //1  说明
            }
        });
        System.out.println(Arrays.toString(intArray4));


    }
    //使用冒泡排序
     public static void bubbleSort(int[] arr){
        int temp = 0;
        for(int i=0;i<arr.length-1;i++){
            for(int j=0;j<arr.length-1-i;j++){
                if(arr[j]>arr[j+1]){
                     temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                } else {

                }
            }
        }
     }
     //结合冒泡进行定制排序
    public  static void bubbleSort2(int[] arr, Comparator c){
        int temp = 0;
        for(int i=0;i<arr.length-1;i++){
            for(int j=0;j<arr.length-1-i;j++){
                //把要比较的数据传入，通过匿名内部类进行操作完成之后决定排序的升降序
                if(c.compare(arr[j],arr[j+1])>0){
                    temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
    }

}