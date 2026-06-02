package com.pawamamama.excption_.try_catch_;

/**
 * @author pawamamama
 * try-finally使用
 */
public class TryCatchDetail05 {
    public static void main(String[] args) {
        int n1;
        int n2;
        try {
            n1 = 10;
            n2 = 0;
            System.out.println(n1/n2);
        } finally {
            System.out.println("执行了finally");
        }
        System.out.println("程序继续运行");
    }
}
