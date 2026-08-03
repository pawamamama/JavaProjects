package com.pawamamama.writer_;

import java.io.FileWriter;
import java.io.IOException;

/**
 * Class: FileWriter
 *
 * <pre>
 * </pre>
 *
 * @author pawamamama
 * @date 2026/8/3
 */
@SuppressWarnings({"all"})
public class FileWriter01 {
    public static void main(String[] args) {
        String path  = "D:\\java_learning\\java_code\\chapter19\\src\\com\\pawamamama\\writer_\\txt_\\note.txt";
        //创建fileWriter对象
        FileWriter fw = null;
        try {
            fw = new FileWriter(path,true);
            //1.写入单个字符
            fw.write((int)'王');
            //2.写入指定数组
            char[] chars = null;
            String line = "124i9wjewan王卫星";
            chars = line.toCharArray();//转成数组
            fw.write(chars);
            //3.写入指定数组的指定部分
            fw.write(chars,0,5);
            //4.写入整个字符串
            fw.write(line);
            //5.写入整个字符串的指定部分
            fw.write(line,0,5);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            //对应FileWriter,一定要关闭流，或者flush才能真正把数据写入到文件
            /**
             * 原理：
             * FileWriter 写入数据时，不一定会立即写入磁盘，而是先放入缓冲区。
             *
             * 调用 close() 或 flush() 时，会执行真正写入文件的方法：
             * this.writeBytes()
             *
             * writeBytes() 内部会调用：
             * this.out.write()本质还是文件输出流
             *
             * 最终通过底层输出流将数据写入文件。
             *
             * 区别：
             * flush()：刷新缓冲区，把数据写入文件，但流还可以继续使用。
             * close()：关闭流，同时会自动执行 flush()，把剩余数据写入文件，然后释放资源。
             */
            if (fw != null) {
                try {
                   fw.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        System.out.println("程序结束");
    }
}