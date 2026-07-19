package com.pawamamama.file_;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;

/**
 * Class: FileCreate
 * <p>
 * File 创建文件的三种方式：
 * <p>
 * 1. 根据完整路径创建 File 对象
 * <p>
 * 构造方法：
 * new File(String pathname)
 * <p>
 * 直接传入文件完整路径（包含文件名和后缀）。
 * File 对象只是对文件路径的封装，并不会真正创建文件。
 * 需要调用 createNewFile() 方法才会在磁盘中创建文件。
 * <p>
 * <p>
 * 2. 根据父目录路径 + 文件名创建 File 对象
 * <p>
 * 构造方法：
 * new File(String parent, String child)
 * <p>
 * parent：父目录路径
 * child：文件名
 * <p>
 * 将目录路径和文件名分开，更加清晰。
 * <p>
 * <p>
 * 3. 根据父 File 对象 + 子路径创建 File 对象
 * <p>
 * 构造方法：
 * new File(File parent, String child)
 * <p>
 * parent：File 类型的父目录对象
 * child：子路径或文件名
 * <p>
 * 适合已经存在 File 对象时继续拼接路径。
 * <p>
 * <p>
 * 注意：
 * <p>
 * File file = new File(...)
 * <p>
 * 只是创建 Java 中的 File 对象，
 * 并不会在磁盘创建文件。
 * <p>
 * 真正创建文件：
 * <p>
 * file.createNewFile();
 *
 * @author pawamamama
 * @date 2026/7/19
 */
public class FileCreate {
    public static void main(String[] args) {

    }

    // 方式一：完整路径
    @Test
    public void create1() throws IOException {
        String filePath = "D:\\java_learning\\java_code\\" +
                "chapter19\\src\\com\\pawamamama\\file_\\txt\\new1.txt";
        File file = new File(filePath);
        //创建文件方法
        file.createNewFile();
        System.out.println("创建成功");
    }

    //方式二 父路径 + 文件名
    @Test
    public void create2() throws IOException {
        String filePath = "D:\\java_learning\\java_code" +
                "\\chapter19\\src\\com\\pawamamama\\file_\\txt\\";
        String fileName = "new2.txt";
        //这里的file对象，在java中，只是一个对象
        File file = new File(filePath, fileName);
        //只有执行了create方法才真正的创建该文件
        file.createNewFile();//写入到硬盘对应位置
        System.out.println("创建成功");
    }

    //方式三 父路径 + 子路径
    // 方式三：根据父File对象 + 子文件路径创建 File 对象
    // new File(File parent, String child)
    //
    // parent：File类型的父目录对象
    // child：子路径或文件名
    //
    // 适合已经存在File对象时继续拼接路径
    @Test
    public void create3() throws IOException {

        String filePath = "D:\\java_learning\\java_code\\chapter19\\src\\com\\pawamamama\\file_\\txt\\";

        String fileName = "\\test\\new3.txt";

        // 创建父目录File对象
        File parentFile = new File(filePath);

        // 根据父File对象和子路径创建文件对象
        File file = new File(parentFile, fileName);

        // 创建文件
        file.createNewFile();

        System.out.println("创建成功");
    }
}