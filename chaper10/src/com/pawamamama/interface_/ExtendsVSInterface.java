package com.pawamamama.interface_;

public class ExtendsVSInterface {
    public static LittleMonkey wukong = new LittleMonkey("wukong");

    static void main(String[] args) {
        wukong.climbbing();
        wukong.fly();
        wukong.swimming();
    }
}
//继承
//小结，当子类继承父类，就自动拥有了父类的功能
//     如果子类需要扩展功能，可以通过实现接口的方式扩展
//实现接口是java对java的单继承机制的一种补充

//猴子想游泳和飞怎么办  用接口

//飞的接口
interface Fly {
    public void fly();
}

//游泳的接口
interface Fish {
    //类要去实现的方法
    void swimming();
}

//子类猴子如何有游泳的能力              //让猴子实现游泳
class LittleMonkey extends Monkey implements Fish, Fly {
    public LittleMonkey(String name) {
        super(name);
    }

    @Override
    public void swimming() {
        //避免在父类或者抽象类去定义一个无关的方法，用接口实现实在是妙
        System.out.println(getName() + "学会游泳了");
    }

    @Override
    public void fly() {
        System.out.println(getName() + "学会飞了");
    }
}

//猴子父类
class Monkey {
    private String name;

    public void climbbing() {
        System.out.println("猴子会爬树...");
    }

    public String getName() {
        return name;
    }

    public Monkey(String name) {
        this.name = name;
    }
}
