package com.pawamamama.htreaduse.state_.synchronized_;

/**
 * Class: SellTicket
 *
 * <pre>
 * 多线程售票案例：
 *
 * 模拟三个窗口同时出售500张票。
 *
 * 使用 Runnable 接口创建线程：
 *
 * 1. 创建 TicketSalesWindow_interface 类实现 Runnable 接口。
 * 2. 重写 run() 方法，实现售票逻辑。
 * 3. 创建多个 Thread 对象，并传入同一个 Runnable 实例。
 *
 * 示例：
 *
 * TicketSalesWindow_interface window = new TicketSalesWindow_interface();
 *
 * new Thread(window).start();
 * new Thread(window).start();
 * new Thread(window).start();
 *
 * 三个线程共享同一个 Runnable 对象，
 * 因此成员变量 ticketNumber 是共享资源，
 * 不需要使用 static 修饰。
 *
 *
 * 线程安全问题：
 *
 * 多个线程同时操作共享变量 ticketNumber 时，
 * 可能出现数据不一致问题。
 *
 * 例如：
 *
 * 线程A读取票数
 * 线程B同时读取票数
 * 两个线程同时修改票数，
 * 导致重复售票或者票数错误。
 *
 *
 * synchronized 同步：
 *
 * 使用 synchronized 修饰方法，
 * 保证同一时间只能有一个线程执行售票方法。
 *
 * 作用：
 *
 * 1. 保证线程安全。
 * 2. 避免多个线程同时修改共享数据。
 * 3. 保证 ticketNumber 操作具有原子性。
 *
 * 注意：
 *
 * synchronized 只能保证线程同步，
 * 不保证线程执行顺序。
 * 多个线程不会严格按照窗口1、窗口2、窗口3交替执行。
 *
 * </pre>
 *
 * @author pawamamama
 * @date 2026/7/9
 */
@SuppressWarnings({"all"})
public class SellTicket {

    public static void main(String[] args) {

        System.out.println("使用 Runnable 接口方式售票");

        TicketSalesWindow_interface window =
                new TicketSalesWindow_interface();

        // 三个线程共享同一个 Runnable 对象
        new Thread(window, "窗口1").start();
        new Thread(window, "窗口2").start();
        new Thread(window, "窗口3").start();
    }
}


/**
 * 使用 Runnable 接口实现售票窗口
 */
class TicketSalesWindow_interface implements Runnable {

    // 多个线程共享同一个 ticketNumber
    private int ticketNumber = 500;

    private boolean loop = true;


    /**
     * 售票方法
     *
     * 使用 synchronized 保证同一时间只有一个线程执行该方法，
     * 防止多个线程同时修改 ticketNumber。
     */
    public synchronized void sellTicket() {

        if (ticketNumber <= 0) {
            System.out.println(
                    "窗口" + Thread.currentThread().getName()
                            + "售票结束"
            );
            loop = false;
            return;
        }


        try {
            Thread.sleep(50);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        System.out.println(
                "窗口" + Thread.currentThread().getName()
                        + "售出了一张票，剩余票数："
                        + (--ticketNumber)
        );
    }


    @Override
    public void run() {

        while (loop) {
            sellTicket();
        }
    }
}