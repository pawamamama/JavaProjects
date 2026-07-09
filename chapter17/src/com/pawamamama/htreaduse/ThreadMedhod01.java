package com.pawamamama.htreaduse;

/**
 * Class: ThreadMedhod01
 *
 * <pre>
 *     线程常用方法演示
 *
 *     1. setName     设置线程名称
 *     2. getName     获取线程名称
 *     3. start       启动线程
 *     4. run         线程执行的方法
 *     5. setPriority 设置线程优先级
 *     6. getPriority 获取线程优先级
 *     7. sleep       线程休眠
 *     8. interrupt  中断线程
 * </pre>
 *
 * @author pawamamama
 * @date 2026/7/9
 */
@SuppressWarnings({"all"})
class ThreadMethod01 {

    public static void main(String[] args) throws InterruptedException {

        ThreadDemo01 td = new ThreadDemo01();

        // 设置线程名称
        td.setName("pawa");

        // 设置线程优先级
        td.setPriority(Thread.MIN_PRIORITY);


        // 获取当前main线程默认优先级
        System.out.println("线程名称" + td.getName() + "main线程优先级="
                + td.getPriority());

        // 启动线程
        td.start();


        // 主线程休眠1秒，打印一个hi
        for (int i = 1; i <= 5; i++) {
            System.out.println("主线程hi-" + i + "秒");
            Thread.sleep(1000);
        }
        System.out.println("中断td线程");
        td.interrupt();

    }
}


class ThreadDemo01 extends Thread {

    @Override
    public void run() {
        while (true) {

            for (int i = 0; i < 100; i++) {

                System.out.println(
                        Thread.currentThread().getName()
                                + " 吃包子~~~" + i
                );
            }

            try {

                System.out.println(
                        Thread.currentThread().getName()
                                + " 休眠中~~~"
                );

                // 休眠20秒
                Thread.sleep(20000);

            } catch (InterruptedException e) {

                // 捕获interrupt异常
                //当该线程执行一个interrupt方法时，就会catch一个异常
                //InterruptedException 是捕获了一个中断异常
                System.out.println(
                        Thread.currentThread().getName()
                                + " 被interrupt了"
                );

            }
        }
    }
}