
package com.pawamamama.transformation;

import java.io.*;

/**
 * Class: InputStreamReader_
 *
 * <pre>
 * InputStreamReader 的使用：
 * 将字节流 FileInputStream 转换为字符流，
 * 并指定字符编码读取文本文件。
 *
 * 再通过 BufferedReader 对字符流进行包装，
 * 可以使用 readLine() 按行读取文件内容。
 * </pre>
 *
 * @author pawamamama
 * @date 2026/8/11
 */
@SuppressWarnings({"all"})
public class inputStreamReader_ {

    public static void main(String[] args) throws IOException {

        // 文件路径
        String filePath = "D:\\java_learning\\java_code\\chapter19\\src\\com\\pawamamama\\transformation\\a.txt";

        // FileInputStream：字节流，负责从文件中读取字节
        // InputStreamReader：将字节流转换为字符流，并指定字符编码
        InputStreamReader isr =
                new InputStreamReader(new FileInputStream(filePath), "UTF-8");

        // BufferedReader：处理流，可以提高读取效率，并支持 readLine() 按行读取
        BufferedReader reader = new BufferedReader(isr);

        // 按行读取文件内容
        String line = reader.readLine();

        // 输出读取到的内容
        System.out.println(line);

        // 关闭流
        reader.close();
    }
}

