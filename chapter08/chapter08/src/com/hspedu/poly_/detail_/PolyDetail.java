package com.hspedu.poly_.detail_;

import com.hspedu.Super_.A;

public class PolyDetail {
    static void main() {
        //向上转型: 父类的引用指向了子类对象
        Animal animal = new Cat();
        // 可以调用父类的所有成员（需要遵守访问权限） 但是不能调用子类的特有方法
        //因为编译时是看左边他是父类怎么可能去调用子类的猫抓老鼠方法
        //最终的运行效果看子类的具体实现 （方法重写）
        //
        //如果你调用的方法在子类中被 重写（Override）了，运行时会执行 子类的版本。
        //但是 子类特有的方法（父类里没有定义的方法）是调用不了的，编译器会报错。
        animal.eat();//发生方法重写。。运行时从运行类型去找java只关心对象是谁我就找谁结果发生方法重写
        animal.run();//在Cat里找run找不到去父类找
        animal.show();
        animal.sleep();
        //希望调用Cat的抓老鼠
        //向下转型
        //要求父类的引用他原先就是猫对象 ，因为创建父类对象不会创建子类对象里的属性，本质就不是猫你怎么用猫啊
        Cat cat  = (Cat)animal;//其实就是换了个类型引用，让编译器用猫猫名字的引用找到猫猫的子类方法
        cat.catchMouse();
        animal.eat();//animal 其实还是指向Cat对象

    }
}
