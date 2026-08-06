package com;

import sun.util.locale.provider.JRELocaleProviderAdapter;

/**
 * Class: Reader_
 *
 * <pre>处理流模拟
 * </pre>
 *
 * @author pawamamama
 * @date 2026/8/6
 */
@SuppressWarnings({"all"})
/**
 * 做成处理流/包装流
 */
class BufferedReader_ extends Reader_ {
    private Reader_ reader;//属性是 Reader类型

    public BufferedReader_(Reader_ reader) {
        this.reader = reader;
    }
    //可扩展,多次读取文件
    public void readFiles(int num) {
        for (int i = 0; i <num ; i++) {
            reader.readFile();
        }
    }
    //扩展，批量处理字符串数据
    public void readStrings(int num) {
        for (int i = 0; i <num ; i++) {
            reader.readString();
        }
    }
    //还可以使用read方法同一管理批量读取
    public void read(int num) {
        for (int i = 0; i < num ; i++) {
            reader.read();
        }
    }
}

public  abstract class Reader_ {//抽象类
    //抽象方法，交给子类去实现
    public  void readFile(){};
    public  void readString(){};
    public void read(){};
}
//节点流
class FileReader_ extends Reader_ {
    public void readFile() {
        System.out.println("进行读取文件");
    }
}
//节点流
class StringReader_ extends Reader_ {
    public void readString() {
        System.out.println("字符串读取");
    }
}
