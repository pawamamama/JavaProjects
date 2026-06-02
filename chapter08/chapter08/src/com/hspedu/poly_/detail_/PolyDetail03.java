package com.hspedu.poly_.detail_;

public class PolyDetail03 {
    static void main() {
        BB bb = new BB();
        //比较操作符用于判断对象的运行类型
        //是否为XX类型 或XX类型的子类型
        System.out.println(bb instanceof BB);//true
        System.out.println(bb instanceof AA);//true
        System.out.println(bb instanceof AA);//true
        AA aa = new BB();
        System.out.println(aa instanceof AA);//true
        System.out.println(aa instanceof BB);//true
         Object object = new Object();
        System.out.println(object instanceof AA);//false
        String str = "hello";
        System.out.println(str instanceof Object);//true



    }
}
class AA {

}
class BB extends AA{

}