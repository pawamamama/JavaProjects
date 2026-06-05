package com.pawamamama.wrapper.string_;
/**
 * @author pawamamama
 * Date: 2026/6/5
 * 创建String象的两种方式
 * 1.直接赋值 String s = "pawamamama";
 *   先从常量池查看是否有"pawamamama"数据空间,如果有直接指向,如果没有则重新创建，然后指向。s最终指向的是常量池的空间地址
 * 2.调用构造器 String s = "pawamamama"
 * 先在堆中创建空间里面维护了value属性指向常量池的"pawamamama"空间。
 * 如果常量池中没有hsp.重新创建，如果有直接通过value指向。最终指向的是堆中的空间地址。
 *
 */

public class String02 {
    public static void main(String[] args) {
    String s = "pawa";
    }
}
