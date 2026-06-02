package com.hspedu.poly_;

public class PolyArray {
    static void main() {
        //使用多态数组
        Person[] person = new Person[5];
        person[0] = new Person(18, "王维");
        person[1] = new Student(18, "李白", 1000.1);
        person[2] = new Student(17, "白居易", 999.1);
        person[3] = new Teacher(50, "老师", 999111.1);
        person[4] = new Teacher(50, "五条悟", 9999999111.1);
        for (int i = 0; i < person.length; i++) {
            //person[i]的编译类型是 person
            //运行时是 根据实际运行情况由jvm 来判断
            System.out.println(person[i].say());//动态绑定机制
            if (person[i] instanceof Student) {//判断 运行类型是不是学生
              /*  Student student = (Student) person[i];
                student.study();*/
                ((Student) person[i]).study();//向下转型

            } else if (person[i] instanceof Teacher) {
                ((Teacher) person[i]).teach();
            } else {
                System.out.println("类型有误");
            }

        }
    }
}

class Person {
    private String name;
    private int age;

    public Person(int age, String name) {
        this.age = age;
        this.name = name;
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

    public String say() {

        return " name = " + name + " age = " + age;
    }
}

class Student extends Person {
    private Double score;

    public Student(int age, String name, Double score) {
        super(age, name);
        this.score = score;
    }

    public Double getScore() {
        return score;
    }

    public void setScore(Double score) {
        this.score = score;
    }

    @Override
    public String say() {
        return "学生  " + super.say() + " score = " + score;
    }

    public void study() {
        System.out.println("学习");
    }
}

class Teacher extends Person {
    private Double salary;

    public Teacher(int age, String name, Double salary) {
        super(age, name);
        this.salary = salary;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    @Override
    public String say() {
        return "老师" + super.say() + " salary" + salary;
    }

    public void teach() {
        System.out.println("教书");
    }
}