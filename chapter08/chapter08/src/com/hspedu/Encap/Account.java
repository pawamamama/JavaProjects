package com.hspedu.Encap;

public class Account {
    //为了封装将三个属性设置为private私有
    private String name = "";
    private Double balance;
    private String passWord;

    public Account() {
    }

    public Account(String name, Double balance, String passWord) {
        setName(name);
        setBalance(balance);
        setPassWord(passWord);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        int len = name.length();
        if (len >= 2 && len <= 4) {
            this.name = name;
        } else {
            this.name = "无名";
            System.out.println("名字必须在2到4个字符之间给默认值 无名 ");
        }

    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        if (balance > 20) {
            this.balance = balance;
        } else {
            System.out.println("余额必须大于二十，默认为零 ");

        }
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        if (passWord.length() == 6) {
            this.passWord = passWord;
        } else {
            System.out.println("密码 设置错误默认为 123456");
            this.passWord = "123456";
        }

    }
    //写一个方法返回属性信息 写一个方法返回属性信息
    public String info() {
        return "账户信息信息为 name = " + name + " balance = " + balance + " passWord = " + passWord;
    }
}

