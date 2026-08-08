package com.pawamamama.ObjectStream_;


import java.io.*;

/**
 * Class: ObjectOutStream_
 *
 * <pre>ObjectOutputStream使用，完成数据的序列化
 * </pre>
 *
 * @author pawamamama
 * @date 2026/8/8
 */

@SuppressWarnings({"all"})
public class ObjectOutStream_ {
    public static void main(String[] args) throws IOException {
        //1.序列化后保存的文件格式不是存文本，而是按照它的格式来保存
        String filePath = "D:\\java_learning\\java_code\\chapter19\\src\\com\\pawamamama\\ObjectStream_\\pawa\\data";

        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(filePath));

        //存放数据到filePath
        //自动装箱，实现了Serializable,可以序列化
        objectOutputStream.write(100);
        objectOutputStream.writeBoolean(true);
        objectOutputStream.writeChar('d');
        objectOutputStream.writeUTF("韩顺平");
        //保存dog对象
        objectOutputStream.writeObject(new Dog("吴俊希",18));
        objectOutputStream.close();

    }
}
//实现可序列化接口
class Dog  implements Serializable{
    private  String name;
    private  int age;
    public Dog(String name, int age) {
        this.name = name;
        this.age = age;
    }
}