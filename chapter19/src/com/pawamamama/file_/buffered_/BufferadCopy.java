package com.pawamamama.file_.buffered_;
import javax.imageio.IIOException;
import java.io.*;

/**
 * Class: BufferadCopy
 *
 * <pre>
 * </pre>
 *
 * @author pawamamama
 * @date 2026/8/8
 */
@SuppressWarnings({"all"})
public class BufferadCopy {
    public static void main(String[] args){
        String srcFilePath = "D:\\java_learning\\java_code\\chapter19\\src\\com\\pawamamama\\file_\\buffered_\\copy\\微信图片_20251030133755_62_34.jpg";
        String destPath = "D:\\java_learning\\java_code\\chapter19\\src\\com\\pawamamama\\file_\\buffered_\\copy\\拷贝微信图片_20251030133755_62_34.jpg";

        //创建
        BufferedInputStream bufferedInputStream = null;
        BufferedOutputStream bufferedOutputStream = null;

        try {
            bufferedInputStream = new BufferedInputStream(new FileInputStream(srcFilePath));
            bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(destPath) );

            //循环读取写入
            byte[] buffer = new byte[1024];
            int len;//读取了多大的长度
            while ((len = bufferedInputStream.read(buffer)) != -1){
                bufferedOutputStream.write(buffer,0,len);//写入
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //关闭外层流
            if (bufferedInputStream != null) {
                try {
                    bufferedInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (bufferedOutputStream != null) {
                try {
                    bufferedOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}