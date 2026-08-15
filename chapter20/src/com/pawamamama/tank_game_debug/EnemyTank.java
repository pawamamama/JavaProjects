package com.pawamamama.tank_game_debug;

import java.util.Vector;

/**
 * Class: EnemyTank
 *
 * <pre>敌方tank
 *      1.有自己的特殊的属性和方法，所以继承tank类，单开一个EnemyTank类去
 *      2.敌人坦克数量多可以放入到集合内进行管理
 *          将来坦克需要多线程需要使用Vector 集合来管理
 *      3.实现坦克自由移动
 * </pre>
 *
 * @author pawamamama
 * @date 2026/7/7
 */
@SuppressWarnings({"all"})
public class EnemyTank extends Tank implements Runnable {
    //敌人走一步的步数
    int go = 30;
    //敌人休眠时间
    int sleep = 100;
    //在敌人坦克类，使用Vector 保持多个Shot
    Vector<Shot> shots = new Vector();
    //敌人坦克发射子弹最大值
    int bulletBigSize = 5;


    public EnemyTank(int x, int y) {

        super(x, y);
        setSpeed(3);
    }

    //发射子弹方法
    private void shotHero() {
        //临时变量
        Shot shot = null;
        switch (getDirect()) {

            case 0: // 向上
                shot = new Shot(getX() + 20, getY(), 0);
                break;

            case 1: // 向右
                shot = new Shot(getX() + 60, getY() + 20, 1);
                break;

            case 2: // 向下
                shot = new Shot(getX() + 20, getY() + 60, 2);
                break;

            case 3: // 向左
                shot = new Shot(getX(), getY() + 20, 3);
                break;
        }
        //把shot加入到集合中
        shots.add(shot);
        //启动射击线程
        Thread thread = new Thread(shot);
        thread.start();
    }

    @Override
    public void run() {
        while (true) {
            //如果shots size() < 5 && isLive == true
            if (shots.size() < 5 && isLive) {
                //就发射子弹
                shotHero();
            }
            //根据坦克的方向来继续移动
            switch (getDirect()) {
                case 0://上
                    for (int i = 0; i < go; i++) {
                        moveUp();

                        try {
                            Thread.sleep(sleep);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                    break;
                case 1:
                    for (int i = 0; i < go; i++) {
                        moveRight();

                        try {
                            Thread.sleep(sleep);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                    break;
                case 2:
                    for (int i = 0; i < go; i++) {
                        moveDown();
                        try {
                            Thread.sleep(sleep);
                        } catch (InterruptedException e) {
                        }
                    }
                    break;
                case 3:
                    for (int i = 0; i < go; i++) {
                        moveLeft();
                        try {
                            Thread.sleep(sleep);
                        } catch (InterruptedException e) {
                        }
                    }
                    break;
            }
            //然后随机的改变坦克方向 0~3的整数
            setDirect((int) (Math.random() * 4));
            //写多线程并发程序一定要考虑线程什么时候结束
            if ((!isLive)) {//死了就退出线程
                break;
            }
        }
    }

    @Override
    public String toString() {
        return  "EnemyTank{" +
                "shots=" + shots +
                '}';
    }
}