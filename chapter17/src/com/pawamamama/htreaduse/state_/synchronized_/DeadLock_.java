package com.pawamamama.htreaduse.state_.synchronized_;

/**
 * Class: DeadLock
 *
 * <pre>
 * Java多线程死锁案例：
 *
 * 一、死锁概念：
 * 多个线程在执行过程中，因为互相持有对方需要的锁，
 * 导致所有线程都无法继续执行的状态。
 *
 * 二、死锁产生条件：
 * 1. 互斥条件：
 *    一个资源只能被一个线程占用。
 *
 * 2. 请求与保持条件：
 *    线程持有一个锁，同时等待获取其他锁。
 *
 * 3. 不可剥夺条件：
 *    线程已经获得的锁不能被强制释放。
 *
 * 4. 循环等待条件：
 *    存在线程之间相互等待锁资源。
 *
 * 三、本案例：
 * 线程A：
 *    获取o1锁 → 尝试获取o2锁
 *
 * 线程B：
 *    获取o2锁 → 尝试获取o1锁
 *
 * 当两个线程互相等待对方释放锁时，
 * 形成死锁。
 *
 * 四、解决方法：
 * 1. 保证线程获取锁的顺序一致。
 * 2. 减少锁的嵌套使用。
 * 3. 使用Lock时设置超时时间。
 * </pre>
 *
 * @author pawamamama
 * @date 2026/7/10
 */
@SuppressWarnings({"all"})
public class DeadLock_ {
    public static void main(String[] args) {
        DeadLockDemo a = new DeadLockDemo(true);
        a.setName("a线程");
        DeadLockDemo b = new DeadLockDemo(false);
        b.setName("b线程");
        a.start();
        b.start();
        //a线程拿到o1 锁但是拿不到o2
        //b线程拿到o2 锁但是拿不到o1
        //发生死锁

    }
}
/**
 * Class: DeadLockDemo
 *
 * <pre>
 * 演示多线程死锁问题：
 *
 * 线程A:
 * 先获取 o1 锁，再尝试获取 o2 锁
 *
 * 线程B:
 * 先获取 o2 锁，再尝试获取 o1 锁
 *
 * 当两个线程互相等待对方释放锁时，形成死锁。
 * </pre>
 *
 * @author pawamamama
 * @date 2026/7/10
 */
@SuppressWarnings({"all"})
class DeadLockDemo extends Thread {

    // 保证多个线程共享同一个对象锁
    static Object o1 = new Object();
    static Object o2 = new Object();

    boolean flag;

    // 构造器
    public DeadLockDemo(boolean flag) {
        this.flag = flag;
    }

    @Override
    public void run() {

        /*
         * 业务逻辑分析：
         *
         * 1. flag == true:
         *    线程A先获得 o1 对象锁
         *    然后尝试获取 o2 对象锁
         *
         * 2. 如果线程A获取不到 o2 锁
         *    就会进入 Blocked 状态等待
         *
         * 3. flag == false:
         *    线程B先获得 o2 对象锁
         *    然后尝试获取 o1 对象锁
         *
         * 4. 如果线程B获取不到 o1 锁
         *    就会进入 Blocked 状态等待
         *
         * 最终形成死锁：
         * A 等待 B 释放 o2
         * B 等待 A 释放 o1
         */


        if (flag) {

            synchronized (o1) {

                System.out.println(
                        Thread.currentThread().getName()
                                + " 进入1"
                );

                synchronized (o2) {

                    System.out.println(
                            Thread.currentThread().getName()
                                    + " 进入2"
                    );

                }
            }

        } else {

            synchronized (o2) {

                System.out.println(
                        Thread.currentThread().getName()
                                + " 进入3"
                );

                synchronized (o1) {

                    System.out.println(
                            Thread.currentThread().getName()
                                    + " 进入4"
                    );

                }
            }
        }
    }


}