package com.pawamamama.chapter10Homerork;

/**
 * @author pawamamama
 */
public class HomeWork02 {
    static void main(String[] args) {
        Frock shirt = new Frock("shirt");
        Frock niceSuit = new Frock("nice suit");
        System.out.println(shirt);
        System.out.println(niceSuit);
    }
}

class Frock {
    //唯一序列
    private static int currentNum = 100000;
    private String name;
    //对象序列数字
    private int serialNum = 0;
    public Frock(String name) {
        this.name = name;
        serialNum = getNextNum();
    }
    private static int getNextNum() {
        return currentNum += 100;
    }

    @Override
    public String toString() {
        return name + "序列号" + serialNum;
    }
}