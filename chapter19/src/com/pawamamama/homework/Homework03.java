package com.pawamamama.homework;

import java.io.*;
import java.util.Properties;

/**
 * Class: Homework03
 *
 * <pre>
 * 使用 Properties 读取 dog.properties 配置文件，
 * 根据配置文件中的 name、age、color 属性创建 Dog 对象，
 * 将配置文件内容输出到控制台，
 * 使用 ObjectOutputStream 将 Dog 对象序列化到 dog.dat 文件，
 * 最后使用泛型方法进行反序列化，并自动推断返回对象的类型。
 *
 * 程序主要涉及：
 * 1. Properties 配置文件的读取
 * 2. String 转 int
 * 3. 根据配置创建对象
 * 4. ObjectOutputStream 对象序列化
 * 5. ObjectInputStream 对象反序列化
 * 6. Serializable 标记接口
 * 7. 泛型方法及泛型返回值
 * </pre>
 *
 * @author pawamamama
 * @date 2026/8/13
 */
@SuppressWarnings({"all"})
public class Homework03 {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Properties prop = new Properties();
        //1.载入配置文件
        prop.load(new FileReader("D:\\java_learning" +
                "\\java_code\\chapter19\\src\\com\\pawamamama\\homework\\dog.properties"));
        //2.使用配置文件创建对象
        Dog dog = new Dog(prop.getProperty("name"),
                Integer.parseInt(prop.getProperty("age"))
                , prop.getProperty("color"));
        //3输出到控制台
        prop.list(System.out);
        //4将创建的dog对象序列化到dog.dat文件
        String path = "D:\\java_learning\\java_code\\" +
                "chapter19\\src\\com\\pawamamama\\homework\\dog.dat";
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(path));
        oos.writeObject(dog);
        oos.close();

        Dog dog1 = test(path);//自动推断
        System.out.println(dog1.getClass());
        System.out.println(dog1.toString());

    }
    //5.编写一个方法实现反序列化，
    public static   <T> T test( String filePath) throws IOException, ClassNotFoundException {
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filePath));
        T object = (T) ois.readObject();
        ois.close();
        return object ;
    }
}
class Dog implements Serializable {
    String name;
    int age;
    String color;

    public Dog(String name, int age, String color) {
        this.name = name;
        this.age = age;
        this.color = color;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "dog{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", color='" + color + '\'' +
                '}';
    }
}