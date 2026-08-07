package com.pawamamama.reader_;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * Class: BufferadReader_
 *
 * <pre>字符包装流使用
 * </pre>
 *
 * @author pawamamama
 * @date 2026/8/6
 */
@SuppressWarnings({"all"})
public class BufferadReader_ {
    public static void main(String[] args) {
        String filePath = "D:\\java_learning\\java_code\\chapter19\\src\\com\\pawamamama\\reader_\\txt_\\story.txt";
        BufferedReader bufferedReader = null;
        try {
            bufferedReader = new  BufferedReader(new FileReader(filePath));
            //读取
            String line;//按行读取
            /**
             * 1.readLine 按行读取
             * 2.当返回null时，表示读取完毕
             */
            while ((line = bufferedReader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                //关闭包装流里面会in.close()就是关闭字节输入流，联动关系
                bufferedReader.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

    }

}