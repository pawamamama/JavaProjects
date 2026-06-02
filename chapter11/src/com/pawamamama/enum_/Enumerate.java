package com.pawamamama.enum_;

import java.sql.SQLOutput;

public class Enumerate {
    public static void main(String[] args) {

        // 输出春天的信息
        System.out.println(Season.SPRING);
        //
        System.out.println(Season.SUMMER);
       //
        System.out.println(Season1.mama);
    }
}

/**
 * 四季枚举类
 *
 * final 不能继承
 */

enum Season {


    //1.常量名(实参列表)
    //2.有多个常量对象，使用,号隔开
    //3.枚举对象（必须写在最前面）语法规定
    SPRING("春天", "温暖"),
    SUMMER("夏天", "炎热"),
    AUTUMN("秋天", "凉爽"),
    WINTER("冬天", "寒冷"),
    TEST;//使用无参构造器可以省略()
    // 季节名称
    private String name;

    // 季节特点
    private String description;
    /**
     * 构造器
     * 枚举的构造器默认是 private
     * 如果使用无参构造器
     */
    Season() {
    }

    Season(String name, String description) {
        this.name = name;
        this.description = description;
    }

    /**
     * 重写 toString 方法
     */
    @Override
    public String toString() {
        return "Season{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
enum Season1 {
    mama,bab;
    //默认有构造器
    @Override
    public String toString() {
       return super.toString();
    }
}