package com.hspedu.poly_.objpoly_;
public class PolyObject {
    public static void main() {
        //体验对象多态特点
        //Animal 编译类型是 Animal
        Animal a = new Animal();//运行时是Animal
        a.cry();//a的运行类型是Animal
        a = new Cat();//运行时是Cat
        a.cry();//这时 a的运行类型是 Cat
        a = new Dog();
        a.cry();
        //体现了a对象运行时是有多种状态的
    }
}
