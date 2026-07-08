package com.pawamamama.htreaduse;

/**
 * Class: Thread03_Multithread
 *
 * <pre>
 * Java多线程初级案例：
 *
 * 一、实现多线程：
 *
 * 1. 创建多个Runnable任务对象
 * 2. 使用Thread作为线程对象
 * 3. 调用start()启动线程
 *
 *
 * 二、多线程执行特点：
 *
 * - main方法本身也是一个线程，称为主线程(main线程)
 * - 创建Thread对象调用start()后，
 *   JVM会创建新的线程执行run()方法
 * - 多个线程之间执行顺序由CPU调度决定
 * - 不同线程之间运行是交替执行的
 *
 *
 * 三、Thread与Runnable区别：
 *
 * 1. 继承Thread：
 *
 *    优点：
 *    - 编写简单，直接继承Thread即可
 *
 *    缺点：
 *    - Java是单继承机制，一个类继承Thread后无法再继承其他类
 *    - 线程任务和线程对象耦合较高
 *
 *
 * 2. 实现Runnable：
 *
 *    优点：
 *    - 避免Java单继承限制
 *    - 将任务和线程进行分离
 *    - 多个Thread可以共享同一个Runnable对象
 *
 *    缺点：
 *    - 需要借助Thread对象启动
 *
 *
 * 推荐：
 * 实际开发中更加推荐Runnable方式，
 * 或者使用线程池管理线程。
 *
 * </pre>
 *
 * @author pawamamama
 * @date 2026/7/8
 */
@SuppressWarnings({"all"})
public class Thread03_Multithread {
    public static void main(String[] args) {
        T1 t1 = new T1();
        T2 t2 = new T2();
        new Thread(t1).start();
        new Thread(t2).start();
        /*
         * 一个Runnable对象可以被多个Thread使用。
         *
         * 这里创建第二个线程执行同一个t2任务。
         *
         * 此时：
         * 两个线程都会执行T2.run()
         *
         */
        new  Thread(t2).start();
        int count = 0;
        while (true) {
            System.out.println("主线程--");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            if ( ++ count == 30) {//主线程先退出
                break;
            }
        }
    }
}

class T1 implements Runnable {
    public void run() {

        int count = 0;
        while (true) {
            System.out.println("hello word"+"线程名 = " + Thread.currentThread().getName());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            count++;
            if (count == 1000) {
                break;
            }
        }
    }
}

class T2 implements Runnable {
    public void run() {
        int count = 0;
        while (true) {
            System.out.println("hi" +"线程名 = " + Thread.currentThread().getName());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            count++;
            if (count == 500) {
                break;
            }
        }
    }
}
