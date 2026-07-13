package com.pawamamama.tank_game_study;

import javax.swing.*;
/**
 * Class: pawaTankGame
 *
 * <pre>
 * </pre>
 *
 * @author pawamamama
 * @date 2026/7/6
 */
@SuppressWarnings({"all"})
public class pawaTankGame  extends JFrame {
    //创建游戏区域
    MyPanel mp = null;

    public static void main(String[] args) {
        new pawaTankGame();
    }
    //构造器
    public pawaTankGame() {
        mp = new MyPanel();
        //将mp放入Thread
        Thread thread = new Thread(mp);
        thread.start();
        //在窗口内添加游戏区域
        this.add(mp);
        //设置窗口大小
        this.setSize(1100,850);
        this.addKeyListener(mp);//监听键盘
        //设置显示 and 默认关闭
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}