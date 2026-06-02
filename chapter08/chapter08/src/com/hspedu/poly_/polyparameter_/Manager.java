package com.hspedu.poly_.polyparameter_;

public class Manager extends Employee{
    private Double bonus ;

    public Manager(String name, Double salary, Double bonus) {
        super(name, salary);
        this.bonus = bonus;
    }

    public Double getBonus() {
        return bonus;
    }

    public void setBonus(Double bonus) {
        this.bonus = bonus;
    }
    public void manage() {
        System.out.println("经理  " + getName() + "is manage");
    }
    @Override
    public  Double getAnnual() {
        return super.getAnnual() + bonus;
    }
}
