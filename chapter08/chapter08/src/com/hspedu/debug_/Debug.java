package com.hspedu.debug_;

import java.util.Arrays;

public class Debug {
    static void main() {
        //debug 源码
        int[] arr = {8,-1,199,70,10};
        //查看Arrays.sort方法的底层实现 -> Debug
        Arrays.sort(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]+ "\t");
        }
        System.out.println("mama");
    }
}
