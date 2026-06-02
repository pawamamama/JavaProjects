import java.util.Scanner;

public class Arraytest {
    //方法
    public static void main(String[] args) {

        MyTool mytool = new MyTool();
        int[] arr = {1, 22, 1, 22, 33, 22, 44, 43};
        mytool.bubble(arr);
        for (int i = 0; i < arr.length; i++) {

            System.out.print(arr[i] + "\t");

        }
        // idea 当我们run一个文件时 会先编译成.class文件 -> 在运行
        //快捷键分配 变量名
        Scanner scanner = new Scanner(System.in);//.var
       // new Scanner(System.in).var
        MyTool myTool = new MyTool();

    }
    //格式化代码 ctrl + alt +l
}//查看类的继承关系 ctrl + h

class Person {
    String name;
    int age;
    //构造器快捷键 Alt + Insert

    public Person() {
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Person(String name) {
        this.name = name;
    }
}

class MyTool {
    public void bubble(int[] arr) {
        //冒泡排序
        int tmp = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    tmp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = tmp;
                }
            }
        }
    }
}
