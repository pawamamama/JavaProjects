package com.pawamamama.htreaduse;

/**
 * Class: SellTicket
 *
 * <pre>
 * 多线程售票案例：
 *
 * 模拟三个售票窗口同时出售100张票。
 *
 * 一、使用 Thread 方式创建线程：
 * 1. 定义 TicketSalesWindow 类继承 Thread。
 * 2. 重写 run() 方法，实现售票逻辑。
 * 3. 创建三个 Thread 子类对象并调用 start() 启动线程。
 *
 * 由于 ticketNumber 使用 static 修饰，
 * 多个线程共享同一个票数变量。
 *
 * 但是多个线程同时访问共享资源时，
 * 如果没有线程同步控制，会出现线程安全问题：
 * 例如：
 * 1. 票数重复出售。
 * 2. 出现负数票。
 * 3. 多个窗口同时出售同一张票。
 *
 *
 * 二、使用 Runnable 接口方式创建线程：
 * 1. 定义 TicketSalesWindow_interface 类实现 Runnable 接口。
 * 2. 重写 run() 方法。
 * 3. 创建多个 Thread 对象，并传入同一个 Runnable 实例。
 *
 * Runnable 方式中：
 * ticketNumber 不需要 static 修饰，
 * 因为三个 Thread 共享同一个 Runnable 对象。
 *
 * new Thread(window_interface).start();
 *
 * 三个线程实际上操作的是同一个 TicketSalesWindow_interface 对象，
 * 所以其中的成员变量 ticketNumber 是共享资源。
 *
 *
 * 三、线程安全问题：
 *
 * 当前代码存在竞态条件（Race Condition）。
 *
 * 原因：
 * 多个线程执行以下步骤时可能发生交叉：
 *
 * 1. 判断 ticketNumber 是否大于0。
 * 2. 线程休眠。
 * 3. 对 ticketNumber 执行 -- 操作。
 *
 * 例如：
 *
 * 线程A读取 ticketNumber = 1
 * 线程B也读取 ticketNumber = 1
 *
 * 两个线程都认为还有票，
 * 最终可能卖出两张票。
 *
 * </pre>
 *
 * @author pawamamama
 * @date 2026/7/9
 */
@SuppressWarnings({"all"})
public class SellTicket {
    public static void main(String[] args) {
     /*   TicketSalesWindow window1 = new TicketSalesWindow();
        TicketSalesWindow window2 = new TicketSalesWindow();
        TicketSalesWindow window3 = new TicketSalesWindow();
        //启动线程
        //这里会出现票数超卖现象

        window1.start();
        window2.start();
        window3.start();*/

        System.out.println("使用接口的方式来售票");
        TicketSalesWindow_interface window_interface = new TicketSalesWindow_interface();
        //同一个对象有三个线程来操作
        //ticketNumber 被三个线程操作，所以不用静态
        //三个线程同时操作还是会出现超卖现象
        new Thread(window_interface).start();
        new Thread(window_interface).start();
        new Thread(window_interface).start();


    }

}

// 使用 Thread方式
class TicketSalesWindow extends Thread {
    private static int ticketNumber = 100;//多个线程共享 ticket

    @Override
    public void run() {
        while (true) {
            if (ticketNumber <= 0) {
                System.out.println("窗口" + Thread.currentThread().getName() + "售票结束");
                break;
            }
            //休眠50 ms,售票等待
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("窗口" + Thread.currentThread().getName() + "售出了一张票"
                    + "剩余票数" + (--ticketNumber));
        }
    }
}

//实现接口的方式
class TicketSalesWindow_interface implements Runnable {
    private int ticketNumber = 100;//不用加静态也是多个线程共享 ticket

    @Override
    public void run() {
        while (true) {
            if (ticketNumber <= 0) {
                System.out.println("窗口" + Thread.currentThread().getName() + "售票结束");
                break;
            }
            //休眠50 ms,售票等待
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("窗口" + Thread.currentThread().getName() + "售出了一张票"
                    + "剩余票数" + (--ticketNumber));
        }
    }
}