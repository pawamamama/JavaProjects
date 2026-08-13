package com.pawamamama.properties_;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * Class: Properties01
 *
 * <pre>传统方案麻烦，要修改的多，单要ip指定麻烦
 * </pre>
 *
 * @author pawamamama
 * @date 2026/8/13
 */
@SuppressWarnings({"all"})
public class Properties01 {
    public static void main(String[] args) throws IOException {
        //读取properties 文件
        BufferedReader bufferedReader = new BufferedReader(new FileReader(
                "D:\\java_learning\\java_code\\chapter19\\src\\com\\" +
                        "pawamamama\\properties_\\mysql.properties"));
        String line = "";
        while ((line = bufferedReader.readLine())  != null) {
            String[] split = line.split("=");
            System.out.println(split[0] + "值是" +  split[1]);
        }
        bufferedReader.close();
    }
}