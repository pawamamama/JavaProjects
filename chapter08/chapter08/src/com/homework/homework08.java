package com.homework;

public class homework08 {
    static void main() {
      /*  CheckingAccount checkingAccount = new CheckingAccount(1000);
        checkingAccount.deposit(1000);//2000-1 = 1999
        checkingAccount.withdraw(1000);//999-1 = 998
        System.out.println(checkingAccount.getBalance());//998
        */

        SavingsAccount savingsAccount = new SavingsAccount(1000);
        savingsAccount.deposit(100);
        savingsAccount.deposit(100);
        savingsAccount.deposit(100);
        savingsAccount.deposit(100);
        System.out.println(savingsAccount.getBalance());
        savingsAccount.earnMonthlyInterset();
        System.out.println(savingsAccount.getBalance());
        savingsAccount.deposit(100);
        savingsAccount.deposit(100);
        savingsAccount.deposit(100);
        System.out.println(savingsAccount.getBalance());
    }
}

class BankAccount {//银行账户
    private double balance; // 改成 double

    public BankAccount(double initialBalance) {
        this.balance = initialBalance;
    }

    public void deposit(double amount) {//存款
        balance += amount;
    }

    public void withdraw(double amount) {//取款
        balance -= amount;
    }

    //set 和 getBalance方法
    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}

class CheckingAccount extends BankAccount {
    public CheckingAccount(double initialBalance) {
        super(initialBalance);
    }//支票账户

    @Override
    public void deposit(double amount) {
        super.deposit(amount - 1);//收手续费
    }

    @Override
    public void withdraw(double amount) {
        super.withdraw(amount + 1);//收手续费
    }
}

class SavingsAccount extends BankAccount {
    private int count = 3;//次数
    private double rate = 0.01;//利率

    public SavingsAccount(double initialBalance) {
        super(initialBalance);
    }

    @Override
    public void deposit(double amount) {
        if (count > 0) {
            super.deposit(amount);
        } else {
            super.deposit(amount - 1);
        }
        count--;
    }

    @Override
    public void withdraw(double amount) {
        if (count > 0) {
            super.withdraw(amount);
        } else {
            super.deposit(amount - 1);
        }

        count--;

    }

    public void earnMonthlyInterset() {
        super.deposit(getBalance() * rate);//通过存款接口直接存取利息只能存钱比较好
        // setBalance(getBalance() * rate + getBalance());//会直接修改余额，完全自定义公式，但可能绕过父类逻辑，不太安全
        count = 3;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }


}