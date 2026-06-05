/*
package com.pawamamama.wrapper;

*/
/**
@author pawamamama
import java.sql.Wrapper;==============================
包装类（
Wrapper Class）
==============================

1. 什么是包装类？

Java中的基本数据类型不是对象，
而很多功能（集合、泛型等）只能操作对象。

因此Java提供了对应的包装类，
用于将基本数据类型包装成对象。


2. 八大基本类型对应包装类

byte    -> Byte
short   -> Short
int     -> Integer
long    -> Long
float   -> Float
double  -> Double
前面的继承Number父类
char    -> Character
boolean -> Boolean
这两个直接继承obj

import java.util.ArrayList;3. 包装类的作用

（1）让基本类型具有对象特性

（2）可以存入集合

    ArrayList<Integer>

（3）提供许多实用方法

    Integer.parseInt()
    Integer.toString()


4. 自动装箱（基本类型 -> 包装类）

int n = 100;

Integer i = n;

实际执行：

Integer i = Integer.valueOf(n);


5. 自动拆箱（包装类 -> 基本类型）

Integer i = 100;

int n = i;

实际执行：

int n = i.intValue();


6. 常用方法

（1）字符串转整数

int n = Integer.parseInt("123");


（2）整数转字符串

String s = Integer.toString(123);


7. 使用示例

Integer num = 100;

System.out.println(num);

System.out.println(num.toString());


8. 注意事项

（1）包装类属于引用类型

Integer i = 100;

（2）基本类型属于值类型

int n = 100;

（3）包装类可以为null

Integer i = null;

（4）基本类型不能为null

int n = null;   // 编译错误


9. 学习阶段重点掌握

① Integer.parseInt()

② 自动装箱

③ 自动拆箱

④ equals() 与 == 的区别


一句话总结：

包装类 = 基本数据类型对应的对象类型。
作用是让基本类型拥有对象的能力。
*//*

class WrapperType {
    public static void main(String[]args) {
      */
/*  byte    -> Byte
        short   -> Short
        int     -> Integer
        long    -> Long
        float   -> Float
        double  -> Double
        前面的继承Number父类
        char    -> Character
        boolean -> Boolean
        这两个直接继承obj*//*


    }
}
*/
