package com.pawamamama.tank_game_music;

import com.sun.org.apache.bcel.internal.generic.IF_ACMPEQ;

import java.io.*;
import java.util.Vector;

/**
 * Class: Recorder
 *
 * <pre>该类用于记录游戏信息，和文件交互，继续上局游戏
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
    private static BufferedReader br = null;
    //信息路径
    private static String recordFile = "src\\com\\pawamamama\\tank_game_music\\myRecord.txt";

    //定义一个Node的Vector,用于保存敌人信息
    private static Vector<Node> nodes = new Vector<Node>();

    //增加一个方法用于读取文件和恢复相关信息
    //该方法在继续上局游戏的位置开启
    public static Vector<Node> getNodesAndEnemyTanksRec() {
        try {
            br = new BufferedReader(new FileReader(recordFile));
            //读取击杀信息
            allEnemyTankNum = Integer.parseInt(br.readLine());
            //循环读取文件，生成nodes集合
            String line = "";
            while ((line = br.readLine()) != null) {
                //分割数据
                String[] split = line.split(" ");
                //创建node
                Node node = new Node(Integer.parseInt(split[0]),
                        Integer.parseInt(split[1]),
                        Integer.parseInt(split[2]));
                //加入到nodes
                nodes.add(node);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return nodes;
    }

    //添加一个方法,当游戏退出时，就将allEnemyTankNum保存到myRecordFile中
    //对keepRecording升级，保存敌人坦克坐标和方向
    public static void keepRecording() {
        try {
            bw = new BufferedWriter(new FileWriter(recordFile));
            //击毁坦克数量
            bw.write(allEnemyTankNum+"");
            bw.newLine();
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

    public static void setEnemyTanks(Vector<EnemyTank> enemyTanks) {
        Recorder.enemyTanks = enemyTanks;
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

    public static String getRecordFile() {
        return recordFile;
    }
}