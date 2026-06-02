package com.pawamamama.chapter10Homerork;


/**
 * @author pawamamama
 * 这个作业教会了我使用接口来进行多态
 * 并且在多种情况下使用不同的工具进行目的还具有扩展性
 */
public class HomeWork06 {
    static void main() {
      /*  Person tangseng = new Person("唐僧",Transportation.getBoat());
        tangseng.go();*/
        Person tangseng = new Person("唐僧");
        tangseng.common();
        tangseng.passRiver();
        tangseng.common();
        tangseng.passRiver();
        tangseng.passRiver();
        tangseng.passRiver();
        tangseng.huoyanshan();
        tangseng.common();
        tangseng.huoyanshan();
        tangseng.huoyanshan();
    }
}

interface Vehicles {
    void work()
            ;
}

class Horse implements Vehicles {
    @Override
    public void work() {
        System.out.println("一般情况下骑白龙马");
    }
}

class Boat implements Vehicles {
    @Override
    public void work() {
        System.out.println("特殊情况下坐船船");
    }
}
class Bajiaoshan implements Vehicles {
    @Override
    public void work() {
        System.out.println("过火焰山用芭蕉扇");
    }
}

//交通工厂
class Transportation {
    //白龙马唯一 芭蕉扇唯一 船不唯一
    private final static Bajiaoshan bajiaoshan = new Bajiaoshan();
    private final static Horse horse;
    static {
        horse = new Horse();
    }

    private Transportation() {
    }

public static Bajiaoshan getBajiaoshan() {
        return bajiaoshan;
}
    public static Horse getHorse() {
        return horse;
    }
    public   static Boat getBoat() {
        return new Boat();
    }
}

class Person {
    private String name;
    Vehicles vehicles;//车辆接口

    public Person(String name) {
        this.name = name;
    }
    public Person(String name, Vehicles vehicles    /*String Vehicles*/) {
        this.name = name;
        //this.Vehicles = Vehicles;
        this.vehicles = vehicles;//此时这个对象的运行对象就是实现车辆接口的类
    }
    public void go () {
        System.out.print(name);
        vehicles.work();
    }
    //动态获取
    public void passRiver() {
        //是白龙马或者空就创建一条船
        if (!(vehicles instanceof Boat )) {
            vehicles = Transportation.getBoat();
        }
        vehicles.work();
    }
    //师傅获取马
    public void common() {
        //两个意思
        //vehicles 是null 返回假 但是有取反为真就去获取马
        //vehicles 是 马就为真 但是有取反 变假就不获取
        //vehicles 是 船就为假 但是有取反 为真就获取马
        if ( !( vehicles instanceof Horse ) ) {
            vehicles = Transportation.getHorse();
        }
        vehicles.work();
    }
    //过火焰山
    public void huoyanshan() {
        if ( !( vehicles instanceof Bajiaoshan) ) {
            vehicles = Transportation.getBajiaoshan();
        }
        vehicles.work();
    }

    /*public void  go() {
        if (Vehicles.equals("Horse")) {
            Horse horse = Transportation.getHorse();
            System.out.print(name +"坐");
            horse.work();
        }  else if (Vehicles.equals("Boat")) {
            Boat boat = Transportation.getBoat();
            System.out.print(name +"坐");
            boat.work();
        }else {
            System.out.println("错误");
        }*/
   // }
}