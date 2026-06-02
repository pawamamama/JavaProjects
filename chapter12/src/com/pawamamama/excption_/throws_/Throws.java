package com.pawamamama.excption_.throws_;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * @author pawamamama
 * torows介绍
 * 1.如果一个方法(语句执行时)可能生成某种异常，但是并不能确定如何处理这种异常
 *   则此方法应显示声明抛出异常，表明该方法将不对这些异常进行处理，由该方法的调用者处理。
 * 2.在方法声明中，throws语句可以声明抛出的异常的列表
 *   throws后面的异常类型可以是方法中产生的异常类型，也可以是他的父类
 */
public class Throws {
    public static void main(String[] args) {

    }
    //
    //A抛出处理
    public static void f3() throws Exception{
        f1();
    }
    //B就地try-catch处理
    public static void f2(){
        try {
            f1();//抛出异常，调用就要处理
        } catch (Exception e) {
            System.out.println("文件读写异常");
        }
    }
    //2.使用throws抛出异常给调用处 处理                                          //4.throws后面可以是列表
    public static void f1() throws Exception /*3.也可以直接写编译异常有个继承*/,FileNotFoundException {
        //创建了一个文件流对象        编译异常
        //1.使用了throws抛出异常解决
        FileInputStream fls = new FileInputStream("d://aa.txt");
    }
}
