package com.pawamamama.innerclass.LocalInnerCass;

/*1.局部内部类详解
 * */
public class Local {//其他类

    static void main(String[] args) {
        //局部内部类在其他类中使用需要创建外部类，然后调用所在内部类的方法
        //而且必须在方法内有相应的创建内部对象调用方法
        Outer outer = new Outer();
        outer.m1();
        //6.外部其他类不能直接访问局部内部类
    }
}

class Outer {//外部类
    private int n1 = 10;
private int n2 = 20;
    private void m2() {
    }

    {//代码块中定义内部类
        class Inner3 {
            //3.作用域：仅仅在定义他的代码块或方法中
        }
        new Inner3();
    }

    public void m1() {
        //局部内部类定义在外部类的局部位置，通常是在方法并且有类名
        //2.不能添加访问修饰符，因为他的地位就是一个局部变量，但是可以使用 final修饰
        final class Inner {//局部内部类(本质还是类)
            private  int n1 = 900;

            //1.可以直接访问外部类的所有成员，包含私有
            public void getN1() {
                int n1 = 100;
                //4.局部内部类可以直接访问外部类的成员
                System.out.println("n2 = " + n2);
                m2();
                //7.外部类和局部内部类成员重名时，默认就近原则，如果想访问外部类的成员
                //使用外部类名.this.成员去访问
                System.out.println("n1 = " + n1);//方法成员
                System.out.println("this.n1 = "+this.n1);//内部类成员
                System.out.println("Outer.this.n1 = " + Outer.this.n1);//外部类成员
            }
        }
        //加了final 意味着你的局部内部类是不能被继承的
        //class  Inner2 extends Inner{}//错误

        //5.外部类在方法中，可以创建Inner对象，然后调用方法即可
        Inner inner = new Inner();
        inner.getN1();

    }
}
