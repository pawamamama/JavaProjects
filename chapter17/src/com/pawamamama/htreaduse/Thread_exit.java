package com.pawamamama.htreaduse;

/**
 * Class: Thread_exit
 *
 * <pre>
 * </pre>
 *
 * @author pawamamama
 * @date 2026/7/9
 */
@SuppressWarnings({"all"})
public class Thread_exit {
    public static void main(String[] args) throws InterruptedException {
        T t = new T();
        t.start();
        //休眠10秒
        Thread.sleep(10 * 1000);
        //如果希望主线程去控制t线程的终止，可以修改 loop
        //让t1退出run方法，主线程通知子线程退出
        t.setLoop(false);
    }
}

class T extends Thread {
    int count = 0;
    boolean loop = true;

    public void setLoop(boolean loop) {
        this.loop = loop;
    }

    @Override
    public void run() {

        while (loop) {
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("线程 = " + Thread.currentThread().getName() + "运行中 = " + ++count);
        }

    }
}