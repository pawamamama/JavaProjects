package com.homework;

public class homework04 {
    static void main() {
        Monster monster = new Monster("www", 19, "超级经理", 1000.2, 1.2, 10000);
        System.out.println(monster.Salary());
        monster.printSalary();

    }
}

class Emp {
    private String name;
    private int age;
    private String Post;
    private double daySalary;
    private double grade;

    public Emp(String name, int age, String post, double daySalary, double grade) {
        this.name = name;
        this.age = age;
        Post = post;
        this.daySalary = daySalary;
        this.grade = grade;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPost() {
        return Post;
    }

    public void setPost(String post) {
        Post = post;
    }


    public double getDaySalary() {
        return daySalary;
    }

    public void setDaySalary(double daySalary) {
        this.daySalary = daySalary;
    }

    public double getGrade() {
        return grade;
    }

    public void setGrade(double grade) {
        this.grade = grade;
    }

    public double Salary() {
        return daySalary * 30 * grade;
    }

    public void printSalary() {
        System.out.println("基础工资是" + this.Salary());
    }
}

class OrdEmp extends Emp {
    public OrdEmp(String name, int age, String post, double daySalary, double grade) {
        super(name, age, post, daySalary, grade);
    }

    @Override
    public double Salary() {
        return 1000 + super.Salary();
    }

    @Override
    public void printSalary() {
        System.out.println("职称" + getPost() + " 名字" + getName() + " 工资" + this.Salary());
    }

}

class Monster extends Emp {
    double bonus;

    public Monster(String name, int age, String post, double daySalary, double grade, double bonus) {
        super(name, age, post, daySalary, grade);
        this.bonus = bonus;
    }

    @Override
    public double Salary() {
        return bonus + super.Salary();
    }

    @Override
    public void printSalary() {
        System.out.println("职称" + getPost() + " 名字" + getName() + " 工资" + this.Salary());
    }
}
