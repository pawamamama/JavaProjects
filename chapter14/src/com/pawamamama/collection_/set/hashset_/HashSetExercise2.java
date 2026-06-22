package com.pawamamama.collection_.set.hashset_;
import java.util.HashSet;
import java.util.Objects;

/**
 * HashSet 练习
 *
 * <pre>
 * 自定义 Employee01 和 MyDate 类，
 * 重写 equals() 和 hashCode()，
 * 使 HashSet 能够根据指定属性完成去重。
 *
 * 去重规则：
 * 姓名(name)和生日(birthday)相同，
 * 则认为是同一员工。
 * </pre>
 *
 * @author pawamamama
 * @date 2026/6/22
 */
public class HashSetExercise2 {

    public static void main(String[] args) {

        HashSet<Employee01> set = new HashSet<>();

        set.add(new Employee01("Tom", 5000, 2000, 5, 20));
        set.add(new Employee01("Tom", 8000, 2000, 5, 20));
        set.add(new Employee01("Jack", 6000, 2000, 5, 20));
        set.add(new Employee01("Tom", 9000, 2001, 5, 20));

        System.out.println("HashSet 元素个数：" + set.size());

        for (Employee01 employee : set) {
            System.out.println(employee);
        }
    }
}
/**
 * 员工类
 *
 * <pre>
 * 保存员工姓名、工资和生日信息。
 *
 * 重写 equals() 和 hashCode()，
 * 判断两个员工是否相同时，
 * 只比较姓名(name)和生日(birthday)，
 * 工资(sal)不参与比较。
 * </pre>
 *
 * @author pawamamama
 * @date 2026/6/22
 */
class Employee01 {
    private String name;
    private double sal;
    private MyDate birthday;

    //员工信息
    public Employee01(String name, double sal, int year, int month, int day) {
        this.name = name;
        this.sal = sal;
        this.birthday = new MyDate(year, month, day);//日期类创建
    }

    //重写hash ,用 名字 + 生日日期为唯一 hash
    @Override
    public int hashCode() {
        //                       birthday这里自动.hashCode()
        return Objects.hash(name, birthday);
    }

    //重写equals 如果 名字和日期一样 则是同一对象
    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        // ① 如果传入对象为 null，肯定不相等
        if (o == null)
            return false;
        // ② 如果不是同一个类型，也不相等
        // 例如 Employee 和 Student，即使属性一样也不是同一种对象
        if (getClass() != o.getClass())
            return false;
        //向下转型
        Employee01 employee = (Employee01) o;
        return name.equals(employee.name) && birthday.equals(employee.birthday);
    }
}
/**
 * 日期类
 *
 * <pre>
 * 保存员工生日信息。
 *
 * 重写 equals() 和 hashCode()，
 * 根据年(year)、月(month)、日(day)
 * 判断两个日期是否相同。
 * </pre>
 *
 * @author pawamamama
 * @date 2026/6/22
 */

class MyDate {

    private int year;
    private int month;
    private int day;

    /**
     * 构造器
     * <p>
     * 限制条件：
     * 1. 年份：1~9999
     * 2. 月份：1~12
     * 3. 日期：1~31（这里只做基本限制，不区分大小月）
     */
    public MyDate(int year, int month, int day) {

        if (year < 1 || year > 9999) {
            throw new IllegalArgumentException("年份必须在 1~9999 之间");
        }

        if (month < 1 || month > 12) {
            throw new IllegalArgumentException("月份必须在 1~12 之间");
        }

        if (day < 1 || day > 31) {
            throw new IllegalArgumentException("日期必须在 1~31 之间");
        }

        this.year = year;
        this.month = month;
        this.day = day;
    }

    public int getYear() {
        return year;
    }

    public int getMonth() {
        return month;
    }

    public int getDay() {
        return day;
    }

    //计算hash 重写hash 如果默认不重写，是按照对象地址去来的，而这里是根据真正的日期数来的hash
    @Override
    public int hashCode() {
        return Objects.hash(year, month, day);
    }

    //euqals 重写 年月日一样则一样
    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        // ① 如果传入对象为 null，肯定不相等
        if (o == null)
            return false;
        // ② 如果不是同一个类型，也不相等
        // 例如 Employee 和 Student，即使属性一样也不是同一种对象
        if (getClass() != o.getClass())
            return false;
        MyDate date = (MyDate) o;
        return year == date.year && month == date.month && day == date.day;
    }
}

