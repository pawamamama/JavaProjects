package com.pawamamama.single_;

/**
 * 单例设计模式
 * 懒汉式
 *
 *
 */
public class SingleTon02 {
    static void main(String[] args) {
        //调用静态成员 造成类加载但是对象没有创建
        System.out.println(Dog.n1);
        //此时才真正创建对象
        Dog dog = Dog.getInstance();
        System.out.println(dog);
        //再次调用 不会创建对象
        Dog dog2 = Dog.getInstance();
        System.out.println(dog == dog2);
    }

}

//希望在程序运行过程中 只能创建一个Dog对象
class Dog {
    public static int n1 = 100;
    private String name;

    //1.仍然将构造器私有化
    private Dog(String name) {
        this.name = name;
        System.out.println("构造器调用");
    }

    //2.创建一个静态属性Static属性对象
    private static Dog dog;

    //3.提供一个pubic的static的公共方法，可以返回一个Dog对象
    public static Dog getInstance() {

        //4.只有用户使用时getInstance时才返回Dog对象而且再次调用时还是原来对象
        // 保证只创建一个对象
        // 而且是懒汉式不用对象 对象就不创建
        if (dog == null) {
            dog = new Dog("大黄");
        }
        return dog;
    }

}


