package com.homework;

public class HomeWork03 {
    static void main() {
        Teacher teacher1= new Professor("wangweixin",18,"教授",1.3,10101010110.00);
        teacher1.introduce();
    }
}
class Teacher {
    private String name,post;
    private int age;
    private Double salary;
    private double grade;

    public Teacher(String name,int age , String post,double grade, Double salary) {
        this.name = name;
        this.post = post;
        this.age = age;
        this.grade = grade;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post = post;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public void introduce() {
        System.out.println("name = " +name +"age:"
                +age + "post:" + post +
                "salary" +"grade" +
                grade +salary);
    }
}
class Professor extends Teacher {
    public Professor(String name,int age , String post,double grade, Double salary) {
        super(name, age, post,grade, salary);
    }
    @Override
    public void introduce() {
        System.out.println("教授的信息如下");
        super.introduce();
    }
}