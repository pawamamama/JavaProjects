package com.homework;

public class homework01 {
    static void main() {
        Person[] p = new Person[6];

        p[0] = new Person("Alice", 25, "Teacher");
        p[1] = new Person("Bob", 30, "Engineer");
        p[2] = new Person("Charlie", 22, "Student");
        p[3] = new Person("David", 28, "Designer");
        p[4] = new Person("Eve", 35, "Doctor");
        p[5] = new Person("Frank", 27, "Chef");

        Person person = new Person();
        person.bubbleAge(p);
        person.print(p);


    }
}

class Person {
    private String name, job;
    private int age;

    public Person() {
    }

    public Person(String name, int age, String job) {
        this.name = name;
        this.job = job;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", job='" + job + '\'' +
                ", age=" + age +
                '}';
    }

    public void print(Person[] p) {
        for (int i = 0; i < p.length ; i++) {
            System.out.println(p[i].toString());
        }
    }


    public void bubbleAge(Person[] p) {
        Person tmp;//存放对象引用
        for (int i = 0; i < p.length - 1; i++) {
            for (int j = 0; j < p.length - 1 - i; j++) {
                if (p[j].age > p[j + 1].age) {
                    tmp = p[j];
                    p[j] = p[j + 1];
                   p[j+1] =tmp;
                }
            }
        }
    }
}

