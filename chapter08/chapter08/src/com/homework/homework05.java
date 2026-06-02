package com.homework;

public class homework05 {
    static void main() {
        Worker w = new Worker("小张", 5000, "工人");
        Teacher2 t = new Teacher2("李老师", 6000, "教师", 2000); // teachDay=2000
        Scientist s = new Scientist("王博士", 10000, "科学家", 50000); // yearBonus=50000

        // 输出验证
        w.printYearSalary(); // 工人年工资
        t.printYearSalary(); // 教师年工资
        s.printYearSalary(); // 科学家年工资
    }
}
class Emp2 {
    private String name;
    private double salary;
    private String job;

    public Emp2(String name, double salary, String job) {
        this.name = name;
        this.salary = salary;
        this.job = job;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }
    public double yearSalary() {
        return this.salary * 12;//年工资
    }
    public void printYearSalary() {
        System.out.println("职业 " + getJob() +" 名字"+ getName() + " 月薪" + yearSalary());
    }

}
class Worker extends Emp2{
    public Worker(String name, double salary, String job) {
        super(name, salary, job);
    }
}
class Teacher2 extends Emp2 {
    private double teachDay ;

    public Teacher2(String name, double salary, String job, double teachDay) {
        super(name, salary, job);
        this.teachDay = teachDay;
    }
    @Override
    public  double yearSalary() {
        return super.yearSalary() + teachDay * 365;
    }


}
class Scientist extends Emp2 {
    private double yearBonus;

    public Scientist(String name, double salary, String job, double yearBonus) {
        super(name, salary, job);
        this.yearBonus = yearBonus;
    }

    @Override
    public  double yearSalary() {
        return super.yearSalary() + yearBonus;
    }


} 