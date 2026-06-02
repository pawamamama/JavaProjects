package com.pawamamama.innerclass.MemberInnerClass;

/*成员内部类
 * 说明：1.定义在外部类的成员位置，并且没有static修饰
 *
 *
 *
 * */
public class MemberClass {
    public static void main(String[] args) {
        Outer outer = new Outer();
        outer.t1();
        //6.外部其他类访问--->成员内部类，要遵守访问修饰符
        //方式1
        //通过外部类的对象 new 了一个内部类的实例，
        //outer.new Inner();把 new Inner()当作outer的成员，语法
        Outer.Inner inner = outer.new Inner();

        //方式2 在外部类创建好内部类对象后返回引用
        Outer.Inner inner1 = outer.getInner();
        inner1.say();

        //方式3 new 外部类实例.new 内部类实例，接收内部类的引用
        //本质和方式1是一样的都是通过了一个外部类的实例去创建内部类
        Outer.Inner inner2 = new Outer().new Inner();

        //结论：没有外部类实例就不能创建内部类


    }
}

class Outer {
    private String pawa = "外部类类成员pawa";
    private int n1 = 10;
    public String name = "wang";

    //2.可以添加访问修饰符和 final
    public class Inner {//成员内部类
        private String pawa = "内部类类成员pawa";
        private int n2 = 10;
        public void say() {
            //3.直接访问外部类所有的成员，包含私有
            System.out.println("Outer的 name = " + name + "Outer的 n1 = " + n1);
        }
        public void testPawa() {
            String pawa = "内部类方法成员pawa";
            //7.外部类和内部类成员重名时 ，内部类访问遵循就近原则，如果想访问外部类同名成员要用
            System.out.println(pawa);
            System.out.println(this.pawa);
            System.out.println(Outer.this.pawa);
            //按照这样去访问
        }
    }

    //写一个方法使用Inner的say方法
    public void t1() {
        //使用了成员内部类
        //外部类使用成员内部类需要创建对象
        Inner inner = new Inner();
        inner.say();
        //私有的也行，因为都在一个类中
        System.out.println("n2 = " +inner.n2);


    }
    {//4.作用域为整个外部类都能去使用
        new Inner().say();
    }
    {
        //5.还可以写成匿名内部类
        new Inner()  {
            @Override
            public void say() {
                System.out.println("mamama");
            }
        }.say();
    }
    //方式2
    public Inner getInner() {
        return new Inner();
    }
}
