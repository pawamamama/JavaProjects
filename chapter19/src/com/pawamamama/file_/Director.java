package com.pawamamama.file_;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * Class: Director
 *
 * <pre>
 * </pre>
 *
 * @author pawamamama
 * @date 2026/7/19
 */
@SuppressWarnings({"all"})
public class Director {
    static void main(String[] args) {

    }

    //判断 D:\java_learning\java_code\chapter19\src\com\pawamamama\file_\txt\
    // 是否存在 new1.txt，如果存在就删除
    @Test
    public void m1() {
        String filePath = "D:\\java_learning\\java_code\\chapter19\\src\\com\\pawamamama\\file_\\txt\\new1.txt";
        File file = new File(filePath);
        if (file.exists()) {
            if (file.delete()) {
                System.out.println(file.getName() + "删除成功");
            } else {
                System.out.println(file.getName() + "删除失败");
            }
        } else {
            System.out.println("文件不存在");
        }
    }
    //在java编程中目录也被当作对象
    @Test
    public void m2() {
        String filePath = "D:\\1111";
        File file = new File(filePath);
        if (file.exists()) {
            if (file.delete()) {
                System.out.println(file.getName() + "删除成功");
            } else {
                System.out.println(file.getName() + "删除失败");
            }
        } else {
            System.out.println("目录不存在");
        }
    }
    @Test
    //创建多级目录
    public void m3() throws IOException {
        String filePath = "D:\\1111\\a\\b\\c";
        File file = new File(filePath);
        if (file.exists()) {
            System.out.println("已存在");
        } else {
            if (file.mkdirs()) {
                System.out.println("创建成功");
            } else {
                System.out.println("创建失败");
            }
        }
    }
}