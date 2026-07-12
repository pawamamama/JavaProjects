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
    //敌人是否存活
    boolean isLive = true;
    int go = 30;
    int sleep = 100;
    //敌方子弹线程
    Vector<Shot> shots = new Vector();

    public EnemyTank(int x, int y) {
        super(x, y);
        setSpeed(3);
    }

    @Override
    public void run() {
        while (true) {
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