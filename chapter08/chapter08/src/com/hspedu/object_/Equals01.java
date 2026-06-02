package com.hspedu.object_;

public class Equals01 {
    static void main(String[] args) {
        A a = new A();
        A a1 = a;
        A a2 = a1;
        // == 判断的是 引用类型的地址是否相等
        System.out.println(a == a2);//true
        System.out.println(a1 == a2);//true
        B bobj = a;
        System.out.println(bobj == a2);//ture
        //String的equals 吧Obj的equals方法重写了，变成了比较两个字符串值是否相等
        boolean ispass = "hello".equals("abc");
        //Object的equals方法默认就是比较对象地址是否相同
        //也就是判断 两个对象是不是同一个对象
        /*public boolean equals(Object obj) {
            return this == obj;
        }*/


       //Integer 也重写了 Obj 的 equal 方法用于判断两个int值是否相等
       /* public boolean equals(Object obj) {
            if (obj instanceof Integer i) {
                return value == i.intValue();
            }
            return false;
        }*/
        Integer integer = new Integer(10);
        integer.equals("string");


        Integer integer1 = new Integer(1);
        Integer integer2 = new Integer(3);
        System.out.println(integer1 == integer2);//false


        String string1 = new String("hsp");
        String string2 = new String("hsp");

        System.out.println(string1 == string2);//false

        System.out.println(string1.equals(string2));//true

    }
}

class  B{

}
class A extends B {

}