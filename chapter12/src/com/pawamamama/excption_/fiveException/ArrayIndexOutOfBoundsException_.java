package com.pawamamama.excption_.fiveException;

/**
 * @author pawamamama
 * 演示数组下标越界异常ArrayIndexOutOfBoundsException
 * 用非法索引访问数组时抛出的异常，索引为负或大于等于数组大小，
 * 则为非法索引
 */
public class ArrayIndexOutOfBoundsException_ {
    public static void main(String[] args) {
        int [] arr = {1,1,1,1,};
        System.out.println(arr[-1]);
        System.out.println(arr[4]);
        System.out.println(arr[5]);
    }
}
