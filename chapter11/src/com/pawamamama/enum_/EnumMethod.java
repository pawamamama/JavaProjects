package com.pawamamama.enum_;

import com.pawamamama.enum_.Season;

/**
 * @author pawamamama
 * 演示Enum类的各种方法使用
 */
public class EnumMethod {
    public static void main(String[] args) {
        Season autumn = Season.AUTUMN;
        //得到enum的名称;
        System.out.println(autumn.name());
        //得到该枚举对象的次序/编号，从零开始编号
        System.out.println(autumn.ordinal());
        //得到当前所有枚举对象有一个静态数组里通过javap反编译可以看到有一个values方法
        Season[] values = Season.values();
        for (Season season : values) {//增强for循环
            System.out.println(season.toString());
        }
        //values：将字符串转换成没枚举对象，要求字符串为已有的常量名：否则异常
        //用处 外来字符串查找好找到
        Season autumn1 = Season.valueOf("AUTUMN");
        System.out.println(autumn1);
        System.out.println(autumn == autumn1);
        //compareTo 比较两个枚举长量，比较的是编号
        //前面的编号和后面的编号相减
        System.out.println(Season.AUTUMN.compareTo(Season.SUMMER));

    }
}
