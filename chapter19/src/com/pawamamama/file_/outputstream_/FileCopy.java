package com.pawamamama.file_.outputstream_;

import com.pawamamama.file_.inputstream_.FileInputStream_;
import org.junit.jupiter.api.Test;

import java.io.*;

/**
 * Class: FileCopy
 *
 * <pre>文件拷贝
 * </pre>
 *
 * @author pawamamama
 * @date 2026/7/29
 */
@SuppressWarnings({"all"})
public class FileCopy {
    //完成文件拷贝
    //1.创建文件输入流,把文件读入到java程序
    //2.创建文件输出流，将读取到的文件数据写入到指定的位置
    //3.在完成程序时，应该是读取部分数据就写入到指定文件，使用循环
    public static void main(String[] args) {
        String filePath = "D:\\java_learning\\java_code\\chapter19\\src\\com\\pawamamama\\file_\\outputstream_\\txt_\\微信图片_20251030133755_62_34.jpg";
        String dest = "D:\\java_learning\\java_code\\chapter19\\src\\com\\pawamamama\\file_\\outputstream_\\txt_\\copy\\拷贝_20251030133755_62_34.jpg";
        FileInputStream fileInputStream = null;
        FileOutputStream fileOutputStream = null;

        try {
            //将要拷贝的文件读入到java
            fileInputStream = new FileInputStream(filePath);
            fileOutputStream = new FileOutputStream(dest);

            //读取文件，使用字节数组，提高读取效率
            byte[] buffer = new byte[1024];
            int readLen= 0;
            while ((readLen = fileInputStream.read(buffer)) != -1) {
                //读取到后通过fileOutputStream，边读边写
                fileOutputStream.write(buffer,0,readLen);
            }
            System.out.println("拷贝成功");
        } catch (IOException e) {
           e.printStackTrace();
        }finally {//关闭输入流和输出流
            if (fileInputStream != null) {
                try {
                    fileInputStream.close();
                } catch (IOException e) {}
            }
            if (fileOutputStream != null) {
                try {
                    fileOutputStream.close();
                } catch (IOException e) {}
            }
        }
    }

}