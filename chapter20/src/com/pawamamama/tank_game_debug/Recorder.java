package com.pawamamama.tank_game_debug;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Vector;

/**
 * Class: Recorder
 *
 * <pre>该类用于记录游戏信息，和文件交互
 * </pre>
 *
 * @author pawamamama
 * @date 2026/8/17
 */
@SuppressWarnings({"all"})
public class Recorder {
    //定义变量，记录我方击毁敌人坦克数
    private static int allEnemyTankNum = 0;
    private static Vector<EnemyTank> enemyTanks = null;
    //定义IO对象,用于写数据到文件中
    private static BufferedWriter bw = null;
    //信息路径
    private static String recordFile = "src\\com\\pawamamama\\tank_game_debug\\myRecord.txt";

    public static void setEnemyTanks(Vector<EnemyTank> enemyTanks) {
        Recorder.enemyTanks = enemyTanks;
    }

    //添加一个方法,当游戏退出时，就将allEnemyTankNum保存到myRecordFile中
    //对keepRecording升级，保存敌人坦克坐标和方向
    public static  void keepRecording() {
        try {
            bw = new BufferedWriter(new FileWriter(recordFile));
            //击毁坦克数量
            bw.write(allEnemyTankNum+"");
            //遍历敌人坦克的Vector ,根据情况保存
            //oop,定义一个属性，通过set方法得到，敌人坦克的vector
            for (EnemyTank tank : enemyTanks) {
                if (tank.isLive) {
                    //保存该坦克的信息
                    String rectord = tank.getX() + " " + tank.getY() + " " + tank.getDirect();
                    bw.write(rectord);
                    bw.newLine();
                }
            }

            bw.newLine();//换行
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                bw.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
    public static void setAllEnemyTankNum(int allEnemyTankNum) {
        Recorder.allEnemyTankNum = allEnemyTankNum;
    }

    public static int getAllEnemyTankNum() {
        return allEnemyTankNum;
    }

    //当我方坦克击毁一个敌人坦克，就应当allEnemyTankNum++
    public static void addallEnemyTankNum() {
        Recorder.allEnemyTankNum++;
    }
}