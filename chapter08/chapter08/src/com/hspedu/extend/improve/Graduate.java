package com.hspedu.extend.improve;
//让Graduate 继承student
public class Graduate extends Student{

    public void test() {
        System.out.println(
                "大学生 " + name +
                        " 正在考大学数学"
        );
    }
}
