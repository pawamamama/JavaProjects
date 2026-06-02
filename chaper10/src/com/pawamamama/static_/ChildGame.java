package com.pawamamama.static_;

public class ChildGame {
    static void main(String[] args) {
        Child child = new Child("白骨精");
        child.count++;
        Child child1 = new Child("狐狸精");
        child1.count++;
        Child child2 = new Child("老鼠精");
        child2.count++;
        //类变量可以直接通过类名来访问
        System.out.println(Child.count + "子供加入了游戏");
        //是类变量 引用使用
        System.out.println(child.count);
        System.out.println(child1.count);
        System.out.println(child2.count);
    }

}

class Child {
    //定义一下count ，是一个类变量（静态变量） static
    //该变量最大的特点就是会被Child 类所以的对象实例共享
    //类变量在类加载的时候就生成了
    public static int count = 0;
    private String name;

    public Child(String name) {
        this.name = name;
    }

    public void join() {
        System.out.println(name + "加入了游戏");
    }
}