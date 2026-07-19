package com.pawamamama.file_;

import org.junit.jupiter.api.Test;

import java.io.File;

/**
 * Class: FileInformation
 *
 * <pre>
 *     用方法获取文件信息
 * </pre>
 *
 * @author pawamamama
 * @date 2026/7/19
 */
@SuppressWarnings({"all"})
public class GetFileInformation {
     public static void main(String[] args) {

    }
    //获取文件信息
    @Test
    public void info() {
         //获取文件对象
        File file = new File("D:\\java_learning\\java_code\\chapter19\\src\\com\\pawamamama\\file_\\txt\\new1.txt");

        //调用相应方法得到对应信息
        System.out.println("文件名 = " + file.getName());
        System.out.println("文件绝对路径 = " + file.getAbsoluteFile());
        System.out.println("文件父级目录 = " + file.getParent());
        System.out.println("文件大小 = " + file.length());
        System.out.println("文件是否存在 = " + file.exists());
        System.out.println("是不是一个文件 = " + file.isFile());
        System.out.println("是不是一个目录 = " + file.isDirectory());

    }
}