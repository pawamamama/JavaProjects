package com.pawamamama.htreaduse;

/**
 * Class: Thread01
 *
 * <pre>
 * Java多线程基础案例：
 *
 * 一、Thread创建线程：
 * 1. 定义类继承 Thread 类。
 * 2. 重写 run() 方法，在其中编写线程执行任务。
 * 3. 创建线程对象，通过 start() 方法启动线程。
 *
 * 调用 start() 后，JVM 会创建新的线程，
 * 并由新线程执行 run() 方法。
 *
 *
 * 二、主线程和子线程：
 *
 * main 方法运行在线程 main 中，称为主线程。
 *
 * 创建 Cat 对象：
 *
 *      Cat cat = new Cat();
 *
 * 此时只是创建对象，并未启动线程。
 *
 * 调用：
 *
 *      cat.start();
 *
 * JVM 创建子线程 Thread-0，
 * 执行 Cat 类中的 run() 方法。
 *
 * 主线程启动子线程后不会等待子线程结束，
 * 而是继续执行后面的代码。
 *
 * 执行关系：
 *
 *      main线程              Thread-0
 *          |                    |
 *      main方法              run方法
 *
 * 两个线程由CPU调度执行：
 * 单核CPU表现为交替执行，
 * 多核CPU可能实现真正并行。
 *
 *
 * 三、start() 和 run() 区别：
 *
 * start():
 * - 创建新的线程。
 * - JVM自动调用 run()。
 * - 实现真正多线程。
 *
 * run():
 * - 普通方法调用。
 * - 不创建新线程。
 * - 在当前线程中执行。
 *
 *
 * 四、Thread.currentThread()
 *
 * 获取当前执行代码的线程对象。
 *
 * 示例：
 *
 *      Thread.currentThread().getName()
 *
 * 常见线程名称：
 * main     主线程
 * Thread-0 第一个子线程
 *
 *
 * 五、Thread.sleep()
 *
 * 使当前线程休眠指定时间。
 *
 * 本案例：
 *
 *      Thread.sleep(1000);
 *
 * 表示当前线程暂停1秒，
 * 之后重新参与CPU调度。
 *
 *
 * 六、运行结果：
 *
 * 主线程：
 *      主线程继续执行
 *      主线程 i = 0
 *
 * 子线程：
 *      喵喵，我是小猫咪1
 *      喵喵，我是小猫咪2
 *
 * 多线程执行顺序不固定，
 * 由CPU线程调度决定。
 *
 * </pre>
 *
 * @author pawamamama
 * @date 2026/7/8
 */
@SuppressWarnings({"all"})
public class Thread01 {
    public static void main(String[] args) {
        //创建Cat对象，当作线程使用
        Cat cat = new Cat();
        cat.start();//启动线程
        //当 main 启动一个子线程后 Thread - 0 ,主线程不会阻塞，会继续执行
        //这时主线程和子线程是交替执行的
        System.out.println("主线程继续执行" + Thread.currentThread().getName());//名字默认叫 - main
        for (int i = 0; i < 60; i++) {
            System.out.println("主线程 i =" + i);
            //让主线程休眠
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }


    }

}
/**
 * Class: Cat
 *
 * <pre>
 * 自定义线程类。
 *
 * 通过继承 Thread 类实现线程创建方式：
 *
 * 1. 继承 Thread 类。
 * 2. 重写 run() 方法。
 * 3. 创建对象后调用 start() 启动线程。
 *
 * 线程执行逻辑：
 * 每隔 1 秒打印一次猫叫信息，
 * 当输出次数达到 8 次后结束线程。
 *
 * </pre>
 *
 * @author pawamamama
 * @date 2026/7/8
 */
//1. 一个类继承 Thread 类后，该类的对象就可以作为线程使用。
//2. 重写 run() 方法，在 run() 中编写线程执行的任务。
//3. 调用 start() 方法启动线程，JVM 会开启新的线程执行 run() 方法。
class Cat extends Thread {
    public void run() {//重写run方法，写上自己的业务逻辑
        //该线程每隔一秒输出，喵喵，我是小猫咪
        int time = 0;
        while (true) {
            System.out.println("喵喵，我是小猫咪"+(++time) + "线程名称 = " + Thread.currentThread().getName());
            //让该线程休眠一秒i
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            if (time == 80) {//time == 80时就退出循环，这时线程也就退出
                break;
            }
        }

    }
}