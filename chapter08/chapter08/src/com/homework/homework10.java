package com.homework;

public class homework10 {
    static void main(String[] args) {
        Doctor doctor1 = new Doctor("Alice", 30, "Surgeon", 'F', 15000.0);
        Doctor doctor2 = new Doctor("Bob", 40, "Pediatrician", 'M', 12000.0);

        // 测试 equals 方法
        Doctor doctor3 = new Doctor("Alice", 30, "Surgeon", 'F', 15000.0);
        System.out.println(doctor1.equals(doctor3)); // true
        System.out.println(doctor1.equals(doctor2)); // false
    }
}

class Doctor {
    private String name;
    private int age;
    private String job;
    private char gender;
    private double sal;

    public Doctor(String name, int age, String job, char gender, double sal) {
        this.name = name;
        this.age = age;
        this.job = job;
        this.gender = gender;
        this.sal = sal;
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

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    public double getSal() {
        return sal;
    }

    public void setSal(double sal) {
        this.sal = sal;
    }

    public boolean equals(Object object) {

        if (this == object) {//同一对象
            return true;
        }
        if (!(object instanceof Doctor)) {//是同类型或者子类
            return false;

        }
        Doctor dOaj = (Doctor) object;
        return name.equals(dOaj.name) && age == dOaj.age && job.equals(dOaj.job)
                && gender == dOaj.gender && sal == dOaj.sal;
    }
}


/*向上

11.
Person p = new Student();
向下

p.run(student run) .eat person eat
Student S = (Student)P;
s.study(ss) s.run(s run) s.eat(pe )
12.
==  比较运算符
==  基本数据类型 值对比
==  引用类型 还是值对比 对比的是对象引用（hashCode）可以用于对比对象是否是同一个对象
equals  基本数据类型不可用    由各自的数据类型类重写（基本数据类型不可用 必须是包装类和引用类型String Double才能用）
  object 是直接对比对象是否是同一个 this == obj
  String是对比 字符串的单个字符是否相同。。。
  子类往往需要重写方法 比较对象的属性是否相等

*
*
* */