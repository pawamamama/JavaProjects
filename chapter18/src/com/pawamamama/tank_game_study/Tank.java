package com.pawamamama.tank_game_study;

/**
 * Class: Tank 父类-学习版-自己完整写出来
 *
 * <pre>
 * </pre>
 *
 * @author pawamamama
 * @date 2026/7/6
 */
@SuppressWarnings({"all"})
public class Tank {
    //定义坦克的坐标
    private int x;
    private int y;
    private int direct;
    private int speed;
    //构造器
    public Tank(int x, int y) {
        this.x = x;
        this.y = y;
        //默认三
        this.speed = 3;
    }
    //移动方法
    public void moveUp() {
        y -=speed;
    }
    public void moveRight() {
        x +=speed;
    }
    public void moveDown() {
        y +=speed;
    }
    public void moveLeft() {
        x -=speed;
    }
    //get and set
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