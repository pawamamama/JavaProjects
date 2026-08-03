package com.pawamamama.reader_;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * FileReader 字符输入流
 *
 * <pre>
 * FileReader 是 Reader 的子类，用于读取文本文件。
 *
 * 常用读取方式：
 *
 * 1. read()
 *    - 每次读取一个字符
 *    - 返回字符的 Unicode 编码
 *    - 文件结束返回 -1
 *
 * 2. read(char[] buf)
 *    - 使用字符数组批量读取
 *    - 返回实际读取到的字符数量
 *    - 文件结束返回 -1
 *
 * 注意：
 * - FileReader 适合读取字符文件，可以避免字节流读取中文时乱码问题。
 * - 使用完流后需要调用 close() 关闭资源。
 * - 字符数组读取效率比单字符读取更高。
 *
 * </pre>
 *
 * @author pawamamama
 * @date 2026/8/3
 */
public class FileReader01 {
    public static void main(String[] args) {
        String path = "D:\\java_learning\\java_code\\chapter19\\src\\com\\pawamamama\\reader_\\txt_\\story.txt";
        int data = 0;
        //1.创建fileReader对象
        FileReader fileReader = null;
        try {
            fileReader = new FileReader(path);
            //循环读取 ,使用read方法（单个字符读取）
            while ((data = fileReader.read() )!= -1) {
                System.out.print((char) data);
            }
        } catch (IOException e) {
          e.printStackTrace();
        } finally {//清理资源
            if (fileReader != null) {
                try {
                    fileReader.close();
                } catch (IOException e) {}
            }
        }

    }
    @Test
    /**使用字符数组读取
     *
     */
    public void test01() {
        String path = "D:\\java_learning\\java_code\\chapter19\\src\\com\\pawamamama\\reader_\\txt_\\story.txt";
        int readLen = 0;
        char[] buf = new char[24];
        //1.创建fileReader对象
        FileReader fileReader = null;
        try {
            fileReader = new FileReader(path);
            //循环读取,使用read(buf)，返回实际读取到的字符数
            while ((readLen = fileReader.read(buf) )!= -1) {
                System.out.print(new String(buf,0,readLen));
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {//清理资源
            if (fileReader != null) {
                try {
                    fileReader.close();
                } catch (IOException e) {}
            }
        }
    }

}