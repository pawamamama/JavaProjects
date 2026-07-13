package com.pawamamama.tank_game_study;

import java.util.Vector;

/**
 * Class: Hero 玩家坦克 - 学习版自己复刻
 *
 * <pre>
 * </pre>
 *
 * @author pawamamama
 * @date 2026/7/6
 */
@SuppressWarnings({"all"})
public class Hero extends Tank{
    //shot对象
    Shot shot= null;
    //多个子弹
    Vector<Shot> shots = new Vector<>();
    //子弹最值
     int bulletBigSize = 5;
    public Hero(int x, int y) {
        super(x, y);
        setSpeed(5);
    }
    //子弹射击方法
    public void shotEnemyTank() {
        if (shots.size() == bulletBigSize) {//限制子弹
            return;
        }
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
        //加入到集合中
        shots.add(shot);
        Thread shotThread = new Thread(shot);
        shotThread.start();
    }
}