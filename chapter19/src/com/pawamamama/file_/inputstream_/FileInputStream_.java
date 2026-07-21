package com.pawamamama.file_.inputstream_;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.stream.Stream;

/**
 * Class: FileInputStream_
 *
 * <pre>演示 FileInputStream的使用(字节输入流 文件->内存)
 * </pre>
 *
 * @author pawamamama
 * @date 2026/7/21
 */
@SuppressWarnings({"all"})
public class FileInputStream_ {
    public static void main(String[] args) {

    }

    @Test
    //使用fead读取文件，效率低效
    public void readFile01() throws IOException {
        String filePath = "D:\\java_learning\\java_code\\chapter19\\src\\com\\pawamamama\\file_\\inputstream_\\txt_\\hello.txt";
        File file = new File(filePath);
        file.createNewFile();
        int readData = 0;
        //创建了 FileInputStream_ 对象，用于读取文件
        FileInputStream fileInputStream = new FileInputStream(filePath);
        try {
            //从该输入流读取一个字节的数据。如果没有输入可用，次方法将阻止
            //返回-1，表示读取完毕
            while ((readData = fileInputStream.read()) != -1) {
                System.out.print((char) readData);//转成char显示
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //关闭文件，释放资源
            fileInputStream.close();
        }
    }
    @Test
    //使用fead(byte[] b) 读取提高效率
    public void readFile02() throws IOException {
        String filePath = "D:\\java_learning\\java_code\\chapter19\\src\\com\\pawamamama\\file_\\inputstream_\\txt_\\hello.txt";
        int readLen = 0;
        //创建了 FileInputStream_ 对象，用于读取文件
        FileInputStream fileInputStream = new FileInputStream(filePath);
        //定义字节数组
        byte[] bytes = new byte[8];//一次读取8字节
        try {
            //从该输入流读取byte[8]字节的数据。如果没有输入可用，次方法将阻止
            //返回-1，表示读取完毕
            //读取正常，返回实际读取的字节数
            while ((readLen = fileInputStream.read(bytes)) != -1) {
                System.out.print(new String(bytes,0,readLen));
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //关闭文件，释放资源
            fileInputStream.close();
        }
    }
}