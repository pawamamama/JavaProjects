package com.pawamamama.tank_game_teacher;

import javax.swing.*;
import java.awt.*;

/**
 * Class: MyPanel 坦克大战游戏绘图区域
 *
 * <pre>
 * </pre>
 *
 * @author pawamamama
 * @date 2026/7/6
 */
@SuppressWarnings({"all"})
public class MyPanel extends JPanel {
    //定义玩家坦克
    Hero hero = null;

    public MyPanel() {
        hero = new Hero(100, 100);//初始化自己的坦克
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        //做一个填充矩形
        g.fillRect(0,0, 1000,750);//默认是黑色
    }
}