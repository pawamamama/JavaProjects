package com.pawamamama.tank_game_music;

/**
 * Class: Node
 *
 * <pre>一个node对象表示，一个敌人坦克的信息
 * </pre>
 *
 * @author pawamamama
 * @date 2026/8/17
 */
@SuppressWarnings({"all"})
public class Node {
    private int x ;
    private int y;
    private int direct;

    public Node(int x, int y, int direct) {
        this.x = x;
        this.y = y;
        this.direct = direct;
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
}