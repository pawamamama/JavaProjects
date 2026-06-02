package com.hspedu.pkg;//package需要放在类最上面 ，一个类最多只有一句package
//如何导入包

import java.util.Arrays;
//需要哪个类就导入哪个，不建议使用*
//import java.util.Scanner;//只会引入util包下的Scanner类
//import java.util.*;//把util包所有的都引入(导入)
public class Import {
    static void main(String[] args) {
        //使用系统提供的Arrays 完成排序
        int[] arr = {9,1,2,4,3,-46,7,2};
        //排序
        //用系统提供的类
        Arrays.sort(arr);
        //输出
        for (int i = 0;i < arr.length; i++) {
            System.out.print(arr[i] + "\t");
        }
    }
}
