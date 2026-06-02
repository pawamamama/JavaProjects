package com.hspedu.override_;

public class OverrideExercise {
    static void main(String[] args) {
        Person 刘轩宇 = new Person("刘轩宇", 18);
        Student 王维鑫 = new Student("王维鑫", 18, 114514, 1000.4);
        System.out.println(刘轩宇.say());
        System.out.println(王维鑫.say());

    }
}

class Person {
    private int age;
    private String name;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String say() {
        return "你好我叫" + name + "我现在已经" + age + "岁了";
    }
}

class Student extends Person {
    private int id;
    private Double score;

    public Student(String name, int age, int id, Double score) {
        super(name, age);
        this.id = id;
        this.score = score;
    }


    public String say() {
        return super.say() + "我的id是" + id + "成绩是" + score;
    }
}