 // 主类（程序入口）
public class this01{

    public static void main(String[] args) {

        // 创建对象
        Dog dog1 = new Dog("旺财", 3);
        System.out.println("dog1的hashCode值" + dog1.hashCode());
        // 调用方法
        dog1.info();
    }
}

public class Dog {

    // 属性
    String name;
    int age;

    // 构造器
    public Dog(String name, int age) {
        //如果我们的构造器的形参能够直接写成属性名就更好了
        //但是出现了一个问题根据变量的作用域原则 
        //构造器的name 和age 就是局部变量了而不是属性了
        //name = name;自己给自己赋值了 编译器无法判断这里到底是给谁赋值只能就近原则了 
        //age = age;
        //this.name相当于我的名字,this指向对象自己 dog1 this 的hashCode 一样
        // this.name 表示当前对象的属性
        // name 是构造器的形参
        // 用 this 区分“成员变量”和“局部变量”
        //简单地说 哪个对象调用this就代表哪个对象 
        this.name = name;
        this.age = age;
        System.out.println("this.hashCode值" + this.hashCode());
        System.out.println("this.name.hashCode值" + this.name.hashCode());
    }

    // 输出信息的方法（无返回值）
    public void info() {
        System.out.println("名字: " + name + ", 年龄: " + age);
    }
}