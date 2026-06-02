package com.pawamamama.abstract_;

public class AbstractExercise01 {

    static void main(String[] args) {
        Employee p = new CommonEmployee01("王维新","121212",393939);
        p.work();
        p= new Manage("王维新","121212",393939,1200);
        p.work();
    }
}
//抽象人类
abstract class Employee{
    private String name;
    private String id;
    private double salary;

    public Employee(String name, String id, double salary) {
        this.name = name;
        this.id = id;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    //抽象工作方法
    abstract public void work();
}
class CommonEmployee01 extends Employee{
    public CommonEmployee01(String name, String id, double salary) {
        super(name, id, salary);
    }
    //
    @Override
    public void work() {
        System.out.println("普通员工 " + getName());
    }
}
class Manage extends Employee{
    private double bonus;
    public Manage(String name, String id, double salary, double bonus) {
        super(name, id, salary);
        this.bonus = bonus;
    }

    public double getBonus() {
        return bonus;
    }

    public void setBonus(double bonus) {
        this.bonus = bonus;
    }

    @Override
    public void work() {
        System.out.println("经理 " + getName());
    }
}