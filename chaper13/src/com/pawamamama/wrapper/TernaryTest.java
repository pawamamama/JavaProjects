package com.pawamamama.wrapper;

/**
*@author pawamamama
*/public class TernaryTest {
    public static void main(String[] args) {
        boolean flag = true;

        // =========================
        // 1. 三元运算符
        // =========================
        Object obj1 = flag
                ? Integer.valueOf(100)
                : Double.valueOf(200.5);

        System.out.println("三元运算符结果:");
        System.out.println("值 = " + obj1);
        System.out.println("类型 = " + obj1.getClass().getSimpleName());

        System.out.println("--------------------");

        // =========================
        // 2. if-else独立赋值
        // =========================
        Object obj2;

        if (flag) {
            obj2 = Integer.valueOf(100);
        } else {
            obj2 = Double.valueOf(200.5);
        }

        System.out.println("if-else结果:");
        System.out.println("值 = " + obj2);
        System.out.println("类型 = " + obj2.getClass().getSimpleName());
    }
    }

