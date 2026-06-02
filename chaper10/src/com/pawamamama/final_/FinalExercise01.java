package com.pawamamama.final_;

public class FinalExercise01 {
    static void main(String[] args) {
        Circle circle = new Circle(3.14);
        double area = circle.Area(20);
        System.out.println("Area of Circle is: " + area);
    }
}
class Circle {
    //直接初始化
    public final double PI = 3.14;
    //构造器
    public final double PI2;
    public Circle(double PI2) {
        this.PI2 = PI2;
    }
    //代码块
    public final double PI3;
    {
        PI3 = 3.14;
    }


    public double Area(double radius) {
        return PI * radius * radius;
    }
}
