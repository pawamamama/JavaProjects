package com.pawamamama.excption_.try_catch_;

/**
 * @author pawamamama
 * 1.多个catch语句细节
 * 2.可以有多个catch语句，捕获不同的异常，进行不同的业务处理，要求父类异常在后，子类异常在前
 * 比如 exception 在后 NullPointerException在前，如果发生异常，只会匹配一个catch
 */

public class TryCatchDetail04 {
    public static void main(String[] args) {
        //1.如果try代码块可能有多个异常
        //2.可以使用多个catch，分别捕获不同的异常相应处理
        //3.要求父类异常在后，子类异常在前
        try {
            Person person = new Person();
            person = null;
            System.out.println(person.getName());//空指针异常
            int n1 = 10;
            int n2 = 0;
            int res = n1 / n2;//算数异常
            //也可以单独捕获
        } catch (NullPointerException e) {
            System.out.println("空指针异常" + e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("算数异常" + e.getMessage());
        } catch (Exception e) {//这个Exception可包含前面两个异常// 是其子类
            System.out.println(e.getMessage());
        } finally {
        }
    }

}

class Person {
    private String name = "jack";

    public String getName() {
        return name;
    }
}