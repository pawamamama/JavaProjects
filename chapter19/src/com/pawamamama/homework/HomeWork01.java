package com.pawamamama.homework;

import java.io.*;
import java.sql.SQLOutput;

/**
 * Class: HomeWork01
 *
 * <pre>
 * </pre>
 *
 * @author pawamamama
 * @date 2026/8/13
 */
@SuppressWarnings({"all"})
public class HomeWork01 {
    public static void main(String[] args) throws IOException {
        String directoryPath = "D:\\java_learning\\java_code\\chapter19" +
                "\\src\\com\\pawamamama\\homework\\mytemp";
        File file = new File(directoryPath);
        if (!file.exists()) {
            file.mkdir();//创建文件夹
        }
        String filePath = directoryPath + "hello.txt";
        file = new File(filePath);
        if (!file.exists()) {
            if (file.createNewFile()) {
                System.out.println("创建成功");
            } else {
                System.out.println("创建失败");
            }
        }else {
            System.out.println("文件存在");
        }
        BufferedWriter bw = new BufferedWriter(new FileWriter(file));
        bw.write("hello word");
        bw.close();

    }

}