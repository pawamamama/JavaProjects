package com.pawamamama.writer_;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Class: BufferedWriter_
 *
 * <pre>
 * </pre>
 *
 * @author pawamamama
 * @date 2026/8/7
 */
@SuppressWarnings({"all"})
public class BufferedWriter_ {
    public static void main(String[] args) throws IOException {
        String filePath = "D:\\java_learning\\java_code\\chapter19\\src\\com\\pawamamama\\writer_\\txt_\\test2.txt";
        BufferedWriter bw = null;
        bw = new BufferedWriter(new FileWriter(filePath,true));//追加方式-
        bw.write("Hello World");
        //插入一个和系统相关的换行符
        bw.newLine();
        bw.write("Hello World");
        bw.write("Hello World");
        bw.write("Hello World");
        //关闭包装流即可
        bw.close();
    }

}