package com.pawamamama.homework;

import java.io.*;
/**
 * Class: HomeWork02
 *
 * <pre>
 * 使用字符处理流 BufferedReader 按行读取文件内容。
 *
 * 通过 InputStreamReader 指定 GBK 编码，
 * 将 FileInputStream 转换为字符输入流，
 * 再使用 BufferedReader 提供 readLine() 方法按行读取。
 *
 * 每读取一行，就在行末输出当前行号。
 * </pre>
 *
 * @author pawamamama
 * @date 2026/8/13
 */
@SuppressWarnings({"all"})
public class HomeWork02 {
    public static void main(String[] args) throws IOException {
        String path = "D:\\java_learning\\java_code\\" +
                "chapter19\\src\\com\\pawamamama\\homework\\mytemp\\hello.txt";
      BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(path), "GBK"));
        String line = "";
        int i = 0;
        while ((line = br.readLine()) != null) {
            System.out.println(line + ++i);
        }
        br.close();
    }

}