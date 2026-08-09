package com.pawamamama.standard_;

import java.io.InputStream;
import java.util.Scanner;

/**
 * Class: InputAndOutput
 *
 * <pre>
 * 演示标准输入流System.in和标准输出流System.out的使用
 *
 * System.in:
 *      标准输入流，默认连接键盘，属于InputStream字节输入流
 *
 * System.out:
 *      标准输出流，默认连接显示器，属于PrintStream打印流
 *
 * Scanner可以基于System.in读取用户输入的数据
 * </pre>
 *
 * @author pawamamama
 * @date 2026/8/9
 */
@SuppressWarnings({"all"})
public class InputAndOutput {
    public static void main(String[] args) {

        // 查看System.in的运行类型
        // System.in表示标准输入流，默认从键盘读取数据
        System.out.println(System.in.getClass());

        // 查看System.out的运行类型
        // System.out表示标准输出流，默认输出到控制台
        System.out.println(System.out.getClass());

        // 标准输出
        System.out.println("请输入你的名字:");

        // 创建Scanner对象
        // Scanner底层使用System.in读取键盘输入
        Scanner scanner = new Scanner(System.in);

        // 接收用户输入
        String name = scanner.next();

        // 标准输出显示结果
        System.out.println("你好:" + name);

        scanner.close();
    }
}