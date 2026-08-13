package com.pawamamama.properties_;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

/**
 * Class: Properties02
 *
 * <pre>
 * </pre>
 *
 * @author pawamamama
 * @date 2026/8/13
 */
@SuppressWarnings({"all"})
public class Properties02 {
    public static void main(String[] args) throws IOException {
        //使用Properties 读取
        //1.创建对象
        Properties properties = new Properties();
        //2.加载
        properties.load(new FileReader("D:\\java_learning\\java_code\\chapter19\\" +
                "src\\com\\pawamamama\\properties_\\mysql.properties"));
        //3.k-v 显示到控制台
        properties.list(System.out);
        //4.根据key 获取 value
        String user = properties.getProperty("user");
        String password = properties.getProperty("pwd");
        System.out.println(user + ":" + password);
    }

}