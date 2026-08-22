package com.pawamamama.tank_game_music;

/**
 * Class: Tank
 * <p>
 * 所有坦克对象的父类，负责定义坦克共有的属性和行为。
 * </p>
 *
 * <pre>
 * Tank类主要包含：
 * 1. 坦克的位置属性：
 *    - x：横坐标
 *    - y：纵坐标
 *
 * 2. 坦克运动属性：
 *    - direct：移动方向
 *       0 = 上
 *       1 = 右
 *       2 = 下
 *       3 = 左
 *
 *    - speed：移动速度
 *
 * 3. 坦克移动方法：
 *    - moveUp()    向上移动
 *    - moveRight() 向右移动
 *    - moveDown()  向下移动
 *    - moveLeft()  向左移动
 *
 * 该类作为坦克的基础模型，
 * 玩家坦克和敌人坦克可以通过继承该类，
 * 复用公共属性和移动逻辑，并扩展自己的功能。
 *
 * </pre>
 *
 * @author pawamamama
 * @date 2026/7/6
 */
@SuppressWarnings({"all"})
public class Tank {
    //属性部分
    //存活状态
    boolean isLive = true;
    //坦克的坐标
    private int x;//横
    private int y;//纵
    //添加坦克的方向
    private int direct; //0 = 上,1 = 右,2 = 下,3 = 左
    //添加坦克的速度
    private int speed;

    public Tank(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Tank(int x, int y, int direct) {
        this.x = x;
        this.y = y;
        this.direct = direct;
    }

    //移动方法
    public void moveUp() {
        if (y > 0) {
            y -= speed;
        }
    }

    public void moveRight() {
        if (x + 60 < 1000) {
            x += speed;
        }
    }

    public void moveDown() {
        if (y + 60 < 750)
            y += speed;
    }

    public void moveLeft() {
        if (x > 0) {
            x -= speed;
        }
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getDirect() {
        return direct;
    }

    public void setDirect(int direct) {
        this.direct = direct;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }
}