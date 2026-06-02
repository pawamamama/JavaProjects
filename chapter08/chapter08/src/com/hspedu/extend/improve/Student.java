package com.hspedu.extend.improve;
//父类学生 ，是Pupil 和 Graduate 的父类
public class Student {
    public String name;
    public int age;
    private double score;
   /* //构造器
    public Student(String name, int age, double score) {
        this.name = name;
        this.age = age;
        this.score = score;
    }*/

    //设置成绩
    public void setScore(double score) {
        this.score = score;
    }
    public void showInfo() {
        System.out.println("学生名" + name + "年龄" + age +" 成绩" + score);
    }
}
