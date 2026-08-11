 package com.pawamamama.transformation;
import java.io.*;

/**
 * Class: OutputStreamWriter_
 *
 * <pre>
 * OutputStreamWriter 的使用：
 * 将字符流转换为字节流，指定字符编码后，
 * 可以将字符数据按照指定编码写入文件。
 *
 * BufferedOutputStream 是字节处理流，
 * 用于提高字节流的写入效率。
 * </pre>
 *
 * @author pawamamama
 * @date 2026/8/11
 */
@SuppressWarnings({"all"})
public class outputStreamWriter_ {

    public static void main(String[] args) throws IOException {

        // 文件路径
        String filePath = "D:\\java_learning\\java_code\\chapter19" +
                "\\src\\com\\pawamamama\\transformation\\b.txt";

        // FileOutputStream：字节流，负责向文件写入字节
        // BufferedOutputStream：字节处理流，提高写入效率
        // OutputStreamWriter：将字符转换为字节，并指定 UTF-8 编码
        OutputStreamWriter osw = new OutputStreamWriter(
                new BufferedOutputStream(new FileOutputStream(filePath)),
                "UTF-8"
        );

        // 写入字符串
        osw.write("Hello World 王微信");

        // 关闭流，同时刷新缓冲区中的数据
        osw.close();
    }
}