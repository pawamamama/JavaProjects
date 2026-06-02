package com.pawamamama.innerclass.AnonymousIinnerClsss;

public class AnonymouseDetail {//

    public static void main(String[] args) {
        Outer01 outer01 = new Outer01();
           outer01.method();
    }
}

class Person {
    public void hi() {
        System.out.println("  person - hi");
    }
}
class Top {
public int n1 = 10000;
}
//抽象类和接口和类都可以写
class Outer01 extends Top {
    private int n1 = 900;

    public void  method() {
        //基于类的匿名内部类
        //调用hi方法
        Person xiaoming = new Person() {
            @Override
            public void hi() {
                System.out.println("  xiaoming - hi");
            }
        };
        //1.有动态绑定机制
        xiaoming.hi();//运行类型是 Outer01$1

        //2.也可以直接调用，内名内部类本身直接返回对象
        new Person() {//得到对象后直接用，不用接收了
            public void hi(String name) {
                System.out.println(name + " - hi");
            }
        }.hi("xiaoming2");//这里看成 Outer.hi("xiaoming2")
        //3.可以直接访问外部类所有的成员，包含私有
        //4.不能添加访问修饰符，因为地位就是一个局部变量
        new Person() {
            //5.内部可以添加访问修饰符，撑死是个对象呗
            private void n1() {
                System.out.println(n1);
            }

        }.n1();//匿名内部类私有方法可以在定义他的地方使用 ,因为没有给Person引用 而是自己的Outer01$2.n1()
        //6.作用域：类使用范围在定义他的方法或者代码块中
        // 7.但是对象可是创建了，可以使用方法返回对象引用让这个对象活的久一点
        //8.成员重名时，匿名内部类访问遵循就近原则，访问外部类的成员使用 外部类名.this.成员 去访问
        new Person() {
            int n1 = 0;
            private void n1() {
                int n1 = 10;
                System.out.println("匿名内部类成员的方法内部成员"+n1);
                System.out.println( "匿名内部类成员"+ this.n1);
                System.out.println("匿名内部类对象 hash = " + this);
                System.out.println("外部类成员"+Outer01.this.n1);
                System.out.println("外部类对象 hash = " + Outer01.this);
                System.out.println("外部类的父类成员"+Outer01.super.n1);
                System.out.println("外部类对象 hash = " +Top.class);
                //按照这种写法去访问就没问题
                //本质是创建了一个查找关系，由编译器和jvm来管，会用就行

            }
        }.n1();
    }
}