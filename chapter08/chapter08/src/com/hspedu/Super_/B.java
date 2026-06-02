package com.hspedu.Super_;
// 子类 B
public class B extends A {
    public int n1 = 888;
    public void tset() {
        //Super的访问不前限于直接父类,如果爷爷类和苯类有同名的成员,也可以使用super去访问爷爷类的成员
        // 如果多个基类(上级类)都有同名的成员,使用super访问遵循就近原则  c->b->a->Object
        //当然也需要遵守访问权限的相关规则
        System.out.println("super.n1 = "+super.n1);//100
        System.out.println("((Base)super).n1 = "+((Base)this).n1);//999
        super.cal();
        System.out.println(age);
        System.out.println(this.age);
        System.out.println(super.age);

        eat();
        this.eat();
        super.eat();



    }
    // 1：访问父类属性
    public void hi() {

        // 可以访问 public
        System.out.println("n1 = " + super.n1);

        // 可以访问 protected
        System.out.println("n2 = " + super.n2);

        // 可以访问默认修饰符（同包情况下）
        System.out.println("n3 = " + super.n3);

        // private 不能访问
        // System.out.println("n4 = " + super.n4);
    }

    // 2：访问父类方法
    public void ok() {

        // 可以访问 public 方法
        super.test100();

        // 可以访问 protected 方法
        super.test200();

        // 可以访问默认方法（同包情况下）
        super.test300();

        // private 方法不能访问
        // super.test400();
    }
    public void cal() {
        System.out.println("B类的cal方法");
    }
    public void sum() {
        System.out.println("B类的sum()");
        // 有三种方法
        //找cal方法（cal()和this.cal()）顺序是
        //先找本类，如果有，则调用
        //如果没有，则找父类(如果有，并可以调用，则调用 )
        //如果父类，没有则继续找父类的父类，整个规则，就是一样的 ，直到Object
        //提示：如果查找方法的过程中 找到了 但是是私有方法，则直接报错
        // 如果查找方法的过程中 没找到 则提示方法不存在
        cal();
        this.cal();//等价 cal()
        super.cal();//直接去查找父类，  跳过子类
        //演示访问属性的规则
        //n1 和 this.n1 查找规则和上面方法规则一样
        System.out.println(n1);
        System.out.println(this.n1);
        System.out.println(super.n1);


    }
    //3.访问父类的构造器， super(参数列表) 只能放在构造器的第一句，不可以和this（参数列表）放在一起二选一
    public B() {
        super();

    }
    public B(String name) {
        super(name);
    }
    public B(String name,int age) {
        super(name,age);
    }
}