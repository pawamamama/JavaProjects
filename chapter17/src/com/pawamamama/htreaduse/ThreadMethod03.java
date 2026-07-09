package com.pawamamama.htreaduse;

/**
 * Class: ThreadMethod03
 *
 * <pre>
 *     Java线程常用方法第三组：
 *
 *     守护线程（Daemon Thread）：
 *
 *     1. setDaemon(true)
 *        - 将线程设置为守护线程。
 *
 *     2. 守护线程特点：
 *        - 当所有用户线程（非守护线程）结束后，
 *          JVM会自动结束，不再等待守护线程执行。
 *
 *     3. 应用场景：
 *        - 后台服务线程
 *        - 垃圾回收线程
 *        - 日志监控线程等
 *
 *     本案例：
 *     创建一个守护线程不断输出 Hello World，
 *     当main线程结束后，守护线程会自动结束。
 *
 * </pre>
 *
 * @author pawamamama
 * @date 2026/7/9
 */
@SuppressWarnings({"all"})
public class ThreadMethod03 {
    public static void main(String[] args) throws InterruptedException {
        Daemon daemon = new Daemon();
        //希望主线程结束后子线程可以自动结束
        //只需要将子线程设置为守护线程
        daemon.setDaemon(true);
        daemon.start();
        for (int i = 1; i <=10 ; i++) {
            System.out.println ("hihi");
            Thread.sleep(1000);
        }
    }

}
class Daemon extends  Thread {
    @Override
    public void run() {
        for (;;) {//
            try {
                Thread.sleep(50);
            } catch (InterruptedException ie) {
                ie.printStackTrace();
            }
            System.out.println("Hello World");
        }
    }
}