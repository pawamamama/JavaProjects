package com.hspedu.poly_.polyparameter_;

public class PloyParameter {
    static void main(String[] args) {
        Normal jack = new Normal("jack", 2000.2);
        Manager tom = new Manager("tom", 5000.4, 200.6);
        PloyParameter p = new PloyParameter();
        p.showEmpAnnual(jack);
        p.test(jack);
        p.showEmpAnnual(tom);
        p.test(tom);


    }
    public void showEmpAnnual(Employee employee) {
        System.out.println(employee.getAnnual());
    }
    public void test(Employee employee) {
        if (employee instanceof Normal) {
            ((Normal) employee).work();
        } else if (employee instanceof Manager) {
            ((Manager)employee).manage();

        } else {
            System.out.println("对象有误");
        }
    }
}
