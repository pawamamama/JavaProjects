package com.hspedu.debug_;

public class DebugExercise {
    static void main() {
        //创建对象的流程
        //(1) 加载Person信息
        //(1.5)在堆中分配空间
        //(2) 初始化 2.1默认初始化 ，2.2 显式初始化 2.3 构造器初始化
        //（3）返回对象的地址
        Person p = new Person("wangweixin", 18);
        System.out.println(p);

    }
}
class Person {
    private String name;
    private int age;

    public Person(String name, int age) {

        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
