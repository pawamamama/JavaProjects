package com.pawamamama.abstract_;
/*抽象类
*
*
* */
public class Abstract01 {

}
//排列
//访问权限 → static → final → abstract → class
abstract class Animal {
    private String name;

    public Animal(String name) {
        this.name = name;
    }
    //eat 实现了没有意义
    //父类方法不确定性
    //考虑将方法设置成抽象（Abstract）
    //抽象方法就是没有实现的方法
    //没有实现就是没有方法体
    //当一个类中存在抽象方法时需要将该类声明为abstract类
    //抽象类会被继承,其子类会将抽象方法实现
    public abstract void eat();
}
class Dog extends Animal {
    public Dog(String name) {
        super(name);
    }
    @Override
    public void eat() {
        System.out.println("狗吃肉 ");
    }
}
