
package com.pawamamama.tank_game_teacher;

import java.util.Vector;

/**
 * Class: Hero
 *
 * <pre>
 *     玩家Tank
 * </pre>
 *
 * @author pawamamama
 * @date 2026/7/6
 */
@SuppressWarnings({"all"})
public class Hero extends Tank {
    //定义一个Shot对象，表示一个射击行为(线程)
    Shot shot = null;
    //可以发射多颗子弹
    Vector<Shot> shots = new Vector<Shot>();
    int bulletBigSize = 5;

    public Hero(int x, int y) {
        super(x, y);
        setSpeed(5);
    }

    //射击
    public void shotEnemyTank() {
        if (shots.size() == bulletBigSize) {
            return;
        }
        //真正创建Shot对象
        //1.创建对象时，要根据当前Hero对象的位置和方向来创建
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
}