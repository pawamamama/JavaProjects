package com.pawamamama.collection_;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/**
 * Class: Iterator01 迭代器遍历
 *
 * <p>
 * 本类用于演示 {@link java.util.Iterator} 的基本概念与使用方式，
 * 以及如何通过迭代器遍历 Collection 集合中的元素。
 * </p>
 *
 * <h2>一、Iterator 基本概念</h2>
 * <ol>
 *     <li>
 *         Iterator（迭代器）是用于遍历 Collection 集合元素的对象，
 *         提供统一的遍历方式，避免直接操作集合内部结构。
 *     </li>
 *     <li>
 *         所有实现 {@link java.util.Collection} 接口的集合类，
 *         都提供 <code>iterator()</code> 方法，用于获取迭代器对象。
 *     </li>
 *     <li>
 *         Iterator 本身不存储数据，只负责遍历集合中的元素。
 *     </li>
 *     <li>
 *         Iterator 只能用于单向遍历集合，不能回退或随机访问。
 *     </li>
 * </ol>
 *
 * <h2>二、Iterator 执行原理</h2>
 *
 * <pre>
 * Iterator iterator = coll.iterator(); // 获取迭代器
 *
 * while (iterator.hasNext()) {        // 判断是否还有下一个元素
 *     Object obj = iterator.next();   // 取出当前元素并移动指针
 *     System.out.println(obj);
 * }
 * </pre>
 *
 * <h3>方法说明</h3>
 * <ul>
 *     <li><b>hasNext()</b>：判断集合中是否还有下一个元素</li>
 *     <li><b>next()</b>：
 *         <ul>
 *             <li>获取当前元素</li>
 *             <li>指针后移到下一个位置</li>
 *         </ul>
 *     </li>
 * </ul>
 *
 * <h2>三、特点总结</h2>
 * <ul>
 *     <li>用于遍历 Collection 集合</li>
 *     <li>不保存数据，仅作为访问工具</li>
 *     <li>单向遍历（只能从前往后）</li>
 *     <li>是 Java 集合框架的统一遍历标准</li>
 * </ul>
 *
 * <h2>四、适用范围</h2>
 * <ul>
 *     <li>List、Set 等 Collection 子类</li>
 *     <li>不适用于 Map（Map 需要 entrySet / keySet）</li>
 * </ul>
 *
 * @author pawamamama
 * @date 2026/6/15
 */
public class Iterator01 {
 /**
  * Iterator 使用注意事项示例
  *
  * <p>
  * 本示例用于说明 Iterator 在遍历集合时的正确使用方式，
  * 以及 hasNext() 与 next() 的配合关系。
  * </p>
  *
  * <h2>使用规则</h2>
  *
  * <ol>
  *     <li>
  *         在使用 next() 之前，必须先调用 hasNext() 进行判断。
  *         hasNext() 用于检查集合中是否还有下一个元素。
  *     </li>
  *
  *     <li>
  *         如果不先调用 hasNext()，直接调用 next()，
  *         当已经没有元素时会抛出异常：
  *         {@code NoSuchElementException}
  *     </li>
  * </ol>
  *
  * <h2>原因说明</h2>
  *
  * <p>
  * Iterator 是基于“游标(cursor)”的遍历机制。
  * hasNext() 负责判断 cursor 后面是否还有元素，
  * next() 负责返回当前元素并移动 cursor。
  * </p>
  *
  * <p>
  * 因此，如果没有 hasNext() 先做边界检查，
  * next() 就可能在“没有元素可取”的情况下被调用，
  * 从而导致异常。
  * </p>
  *
  * @author pawamamama
  */
 @SuppressWarnings({"all"})
 public static void main(String[] args) {

     Collection collection = new ArrayList<>();

     // 添加数据
     collection.add(new Book("Java基础", 50));
     collection.add(new Book("数据结构", 70));
     collection.add(new Book("算法导论", 120));
     collection.add("String");//都可以存放
     //直接使用toString，获取全部
     System.out.println("collection = "+collection);
     // 获取迭代器
     Iterator it = collection.iterator();

     // 遍历，一次取一个
     //快捷键是 itit 快速生成while迭代器遍历
     //显示所有的快捷键的快捷键ctrl + j
     while (it.hasNext()) {//判断还有没有数据
         //返回Object，运行期取决于存放的类型
         Object object = it.next();
         System.out.println(object);//这里发生动态绑定到运行类型的toString
     }
     //退出while 之后 这是 iterator迭代器，指向最后的元素，再去 next 会报异常
     Object o = it.next();//这里报异常NoSuchElementException
     //如果希望再次遍历 需要重置迭代器
     it = collection.iterator();//重置操作
     while (it.hasNext()) {
         Object next =  it.next();
         System.out.println(next);//这里发生动态绑定到运行类型的toString
     }


 }
}

class Book {
    String name;
    int price;

    public Book(String name, int price) {
        this.name = name;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Book{name='" + name + "', price=" + price + "}";
    }
}