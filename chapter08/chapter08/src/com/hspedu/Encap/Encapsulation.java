package com.hspedu.Encap;

import java.util.Scanner;

public class Encapsulation {
    static void main(String[] args) {
        Person p = new Person();
        p.setName("jac,c,c,k");
        p.setAge(300);
        p.setSalay(30000.999);
        //输出
        String info = p.info();
        System.out.println(info);
       /* //查密码
        Double salay = p.getSalay();
        System.out.println(salay);*/
        //构造器 + 封装
        System.out.println("--------- baba的信息如下 ---------");
        Person p2 = new Person("baba", 300, 3000.1);
        //输出
        String info2 = p2.info();
        System.out.println(info2);


    }
}

class Person {
    public String name;//名字公开
    private int age;//年龄私有
    private double salay;//月薪私有
    //构造器

    public Person() {
    }

    //有三个属性的构造器
    public Person(String name, int age, double salay) {
      /*  this.name = name;
        this.age = age;
        this.salay = salay;*/
        //可以这么干
        //将set方法引用在构造器中
        setName(name);
        setAge(age);
        setSalay(salay);
    }

    //手写太慢直接 使用快捷键直接构造alt + insert  选Getter And Setter
    //完善代码
    public String getName() {
        return name;
    }

    public void setName(String name) {
        //加入对数据的效验,相当于增加了业务逻辑
        if (name.length() >= 2 && name.length() <= 6) {
            this.name = name;
        } else {
            System.out.println("字符串必须2 ~ 6字符长度,给一个默认名字无名人。 ");
            this.name = "无名人";
        }
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if (age >= 1 && age <= 120) {
            this.age = age;
        } else {
            this.age = 18;//给一个默认年龄
            System.out.println("年龄必须 1~120 给一个默认年龄18");

        }
    }

    public Double getSalay() {
        //这里可以增加一个密码判断
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入密码 ");
        int passWords = scanner.nextInt();
        if (passWords == 123456) {
            return salay;
        }
        System.out.println("密码错误");
        return null;
    }

    public void setSalay(double salay) {
        this.salay = salay;
    }

    //写一个方法返回属性信息 写一个方法返回属性信息
    public String info() {
        return "信息为 name = " + name + " age = " + age + " salay = " + salay;
    }
}
