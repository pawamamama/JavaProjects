package com.pawamamama.chapter10Homerork;

/**
 * @author pawamamama
 */
public class HomeWork04 {
    public static void main(String[] args) {
        Cellphone cellphone = new Cellphone();
        //行为当参数传入，一次性行为  运行类型是这里的匿名内部类
        cellphone.testWork(new Computer() {
            @Override
            public double work(double n1, double n2) {
                return n1 + n2;
            }
        },19,100);
    }
}
interface Computer {
    double work( double n1, double n2);
}
class Cellphone   {
    //老师的

    //匿名内部类当参数传入
    public void testWork( Computer computer,double n1, double n2) {
                        //这里不报错是因为 传入的对象一定会是实现work方法
        double result =  computer.work(n1,n2);
        System.out.println(result);
    }

}