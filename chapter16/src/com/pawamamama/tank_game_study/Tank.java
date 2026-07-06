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
    //构造器
    public Tank(int x, int y) {
        this.x = x;
        this.y = y;
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
}