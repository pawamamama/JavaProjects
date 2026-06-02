package com.hspedu.extend;

/**
 * 讲解继承的本质
 *
 */
public class ExtendsTheory {
    static void main(String[] args) {
        Son son = new Son();//内存布局发生了什么
        //这里按照查找关系来返回数据
        //1. 先看子类是否有该属性
        //2. 有这个属性，并且可以访问，则返回信息
        //3. 如果子类没有这个属性，就向父类找，就看父类有没有这个属性（有并且可以访问，就返回信息）
        //4.如果父类没有就按照3， 的规则 ，继续向上找，直到 Object...
        //5,如果父亲类有私有属性，按照查找规则，遇到private 不会继续追溯到爷类，会直接报错
        System.out.println(son.name);
        //System.out.println(son.age);
        System.out.println(son.getAge());
        System.out.println(son.hobby);

    }
}

class GrandPa {//爷类
    String name = "大头爷爷";
    String hobby = "旅游";
    int age = 100;
}

class Father extends GrandPa {//父类
    String name = "大头爸爸";
    //int age = 39;
    //私有变量可以同过本类的public方法去访问

    private int age = 39;
    public int getAge() {
        return age;
    }
}

class Son extends Father {//子类
    String name = "大头儿子";
}

