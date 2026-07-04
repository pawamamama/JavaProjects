package com.pawamamama.generic;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
/**
 * Class: EmployeeSortExercise
 *
 * <pre>
 * 本练习用于演示 Java 集合排序（ArrayList + Comparator）以及多条件比较规则设计。
 *
 * 功能目标：
 * 1. 创建 Employee 类对象（包含 name、sal、birthday 三个属性）
 * 2. 使用 ArrayList 存储多个 Employee 对象（允许重复数据）
 * 3. 通过 Comparator 实现自定义排序规则
 *
 * 排序规则（核心逻辑）：
 * 1. 首先按照员工姓名（name）进行字典序排序（String.compareTo）
 *    - 如果姓名不同，直接返回 name 的比较结果
 * 2. 如果姓名相同，则按照生日（birthday）进行排序
 *    - birthday 使用 MyDate 类的 compareTo 方法进行比较
 *
 * 注意事项：
 * 1. Comparator 中不建议强制类型检查（instanceof），因为泛型已限定类型
 * 2. compare 方法返回值规则：
 *    - < 0：o1 排在前
 *    - = 0：认为两个对象排序等价
 *    - > 0：o1 排在后
 * 3. MyDate 必须实现 Comparable 接口，否则 birthday.compareTo 会报错
 *
 * 典型应用场景：
 * - 员工管理系统排序
 * - 多条件排序（姓名 -> 日期 -> 工资）
 * - 集合排序规则设计练习
 *
 * 扩展练习建议：
 * - 添加 salary 作为第三排序条件
 * - 使用 Lambda 表达式替代匿名内部类
 * - 尝试 TreeSet 去重 + 排序
 *
 * </pre>
 *
 * @author
 * @date 2026/7/4
 */
@SuppressWarnings({"all"})
public class GenericExercise02 {
    public static void main(String[] args) {
        List<Employee> employees = new ArrayList<>();

        employees.add(new Employee("张三", 12000, new MyDate(2000, 5, 10)));
        employees.add(new Employee("李四", 15000, new MyDate(1998, 8, 20)));
        employees.add(new Employee("王五", 18000, new MyDate(1995, 12, 1)));

        employees.add(new Employee("赵六", 9000, new MyDate(2001, 1, 1)));
        employees.add(new Employee("孙七", 20000, new MyDate(1990, 3, 15)));

        employees.add(new Employee("张三", 12000, new MyDate(2000, 5, 10))); // 重复
        employees.add(new Employee("王五", 18000, new MyDate(1995, 12, 1))); // 重复
        System.out.println("未排序");
        System.out.println(employees);
        //7.排序
        employees.sort(new Comparator<Employee>() {
            @Override
            public int compare(Employee o1, Employee o2) {
                //1.检查参数
                if (!(o1 instanceof Employee && o2 instanceof Employee)) {
                    System.out.println("类型不正确");
                    return 0;
                }
                //先比较名字,这里返回一个值表示，为零表明名字一样
                int name = o1.getName().compareTo(o2.getName());
                if (name != 0) {
                    return name;//返回的数值直接可以用
                }
                //这里直接使用Date实现的compareTo接口,方便使用
                return  o1.getBirthday().compareTo(o2.getBirthday());
            }
        });


        System.out.println("排序后");
        System.out.println(employees);
    }

}

@SuppressWarnings({"all"})
class Employee {

    private String name;
    private double sal;
    private MyDate birthday;

    public Employee(String name, double sal, MyDate birthday) {
        this.name = name;
        this.sal = sal;
        this.birthday = birthday;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSal() {
        return sal;
    }

    public void setSal(double sal) {
        this.sal = sal;
    }

    public MyDate getBirthday() {
        return birthday;
    }

    public void setBirthday(MyDate birthday) {
        this.birthday = birthday;
    }

    @Override
    public String toString() {
        return String.format(
                "Employee{name='%s', sal=%.2f, birthday=%s}",
                name,
                sal,
                birthday
        );
    }
}

@SuppressWarnings({"all"})
class MyDate implements Comparable<MyDate> {

    private int year;
    private int month;
    private int day;

    public MyDate(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    @Override
    public String toString() {
        return year + "-" + month + "-" + day;
    }

    @Override
    public int compareTo(MyDate o) {//把比较任务放在 compareTo 实现自己的接口来去比较日期
        //1.先对比year
        int yearMinus = year - o.getYear();
        if (year != 0) {
            return year;
        }
        int monthMinus = month - o.getMonth();
        if (monthMinus != 0) {
            return monthMinus;
        }
        return day - o.getDay();
    }
}