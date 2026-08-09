package com.pawamamama.ObjectStream_;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

/**
 * Class: ObjectIntputStream_
 *
 * <pre>
 * </pre>
 *
 * @author pawamamama
 * @date 2026/8/8
 */
@SuppressWarnings({"all"})
public class ObjectIntputStream_ {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        String filePath = "D:\\java_learning\\java_code\\chapter19\\src\\com\\pawamamama\\ObjectStream_\\pawa\\data";
        ObjectInputStream objectInputStream
                = new ObjectInputStream(new FileInputStream(filePath));
        //读取（反序列化）的顺序需要和保存数据一致
        System.out.println(objectInputStream.readInt());
        System.out.println(objectInputStream.readBoolean());
        System.out.println(objectInputStream.readChar());
        System.out.println(objectInputStream.readUTF());
        Object o = objectInputStream.readObject();
        System.out.println("运行类型" + o.getClass());
        System.out.println(o);//底层obj-> Dog
        //修改类要重新生成序列化文件，不修改报错，内置有版本信息，如果修改了会变动
        //1.调用dog的方法,需要向下转型
        //2.需要我们将dog类定义或者引用,才能向下转型,或者此类pubilc
        com.pawamamama.ObjectStream_.Dog dog1 = (Dog) o;
        System.out.println(dog1.getName());
        objectInputStream.close();
    }
}