package com.pawamamama.innerclass.AnonymousIinnerClsss;

/*
 * 匿名内部类
 * 1.本质还是类
 * 2.在类内部
 * 3.没有名字
 * 说明：匿名内部类是定义在类的局部位置 方法或者代码块 没有类名
 * */
public class Anonymouse {
    static void main(String[] args) {
        Outer outer = new Outer();
        outer.method();
    }
}


interface IA {
    public void cry();
}


class Outer {
    private int n1 = 10;


    public void method() {//

        //interface  AnonymouseClass
        //1.接口匿名内部类简化开发
        //2.创建完成Outer$1后直接new创建了一个Outer$1实例，并且把地址给tiger
        //3.匿名内部类使用一次就不能使用了，类加载生成对象后就会销毁
        //4.生成的对象可以多次使用
        //5.这里匿名不是说没有名字，而是方法体内的信息只能new一个对象
        IA tiger = new IA() {
            @Override
            public void cry() {
                System.out.println("Tiger cry~~");
                System.out.println();
            }
        };
        //匿名内部类名字是系统分配的 为外部类名字$编号从一开始
        System.out.println("Tiger = " + tiger.getClass());
        tiger.cry();

        //基于类的匿名内部类
        //1.编译类型 father
        //2.运行类型 Outer$2(不带括号就是在方法内创建一个father对象)
        //3.class Outer$2 extends Father
        //4.继承了father

        Father father = new Father("javac") {//6.这里的形参列表是会传到父类构造器中进行初始化
            //5.不能有构造器没意义
            @Override
            public void test() {
                System.out.println("重写~~");
            }
            public void test2() {
                System.out.println("独有方法");
            }
        };//分号不能少这是一个方法内的语句
        System.out.println("Father = " + father.getClass());
    }
}

class Father {
    public Father(String name) {//
        super();
    }

    public void test() {//

    }
}
