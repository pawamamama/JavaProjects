package com.hspedu.object_;

public class ToString {
    static void main() {
        //Object 的 toString方法
        //（1）getClass().getName() 类的全类名(包名加类名)
        //（2） Integer.toHexString(hashCode()) 将对象的hashCode 值转成16进制的字符串
        /*public String toString() {
            return getClass().getName() + "@" + Integer.toHexString(hashCode());
        }*/
        Monster monster = new Monster("小妖怪", "巡山", 10000);
        System.out.println(monster.toString());
        C c = new C();
        System.out.println(c.toString());
        //当直接输出一个对象时toString方法会被默认的调用
        System.out.println(c);//等价c.toString()
    }
}
class Monster  {
    private String name;
    private String job;
    private double salary;

    public Monster() {
    }

    public Monster(String name, String job, double salary) {
        this.name = name;
        this.job = job;
        this.salary = salary;
    }
    //重写 toString 使用快捷键 alt + insert  -> toString


    @Override
    public String toString() {//重写后 ，一般是把对象的属性输出
        return "Monster{" +
                "name='" + name + '\'' +
                ", job='" + job + '\'' +
                ", salary=" + salary +
                '}';
    }
}
class C extends Monster {
    public C() {
    }

    public C(String name, String job, double salary) {
        super(name, job, salary);
    }
}