package com.pawamamama.tank_game_study;

import java.util.Vector;

/**
 * Class: EnemyTank 敌方坦克
 *
 * <pre>
 * </pre>
 *
 * @author pawamamama
 * @date 2026/7/7
 */
@SuppressWarnings({"all"})
public class EnemyTank extends Tank implements Runnable {

    int go = 30;
    int sleep = 100;
    //敌方子弹线程
    Vector<Shot> shots = new Vector();
    //子弹最大值
    int bulletBigSize = 5;

    public EnemyTank(int x, int y) {
        super(x, y);
        setSpeed(3);
    }
    //敌人发射子弹
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
            if (isLive && shots.size() < bulletBigSize ) {
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
            setDirect((int)(Math.random()*4));
            if ((!isLive)) {//死亡就结束线程
                break;
            }
        }
    }
}