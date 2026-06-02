package com.homework;

public class homework13 {
    public static void main() {
        Person01[] p = new Person01[4];
        p[0] = new Student("王微信wwwww", 'm', 12, "01110000");
        p[1] = new Student("刘轩宇", '女', 28, "0151000000");
        p[2] = new Teacher01("韩顺平", '男', 40, 20);
        p[3] = new Teacher01("C语言", '女', 24, 4);
        homework13 hw = new homework13();
        hw.bubbleAge(p);
        hw.printPerson01(p);
    }

    public void bubbleAge(Person01[] p) {
        Person01 tmp;//存放对象引用
        for (int i = 0; i < p.length - 1; i++) {
            for (int j = 0; j < p.length - 1 - i; j++) {
                if (p[j].getAge() > p[j + 1].getAge()) {
                    tmp = p[j];
                    p[j] = p[j + 1];
                    p[j + 1] = tmp;
                }
            }
        }
    }

    public void printPerson01(Person01[] p) {
        for (int i = 0; i < p.length; i++) {
            p[i].use2(p[i]);
            System.out.println("------------------------");
        }
    }
}

class Person01 {
    private String name;
    private char sex;
    private int age;

    public Person01(String name, char sex, int age) {
        setName(name);
        setSex(sex);
        setAge(age);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        int arr = name.length();
        if (arr >= 2 && arr <= 5) {
            this.name = name;
        } else {
            System.out.println("名字长度应该在二到五之间，已初始化为无名氏");
            this.name = "无名氏";
        }

    }

    public char getSex() {
        return sex;
    }

    public void setSex(char sex) {
        if (sex == '男' || sex == '女') {
            this.sex = sex;
        } else {
            System.out.println("性别只能是男或者女，初始化为无");
            this.sex = '无';
        }

    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if (age >= 18 && age <= 120) {
            this.age = age;
        } else {
            System.out.println("年龄必须在18~120岁之间，初始化为18");
            this.age = 18;
        }
    }

    public String play() {
        return name;
    }

    //向下转型调用特殊的方法
    public void use(Person01 person01) {
        if (person01 instanceof Student) {
            System.out.println(((Student) person01).Study());
        } else if (person01 instanceof Teacher01) {
            System.out.println(((Teacher01) person01).teach());
        }
    }

    //toString 方法
    @Override//父类打印基础信息
    public String toString() {
        return "姓名：" + name + "\n年龄：" + age + "\n性别：" + sex;
    }

    //扩展 use 2 用于打印
    public void use2(Person01 person01) {
        System.out.println(person01.toString());
    }

}

class Student extends Person01 {
    private String stu_id;

    public Student(String name, char sex, int age, String stu_id) {
        super(name, sex, age);
        setStu_id(stu_id);
    }

    public String getStu_id() {
        return stu_id;
    }

    public void setStu_id(String stu_id) {
        char verify = '0';
        char c0 = stu_id.charAt(0);
        char c4 = stu_id.charAt(4);
        int arr = stu_id.length();
        if (stu_id != null && arr == 10 && c0 == verify && c4 == verify) {
            this.stu_id = stu_id;
        } else {
            System.out.println("学生"+getName()+"第一位和第五位必须是 0  长度必须是10 给默认值0000000000");
            this.stu_id = "0000000000";
        }
    }

    //学习方法
    public String Study() {
        return "我承诺我会好好学习";
    }

    //play 重写
    @Override
    public String play() {
        return super.play() + "爱玩足球";
    }

    //toString 重写
    @Override
    public String toString() {
        return "学生的信息：\n" + super.toString()+"\n学号" +stu_id + "\n" + Study() + "\n" + play();
    }
}

class Teacher01 extends Person01 {
    private int workAge;

    public Teacher01(String name, char sex, int age, int workAge) {
        super(name, sex, age);
        setWorkAge(workAge);
    }

    public int getWorkAge() {
        return workAge;
    }

    public void setWorkAge(int workAge) {
        int maxWork = getAge() - 18;
        if (workAge < 0) {
            System.out.println("工作年龄不能为负数！");
        } else if (workAge <= maxWork) {
            this.workAge = workAge; // 合法
        } else {
            System.out.println("工作年龄不能超过" + maxWork + "年！");
            this.workAge = 0;
        }
    }

    //教学方法
    public String teach() {
        return "我承诺我会好好教书";
    }

    @Override
    public String play() {
        return super.play() + "爱玩象棋";
    }

    //toString 重写
    @Override
    public String toString() {
        return "老师的信息：\n" + super.toString() + "\n" + teach() + "\n" + play();
    }

}

/*
* 14
* 我是A
* hahah我是b类有参
* 我是c有参
* 我是c无参*/
