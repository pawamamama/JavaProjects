package com.pawamamama.file_.outputstream_;

import org.junit.jupiter.api.Test;

import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Class: FileOutputStream
 *
 * <pre>
 * </pre>
 *
 * @author pawamamama
 * @date 2026/7/21
 */
@SuppressWarnings({"all"})
public class FileOutputStream01 {
    public static void main(String[] args) {

    }

    /**
     * 演示使用FileOutputStream 将数据写入到文件中
     * 如果该文件不存在，则创建该文件
     *
     */
    @Test
    public void writeFile01() throws IOException {
        String filePath = "D:\\java_learning\\java_code\\chapter19\\src\\com\\pawamamama\\file_\\outputstream_\\txt_\\a1.txt";
        //得到了 FileOutputStream对象
        //
        FileOutputStream fileOutputStream = null;
        try {
            //这是覆盖方式，会覆盖原来的内容
            //fileOutputStream = new FileOutputStream(filePath);
            //这是追加方式
            fileOutputStream = new FileOutputStream(filePath,true);
            //写入一个字节
            //fileOutputStream.write('a');
            //写入字符串
            //getBytes()将String转成byte数组
            //fileOutputStream.write("wangwang".getBytes());
            //写byte数组中的特定位置
            String str = "wangwang";
            fileOutputStream.write("wnagwangajafshdadsfjkdf".getBytes());
            fileOutputStream.write("wnagwangajafshdadsfjkdf".getBytes());

        } finally {
            fileOutputStream.close();
        }
    }
}