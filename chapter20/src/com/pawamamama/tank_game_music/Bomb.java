package com.pawamamama.tank_game_music;

/**
 * Class: Bomb
 *
 * <pre>
 * </pre>
 *
 * @author pawamamama
 * @date 2026/7/11
 */
@SuppressWarnings({"all"})
public class Bomb {
    int x,y;
    int life = 9;//炸弹的生命周期
    boolean isLive = true;//是否存活

    public Bomb(int x, int y) {
        this.x = x;
        this.y = y;
    }

    //减少生命周期
    public void lifeDown() {//配合图片进行爆炸效果，渐变
        if (life > 0) {
            life--;
        } else {
            isLive = false;
        }
    }
}