package com.pawamamama.print;

import java.io.IOException;
import java.io.PrintStream;

/**
 * Class: PrintStream_
 *
 * <pre>
 * </pre>
 *
 * @author pawamamama
 * @date 2026/8/11
 */
@SuppressWarnings({"all"})
public class PrintStream_ {
    public static void main(String[] args) throws IOException {
        PrintStream out  = System.out;
        //情况下，输出位置是标准输出,即显示器
        /* public void print(String s) {
        if (s == null) {
            s = "null";
        }
        write(s);
    }*/
        out.print("Hello World");
        //因为print底层使用的是write ，所以我们可以直接使用write进行打印输出
        out.write("wnagwei新".getBytes());
        out.close();
        //也可以修改打印流输出的位置/设备
        /*public static void setOut(PrintStream out) {
        checkIO();
        setOut0(out); //native方法修改了out
    }*/
        System.setOut(new PrintStream(
                "D:\\java_learning\\java_code\\" +
                        "chapter19\\src\\com\\pawamamama\\print\\11.txt"));
        System.out.println("我是直至下");//打印到文件
    }
}