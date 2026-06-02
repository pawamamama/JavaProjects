package com.hspedu.object_;

public class EqualsExercise {
    static void main() {
        Person person1 = new Person("wangweixin", 18, '男');
        Person person11 = new Person("wangweixin", 18, '男');
        Person person2 = new Person("刘达", 17, '男');
        Person person3 = person1;
        //不同对象相同属性
        System.out.println(person1.equals(person11));
        //相同对象不同引用
        System.out.println(person1.equals(person3));
        //不同对象不同属性
        System.out.println(person1.equals(person2));
    }
}

class Person {
    private String name;
    private int age;
    private char gender;

    //构造器
    public Person(String name, int age, char gender) {
        this.name = name;
        this.age = age;
        this.gender = gender;
    }
    //get and set

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

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }


    @Override
    public boolean equals(Object anotherObject) {
        if (this == anotherObject) return true; // 同引用直接返回 true

        if (anotherObject instanceof Person) { // null 和类型检查合并
            Person personContrast = (Person) anotherObject;
            return this.age == personContrast.age //名字
                    && this.gender == personContrast.gender//年龄
                    && (this.name != null ? this.name.equals(personContrast.name)//不为空就直接和对比
                    : personContrast.name == null);//避免name null空指针异常 是null就让对比对象和null去对比
        }

        return false; // 不同类型或 null
    }
}
