package com.hspedu.poly_.detail_;

public class PolyDetail02 {
    static void main() {
        //属性没有重写之说，属性的值看编译类型
        //向上转型
        BASE base = new SUB();
        System.out.println(base.count);//10
        //向下转型
        SUB sub = (SUB)base;
        System.out.println(sub.count);//20


    }

}
// 定义父类 BASE
class BASE {
    int count = 10;
}

// 定义子类 SUB，继承 BASE
class SUB extends BASE {
    int count = 20;
}
