package com.pawamamama.writer_;

import java.io.*;

/**
 * Class: BufferadCopy_
 *
 * <pre>包装流拷贝
 * </pre>
 *
 * @author pawamamama
 * @date 2026/8/7
 */
@SuppressWarnings({"all"})
public class BufferadCopy_ {
    public static void main(String[] args) throws IOException {

        String copyFilePath = "D:\\java_learning\\java_code\\chapter19\\src\\com\\pawamamama\\writer_\\txt_\\test2.txt";
        String destPath = "D:\\java_learning\\java_code\\chapter19\\src\\com\\pawamamama\\writer_\\copy\\test2.txt";
        //读文件到流
        BufferedReader bufferedReader = new BufferedReader(new FileReader(copyFilePath));
        //写文件拷贝
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(destPath));
        //读取写入，按行读取
        String line;
        while ((line = bufferedReader.readLine()) != null) {
            //每读取一行就写入到文件
            bufferedWriter.write(line);
            //插入换行
            bufferedWriter.newLine();
        }
        //关闭流
        if (bufferedReader != null) {
            bufferedReader.close();
        }
        if (bufferedWriter != null) {
            bufferedWriter.close();
        }
        System.out.println("拷贝完毕");
    }

}