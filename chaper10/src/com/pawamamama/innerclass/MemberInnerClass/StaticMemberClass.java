package com.pawamamama.innerclass.MemberInnerClass;


/*
 *静态内部类
 *说明：静态内部类时定义在外部类的成员位置，并且有static修饰
 *
 *
 *
 * */
public class StaticMemberClass {
    public static void main(String[] args) {
        Outer01 outer01 = new Outer01();
        outer01.m1();
        //外部其他类访问静态内部类
        //方式1
        //静态内部类可以直接通过 new 外部类名.内部类名()
        //这里就不用创建外部类对象直接创建静态内部类
        Outer01.Inner inner = new Outer01.Inner();
        inner.say();
        //方式二
        // 外部类中写一个静态或者普通方法 创建好静态内部类对象后返回引用
        //静态方法不需要创建外部类实例
        Outer01.Inner inner1=  Outer01.getInner();
        //这个需要外部类实例
        Outer01.Inner inner2=  outer01.getInner2();
    }
}

class Outer01 {
    private static String name = "wang";

    //静态内部类
    //3.可以使用修饰符 final
    //4.作用域为整个Outer01类体
    public final static class Inner {
        public void say() {
            //2.可以直接访问外部类所有的静态成员，包含私有的，但不能直接访问非静态成员
            System.out.println(name);
            //重名要遵守就近原则 这里不能出现this 所以不用加直接类名.成员

        }
    }

    public void m1() {
        //外部类访问静态成员内部类要new 对象
        Inner inner = new Inner();
        inner.say();
    }

    public static Inner getInner() {
        return new Inner();
    }
    public  Inner getInner2() {
        return new Inner();
    }
}