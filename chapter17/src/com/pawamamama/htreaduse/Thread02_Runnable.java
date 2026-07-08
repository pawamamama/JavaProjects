package com.pawamamama.htreaduse;

/**
 * Class: Thread02_Runnable
 *
 * <pre>
 * Runnable 创建线程方式演示：
 *
 * Java创建线程有两种常见方式：
 *
 * 1. 继承 Thread 类
 *    - 重写 run()
 *    - 创建子类对象
 *    - 调用 start() 开启线程
 *
 * 2. 实现 Runnable 接口
 *    - 实现 run()
 *    - 将 Runnable 实现类对象传入 Thread
 *    - 调用 Thread.start() 开启线程
 *
 * Runnable 方式的优点：
 * 1. 避免 Java 单继承限制
 * 2. 可以实现多个线程共享同一个任务对象
 * 3. 将任务和线程进行解耦，符合面向对象设计思想
 *
 * 本案例通过模拟 Thread 内部代理机制，
 * 理解 Runnable 为什么不能直接调用 start()。
 *
 * </pre>
 *
 * @author pawamamama
 * @date 2026/7/8
 */
@SuppressWarnings({"all"})
public class Thread02_Runnable {

    public static void main(String[] args) {

        /*
         * Runnable接口中只有run()方法，
         * 并没有start()方法。
         *
         * 所以：
         *
         * Dog dog = new Dog();
         * dog.start();  //错误
         *
         * Runnable只是定义了一个任务，
         * 真正创建线程的是Thread类。
         *
         */


        /*
         * 正常写法：
         *
         * Dog dog = new Dog();
         *
         * Thread thread = new Thread(dog);
         *
         * thread.start();
         *
         * Thread对象负责启动线程，
         * 然后调用Runnable对象中的run()方法。
         */


        /*
         * 模拟 Thread 的代理思想
         *
         * ThreadProxy 相当于 Thread 类，
         * Tiger 相当于 Runnable任务。
         *
         */
        Tiger tiger = new Tiger();

        ThreadProxy proxy = new ThreadProxy(tiger);

        proxy.start();

    }

}


/**
 * Animal父类
 *
 * 用于演示：
 * Tiger不仅是动物，
 * 同时也可以作为线程任务。
 */
class Animal {

}


/**
 * Tiger线程任务类
 *
 * 实现 Runnable接口，
 * 表示这个类具有被线程执行的能力。
 *
 * 注意：
 *
 * Tiger本身不是线程对象，
 * 只是一个任务。
 *
 * 必须交给Thread对象才能启动线程。
 */
class Tiger extends Animal implements Runnable {


    /**
     * 线程执行的方法
     *
     * 当线程启动以后，
     * JVM会自动调用run()方法。
     */
    @Override
    public void run() {

        System.out.println(
                "I am a Tiger"
                        + " 当前线程 = "
                        + Thread.currentThread().getName()
        );

    }

}


/**
 * Thread代理类
 *
 * 模拟Thread内部执行Runnable任务的过程。
 *
 * 真实Thread源码比这个复杂，
 * 这里主要理解设计思想：
 *
 * Thread作为代理对象，
 * 持有Runnable任务对象，
 * 当线程启动后执行Runnable.run()
 *
 */
class ThreadProxy implements Runnable {


    /**
     * 被代理的Runnable对象
     *
     * 保存真正需要执行的任务。
     */
    private Runnable target;


    public ThreadProxy(Runnable target) {

        this.target = target;

    }


    /**
     * 执行任务
     *
     * 调用真正Runnable对象的run方法。
     *
     * 这里体现：
     * 动态绑定
     */
    @Override
    public void run() {

        if (target != null) {

            target.run();

        }

    }


    /**
     * 模拟Thread.start()
     *
     * 真正Thread.start()
     * 会让JVM创建新的线程。
     *
     * 这里为了理解流程，
     * 简化为直接调用start0()
     */
    public void start() {

        start0();

    }


    /**
     * 模拟底层启动方法
     *
     * 真实情况：
     *
     * start()
     * ↓
     * JVM创建新线程
     * ↓
     * 自动调用run()
     *
     *
     * 当前模拟：
     *
     * start0()
     * ↓
     * 调用代理对象run()
     * ↓
     * 调用Tiger.run()
     *
     */
    public void start0() {

        run();

    }

}


/**
 * Dog线程任务类
 *
 * Runnable接口实现案例。
 *
 * Dog对象不是线程，
 * 只是线程执行的任务。
 */
class Dog implements Runnable {


    /**
     * 线程执行代码
     *
     * 开启线程后自动执行。
     */
    @Override
    public void run() {


        int i = 0;


        while (true) {


            System.out.println(
                    "dog叫 "
                            + (++i)
                            + " 当前线程 = "
                            + Thread.currentThread().getName()
            );


            try {

                Thread.sleep(1000);

            } catch (InterruptedException e) {

                throw new RuntimeException(e);

            }


            if (i == 1) {

                break;

            }

        }

    }

}