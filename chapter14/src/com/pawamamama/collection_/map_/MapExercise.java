package com.pawamamama.collection_.map_;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * Class: MapExercise
 *
 * <pre>
 * </pre>
 *
 * @author pawamamama
 * @date 2026/6/25
 */
@SuppressWarnings({"all"})
public class MapExercise {
    public static void main(String[] args) {
        HashMap hashMap = new HashMap();
        hashMap.put("1", new Employee("1", "wang1", 12000));
        hashMap.put("2", new Employee("2", "wang2", 18000));
        hashMap.put("3", new Employee("3", "wang3", 25000));
        hashMap.put("4", new Employee("4", "wang4", 9000));
        hashMap.put("5", new Employee("5", "wang5", 30000));
        hashMap.put("6", new Employee("6", "wang6", 15000));
        hashMap.put("7", new Employee("7", "wang7", 22000));
        hashMap.put("8", new Employee("8", "wang8", 5000));
        hashMap.put("9", new Employee("9", "wang9", 27500));
        hashMap.put("10", new Employee("10", "wang10", 20000));
        //1.增强for 用 keySet 获取
        Set set = hashMap.keySet();
        System.out.println("工资大于18000的有");
        for (Object o : set ) {//取出key key此时是String
            Employee employee = (Employee)hashMap.get(o);//转型
            if (employee.getSalary() > 18000) {//获取工资
                System.out.println(employee.toString());
            }

        }
        //2.获取迭代器 set 已经是 keySet了
        System.out.println("2.工资大于18000的有");
        Iterator iterator = set.iterator();
        while (iterator.hasNext()) {
            Object o = iterator.next();
            Employee employee = (Employee)hashMap.get(o);
            if (employee.getSalary() > 18000) {
                System.out.println(employee.toString());
            }
        }
        //3.用EntrySet
        System.out.println("3.用EntrySet");
        Set set1 = hashMap.entrySet();
        for (Object o : set1) {
            //向下转型
            Map.Entry entry = (Map.Entry)o;
            Employee employee = (Employee)entry.getValue();
            if (employee.getSalary() > 18000) {
                System.out.println(employee.toString());
            }
        }



    }
}
class Employee {
    private String id;
    private String name;
    private double salary;
    public Employee(String id, String name, double salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    public double getSalary() {
        return salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", salary=" + salary +
                '}';
    }
}