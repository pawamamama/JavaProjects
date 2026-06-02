package com.pawamamama.static_;

public class StaticMethod {
    static void main() {
        //test
        Stu stu = new Stu("jack");
        Stu.payFee(1200);
        Stu stu2 = new Stu("make");
        //stu2.payFee();
        Stu.payFee(2200);
        //总学费
        Stu.showFee();
        //不希望创建实例，也可以调用某个方法（当作工具来使用）
        //这时，把方法做成静态方法时非常合适
        System.out.println("9开平方的结果是 = "+ Math.sqrt(9));
    }
}

class Stu {
    private String name;//属性
    //定义一个类变量累计学生的学费
    private static double fee = 0;

    public Stu(String name) {
        this.name = name;
    }

    public Stu(String name, double fee) {
        this.name = name;
        Stu.fee += fee;
    }

    //说明
    //1.当方法使用static 修饰后，该方法就是一个静态方法
    //2.静态方法就可以访问静态属性/变量
    public static void payFee(double fee) {
        Stu.fee += fee;
    }

    public static void showFee() {
        System.out.println("总学费有：" + Stu.fee);
    }
}