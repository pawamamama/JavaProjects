package com.pawamamama.htreaduse;

/**
 * Class: ThreadMethod02
 *
 * <pre>
 *     Java线程常用方法第二组：
 *
 *     1. join()
 *        - 线程插队方法
 *        - 调用join的线程会等待目标线程执行结束后，当前线程继续执行
 *
 *     2. yield()
 *        - 线程礼让方法
 *        - 提示线程调度器当前线程可以让出CPU资源
 *        - 是否成功由JVM线程调度决定
 *
 *     本案例：
 *     创建一个子线程A，与main线程同时执行。
 *     通过join()和yield()观察线程之间的执行关系。
 *
 * </pre>
 *
 * @author pawamamama
 * @date 2026/7/9
 */
@SuppressWarnings({"all"})
public class ThreadMethod02 {
    public static void main(String[] args) throws InterruptedException {
        a a = new a();
        a.start();
        int count = 0;
        while (true) {
            System.out.println("hi = " + ++count);
            Thread.sleep(1000);
            if (count == 5) {
                System.out.println("开始线程插队");
                //a.join();//线程插队
                a.yield();//线程礼让，不一定成功，在资源紧张时候才能成功,底层去判断
                System.out.println("线程插队结束");
            }
            if (count == 20) {
                break;
            }
        }
    }

}

class a extends Thread {
    public void run() {
        int count = 0;
        while (true) {
            System.out.println("hello  = " + ++count);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            if (count == 20) {
                break;
            }
        }
    }
}