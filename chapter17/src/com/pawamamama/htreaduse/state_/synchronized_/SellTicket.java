package com.pawamamama.htreaduse.state_.synchronized_;

/**
 * Class: SellTicket
 *
 * <pre>
 * synchronized 同步机制学习案例：
 *
 * 通过多线程售票案例学习 Java 中的线程同步机制。
 *
 *
 * 一、线程安全问题：
 *
 * 多线程访问共享资源时，
 * 如果没有同步控制，可能导致数据不一致。
 *
 *
 * 二、对象互斥锁：
 *
 * Java 为了解决线程安全问题，
 * 引入了对象互斥锁（Monitor）。
 *
 * 每个对象都有一个互斥锁标记，
 * 同一时间只能有一个线程访问该对象。
 *
 *
 * 三、synchronized 关键字：
 *
 * synchronized 用于实现线程同步，
 * 保证多个线程访问共享资源时的数据完整性。
 *
 * 当对象使用 synchronized 修饰时，
 * 表示该对象在同一时刻只能被一个线程访问。
 *
 *
 * 四、同步方法：
 *
 * synchronized 修饰普通成员方法时，
 * 锁对象默认为当前对象 this。
 *
 * 等价于：
 *
 * synchronized(this){
 *
 *     方法体代码
 *
 * }
 *
 *
 * 五、同步代码块：
 *
 * synchronized 可以修饰代码块，
 * 手动指定锁对象。
 *
 * 格式：
 *
 * synchronized(对象){
 *
 *     //需要同步的代码
 *
 * }
 *
 *
 * 锁对象可以是任意对象，
 * 但是多个线程必须使用同一个锁对象，
 * 才能实现同步效果。
 *
 *
 * 六、静态同步方法：
 *
 * 当 synchronized 修饰 static 方法时，
 * 锁对象不再是当前对象 this，
 * 而是当前类的 Class 对象。
 *
 * 等价于：
 *
 * synchronized(类名.class){
 *
 *     方法体代码
 *
 * }
 *
 *
 * 例如：
 *
 * public static synchronized void test(){
 *
 * }
 *
 *
 * 锁对象：
 *
 * 当前类的 Class 对象。
 *
 *
 * 七、同步范围：
 *
 * synchronized 的锁对象决定线程之间的互斥范围。
 *
 * 如果多个线程使用同一个锁对象，
 * 则同一时间只能有一个线程执行同步代码。
 *
 * 如果锁对象不同，
 * synchronized 不会产生同步效果。
 *
 *
 * 八、同步的局限性：
 *
 * synchronized 虽然可以保证线程安全，
 * 但是由于线程需要竞争锁，
 * 会降低程序执行效率。
 *
 * 因此实际开发中应该尽量缩小同步范围，
 * 只锁住必要的代码。
 *
 *
 * 九、注意事项：
 *
 * synchronized 只能保证线程同步，
 * 不保证线程执行顺序。
 *
 * 多个线程不会严格按照固定顺序执行。
 *
 * </pre>
 *
 * @author pawamamama
 * @date 2026/7/9
 */
@SuppressWarnings({"all"})
public class SellTicket {

    public static void main(String[] args) {

       /* System.out.println("使用 Runnable 接口方式售票");

        TicketSalesWindow_interface window =
                new TicketSalesWindow_interface();

        // 三个线程共享同一个 Runnable 对象
        new Thread(window, "窗口1").start();
        new Thread(window, "窗口2").start();
        new Thread(window, "窗口3").start();*/
        System.out.println("使用 Thread方式售票");
        new TicketSalesWindow().start();
        new TicketSalesWindow().start();
        new TicketSalesWindow().start();
    }
}


// 使用 Thread方式
//这时使用锁应该使用常量对象保证多个线程拿到的是同一个锁
class TicketSalesWindow extends Thread {
    private static int ticketNumber = 500;//多个线程共享 ticket
    static Object lock = new Object();
    @Override
    public void run() {
        synchronized (lock) {
            while (true) {
                if (ticketNumber <= 0) {
                    System.out.println("窗口" + Thread.currentThread().getName() + "售票结束");
                    break;
                }
                //休眠50 ms,售票等待
                try {
                    Thread.sleep(30);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("窗口" + Thread.currentThread().getName() + "售出了一张票"
                        + "剩余票数" + (--ticketNumber));
            }
        }
    }
}
/**
 * 使用 Runnable 接口实现售票窗口
 */
class TicketSalesWindow_interface implements Runnable {

    // 多个线程共享同一个 ticketNumber
    private int ticketNumber = 500;

    private boolean loop = true;
    /*锁对象可以是任意对象，
    但是多个线程必须使用同一个锁对象，
    才能实现同步效果。*/
    Object object = new Object();
    static Object OBJECT = new  Object();

    /**
     * 售票方法
     * <p>
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
    //静态同步方法的锁为类本身
    public static void m1() {
        synchronized (TicketSalesWindow_interface.class) {
            System.out.println("静态同步方法的锁为类本身");
        }
        //如果是常量对象也行
        synchronized (OBJECT) {
            System.out.println("静态同步方法的锁为类本身或者常量对象");
        }
    }
    /**
     * 在代码块上加锁，互斥锁还是在this对象
     *
     */
    public void sellTicket2() {

        synchronized (/*this*/ object) {
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
    }


    @Override
    public void run() {

        while (loop) {
//            sellTicket();
            sellTicket2();
        }
    }
}