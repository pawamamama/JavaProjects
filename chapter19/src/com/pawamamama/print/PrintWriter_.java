package com.pawamamama.print;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Class: PrintWriter_
 *
 * <pre>
 * </pre>
 *
 * @author pawamamama
 * @date 2026/8/11
 */
@SuppressWarnings({"all"})
public class PrintWriter_ {
    public static void main(String[] args) throws IOException {
        //PrintWriter printWriter = new PrintWriter(System.out);
        PrintWriter printWriter = new PrintWriter(new FileWriter(
                "D:\\java_learning\\java_code\\" +
                        "chapter19\\src\\com\\pawamamama\\print\\wangjj.txt"));
        printWriter.print("nihao1wowo");
        printWriter.close();//必须刷新-才会写入（flush + 关闭流）
    }
}