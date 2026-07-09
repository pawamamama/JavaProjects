package com.pawamamama.htreaduse.state_;

/**
 * Class: ThreadState01
 *
 * <pre>
 * Java线程七大状态：
 *
 * 1. NEW（新建状态）
 *    创建Thread对象，但没有调用start()方法。
 *
 * 2. RUNNABLE（可运行状态）
 *    调用start()后，线程进入可运行状态，等待CPU调度。
 *    Java中包含“就绪”和“运行”两个状态。
 *
 * 3. RUNNING（运行状态）
 *    线程获得CPU时间片，正在执行run()方法。
 *
 * 4. BLOCKED（阻塞状态）
 *    线程等待获取锁时进入阻塞状态。
 *
 * 5. WAITING（等待状态）
 *    线程主动等待，需要其他线程唤醒。
 *
 * 6. TIMED_WAITING（超时等待状态）
 *    线程等待指定时间后自动恢复，例如sleep()。
 *
 * 7. TERMINATED（终止状态）
 *    线程执行完成，生命周期结束。
 *
 * 注意：
 * Java官方Thread.State只有6种状态，
 * RUNNING通常包含在RUNNABLE中。
 *
 * 本阶段暂不深入同步、锁、线程通信。
 *
 * </pre>
 *
 * @author pawamamama
 * @date 2026/7/9
 */
@SuppressWarnings({"all"})
public class TreadState01_ {
    public static void main(String[] args) throws InterruptedException {
        T t = new T();
        System.out.println(t.getName() + "状态 = " + t.getState());
        t.start();
        while (Thread.State.TERMINATED != t.getState()) {
            System.out.println(t.getName() + "状态 = " + t.getState());
            Thread.sleep(500);
        }
        System.out.println(t.getName() + "状态 = " + t.getState());//TERMINATED 终止状态
    }
}
class T extends  Thread {
    public void run() {
        while (true) {
            for (int i = 1; i <= 10; i++) {
                System.out.println("Hello World" + i);// runnable 就绪状态
                try {
                    Thread.sleep(1000);//超时等待状态 TIMED_WAITING timed_waiting
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            break;
        }
    }
}