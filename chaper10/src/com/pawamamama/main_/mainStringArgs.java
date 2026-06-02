package com.pawamamama.main_;

public class mainStringArgs {

    // args：接收命令行参数
    public static void main(String[] args) {

        // 遍历并输出参数
        for (int i = 0; i < args.length; i++) {
            System.out.println(args[i]);
        }
    }
}