package com.hspedu.poly_.polyparameter_;

public class Normal extends Employee{
    public Normal(String name, Double salary) {
        super(name, salary);
    }
    public void work() {
        System.out.println("普通员工  "+getName()+" is work");
    }
    @Override
    public Double getAnnual() {
        return super.getAnnual();
    }
}
