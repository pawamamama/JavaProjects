package com.pawamamama.tank_game_study;

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
    public Hero(int x, int y) {
        super(x, y);
    }
    //子弹射击方法
    public void shotEnemyTank() {
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
        Thread shotThread = new Thread(shot);
        shotThread.start();
    }
}