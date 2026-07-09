package com.pawamamama.htreaduse.exercise_;

/**
 * Class: ThreadMethod_Exercise01
 *
 * <pre>
 * </pre>
 *
 * @author pawamamama
 * @date 2026/7/9
 */
@SuppressWarnings({"all"})
public class ThreadMethod_Exercise01 {
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new Hello());
        for (int i = 1; i <=10 ; i++) {
            System.out.println("hi" + i);
            Thread.sleep(1000);
            if (i == 5) {
                thread.start();
                thread.join();
            if (i == 10) {
                break;
            }

        }
        }
    }
}

class Hello implements Runnable {
    public void run() {
        boolean loop = true;
        int count = 0;
        while (loop) {
            System.out.println("Hello = " + ++count);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (count == 10) {
                loop = false;
            }
        }
        System.out.println("子线程结束");
    }

}
