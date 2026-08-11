package com.pawamamama.transformation;


import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * Class: CodeQuestion
 *
 * <pre> 编码问题
 * </pre>
 *
 * @author pawamamama
 * @date 2026/8/11
 */
@SuppressWarnings({"all"})
public class CodeQuestion {
    public static void main(String[] args) throws IOException {
        //读取a.txt
        String path = "D:\\java_learning\\java_code\\chapter19\\src\\com\\pawamamama\\transformation\\a.txt";
        BufferedReader reader = new BufferedReader(new FileReader(path));
        //默认是utf-8读取，如果文件不是utf-8，会出现乱码
        String s = reader.readLine();
        System.out.println(s);
        reader.close();
    }
}