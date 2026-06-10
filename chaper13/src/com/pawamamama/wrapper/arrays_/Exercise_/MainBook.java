package com.pawamamama.wrapper.arrays_.Exercise_;

import com.sun.org.apache.xpath.internal.operations.Bool;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/**
 * MainBook Comparator接口定制排序练习
 *
 * <pre>
 * 1.Comparator接口
 *      1.1 Comparator用于定制比较规则
 *      1.2 compare(o1,o2)
 *              返回值 >0 认为o1大于o2
 *              返回值 <0 认为o1小于o2
 *              返回值 =0 认为两者相等
 *
 * 2.接口编程思想
 *      2.1 排序算法负责排序流程
 *      2.2 Comparator负责比较规则
 *      2.3 两者解耦，提高代码复用性
 *
 * 3.定制排序
 *      3.1 按价格升序排序
 *          Double.compare(price1,price2)
 *
 *      3.2 按书名长度降序排序
 *          Integer.compare(len2,len1)
 *
 * 4.冒泡排序结合Comparator
 *      bubbleSort2(Book[],Comparator)
 *          将比较行为抽象为接口
 *          不同排序需求只需传入不同Comparator实现
 *          无需修改排序算法本身
 *
 * 5.Arrays.sort()
 *      Arrays.sort(数组,Comparator)
 *          JDK内部完成排序
 *          用户只需提供比较规则
 *
 * 6.体会
 *      面向接口编程：
 *      定义规范(Comparator)
 *      实现规则(compare)
 *      调用统一API(Arrays.sort)
 *      达到算法与业务逻辑分离的目的
 * </pre>
 *
 * @author pawamamama
 * @since 2026/6/10
 */
public class MainBook {
    public static void main(String[] args) {
        Book[] books = new Book[5];
        books[0] = new Book("如何追朋友",99);
        books[1] = new Book("如何让朋友女装",89);
        books[2] = new Book("如何劝说朋友当小南娘",230);
        books[3] = new Book("朋友真的好香",1673);
        books[4] = new Book("想吃小男娘肉棒",73);
        Scanner myScanner = new Scanner(System.in);
        bubbleSort2(books,new Comparator<Book>() {
            @Override
            public int compare(Book o1, Book o2) {
                //把数据转换成包装类
               double oo1  = o1.getPrice();
               double oo2  = o2.getPrice();
                //去包装类对比
             return Double.compare(oo1,oo2  );
            }
        });
    /*  for (Book book : books) {
          System.out.println(book.toString());
      }*/
      //按照书名长度
        Arrays.sort(books,new Comparator() {
            @Override
            //其实可以用 new Comparator<Book>()的但是没学
            public int compare(Object o1, Object o2) {
                //把书名长度进行数字化
                Integer oo1 = ((Book)o1).getName().length();
                Integer oo2 = ((Book)o2).getName().length();
                return Integer.compare(oo2,oo1);

            }
        });
      for (Book book : books) {
          System.out.println(book.toString());
      }
    }
    //结合冒泡进行定制排序
    public  static void bubbleSort2(Book[] books, Comparator c){
        //声明Book引用
        Book temp;
        for(int i=0;i<books.length-1;i++){
            for(int j=0;j<books.length-1-i;j++){
                //把要比较的对象传入，通过匿名内部类进行比较操作完成之后决定排序的升降序
                if(c.compare(books[j],books[j+1])>0){
                    temp = books[j];
                    books[j] = books[j+1];
                    books[j+1] = temp;
                }
            }
        }
    }

}