package com.pawamamama.homework_;

/**
 * Class: HomeWork02
 *
 * <pre>
 * </pre>
 *
 * @author pawamamama
 * @date 2026/7/10
 */
@SuppressWarnings({"all"})
public class HomeWork02 {
    public static void main(String[] args) {
        Account account = new Account();
        new Thread(account).start();
        new Thread(account).start();
    }
}

class Account implements Runnable {
    int salary = 10000;
    Object lock = new Object();
    @Override
    public void run() {
        money();
//        money_lock();
    }

    private synchronized void money() {
        while (true) {
            if (salary < 1000) {
                System.out.println("余额不足 线程 = " + Thread.currentThread().getName());
                break;
            } else {
                salary -=1000;
                System.out.println("线程 = " + Thread.currentThread().getName() + "取了1000"
                        + "剩余" + salary + "元");
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    private void money_lock() {
        synchronized (lock) {
            while (true) {
                if (salary < 1000) {
                    System.out.println("余额不足 线程 = " + Thread.currentThread().getName());
                    break;
                } else {
                    salary -= 1000;
                    System.out.println("线程 = " + Thread.currentThread().getName() + "取了1000"
                            + "剩余" + salary + "元");
                }
                }
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }

    }


}