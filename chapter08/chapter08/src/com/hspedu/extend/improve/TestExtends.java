package com.hspedu.extend.improve;
//提高复用性
//提高代码的扩展性和维护性
public class TestExtends {
    static void main(String[] args) {
        Pupil pupil = new Pupil();
        pupil.name = "wangwexin";
        pupil.age = 18;
        pupil.test();
        pupil.setScore(0);
        System.out.println("================================");
        Graduate graduate = new Graduate();
        graduate.name = "zhangsan";
        graduate.age = 22;
        graduate.test();
        graduate.setScore(90);

    }
}
