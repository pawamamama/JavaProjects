package com.pawamamama.ObjectStream_;


import java.io.*;

/**
 * Class: ObjectOutStream_
 * <pre>
 * ObjectOutputStream使用，完成数据的序列化
 *
 * 1) 读写顺序要一致
 * 2) 要求序列化或反序列化对象，需要实现 Serializable 接口
 * 3) 序列化的类中建议添加 SerialVersionUID，提高版本兼容性
 * 4) 序列化对象时，默认将里面所有属性进行序列化，
 *    但除了 static 或 transient 修饰的成员
 * 5) 序列化对象时，要求里面属性的类型也需要实现序列化接口
 * 6) 序列化具有可继承性，如果父类已经实现 Serializable，
 *    那么子类默认也实现了序列化
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
        objectOutputStream.writeInt(100);
        objectOutputStream.writeBoolean(true);
        objectOutputStream.writeChar('d');
        objectOutputStream.writeUTF("韩顺平");
        //保存dog对象
        objectOutputStream.writeObject(new Dog("吴俊希", 18, "红色", "江苏狗"));
        objectOutputStream.close();

    }
}

//实现可序列化接口
class Dog implements Serializable {
    private String name;
    private int age;
    // static修饰，属于类，不属于对象，序列化时不会保存
    private static String nation;
    // transient修饰，表示该属性不会参与序列化
    private transient String color;
    //序列化对象时，要求里面属性的类型也需要实现序列化接口
    private Master master = new Master();
    //序列版本号,可以提高序列化的兼容性，
    private static final long serialVersionUID = 1l;

    public Dog(String name, int age, String color, String nation) {
        this.name = name;
        this.age = age;
        this.color = color;
        this.nation = nation;
    }

    @Override
    public String toString() {
        return "Dog{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", color='" + color + '\'' +
                ", nation='" + nation + '\'' +
                ", master=" + master +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
class Master  implements Serializable {

}