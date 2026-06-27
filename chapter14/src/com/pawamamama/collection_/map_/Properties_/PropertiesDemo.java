package com.pawamamama.collection_.map_.Properties_;
import java.util.Properties;
/**
 * Properties类说明
 *
 * <p>1. Properties类继承自Hashtable，并实现了Map接口，
 *    本质上以键值对（key-value）形式存储数据。</p>
 *
 * <p>2. 其使用特点与Hashtable类似：
 *    - 不允许null key或null value (都抛空指针异常)
 *    - value 允许被替换
 *    - 线程安全（方法带synchronized特性）
 *    - 底层基于哈希表结构</p>
 *
 * <p>3. Properties类最大的特点是支持与配置文件（.properties）进行交互，
 *    可以从xxx.properties文件中加载数据到Properties对象，
 *    也可以将数据写回文件。</p>
 *
 * <p>4. 在实际开发中，xxx.properties文件通常作为配置文件使用，
 *    常用于存储数据库连接信息、系统参数等配置。
 *    该知识点常用于IO流相关案例。</p>
 *
 * @author study note
 * @version 1.0
 */
@SuppressWarnings({"all"})
public class PropertiesDemo {
    public static void main(String[] args) {
        Properties prop = new Properties();

        // 1. 存数据（key-value）
        prop.setProperty("username", "root");
        prop.setProperty("password", "123456");
        prop.setProperty("url", "jdbc:mysql://localhost:3306/test");

        // 2. 取数据
        System.out.println(prop.get("username"));
        System.out.println(prop.getProperty("username"));
        System.out.println(prop.getProperty("password"));
        System.out.println(prop.getProperty("url"));

        //3. 删除数据
        prop.remove("username");
        System.out.println(prop);
        //4. 修改
        prop.put("url",1212121212);
        System.out.println(prop);
        System.out.println("==============================");
        System.out.println("==============================");
        System.out.println("==============================");

        // 3. 遍历
        for (String key : prop.stringPropertyNames()) {
            System.out.println(key + " = " + prop.getProperty(key));
        }
    }
}