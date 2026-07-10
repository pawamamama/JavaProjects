package com.pawamamama.homework_;

import com.sun.org.apache.bcel.internal.generic.ANEWARRAY;

import java.util.Scanner;

/**
 * Class: HomeWork01 一个线程控制另一个线程退出
 *
 * <pre>
 * </pre>
 *
 * @author pawamamama
 * @date 2026/7/10
 */
@SuppressWarnings({"all"})
public class HomeWork01 {
    public static void main(String[] args) {
        A a = new A();
        a.start();
        new B(a).start();
    }

}

class A extends Thread {
   private boolean loop = true;

    public void run() {
        while (loop) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            double num = Math.random();
            int i = (int) (num *100 +1);
            System.out.println(i);
        }
    }

    public void setLoop(boolean loop) {
        this.loop = loop;
    }
}

class B extends Thread {
    private A a = null;
    Scanner scanner = new Scanner(System.in);

    public B(A a) {
        this.a = a;
    }

    public void run() {
        //接口到用户的输入
        char key = scanner.next().toUpperCase().charAt(0);
        if ( key == 'Q') {
           a.setLoop(false);
        }
    }
}