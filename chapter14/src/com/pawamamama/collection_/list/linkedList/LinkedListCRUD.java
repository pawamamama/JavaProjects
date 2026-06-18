package com.pawamamama.collection_.list.linkedList;

import java.util.Iterator;
import java.util.LinkedList;

/**
 * Class: LinkedListCRUD LinkedList 常用 CRUD 操作及源码分析
 *
 * <pre>
 * 学习内容：
 * 1. add(E e)      尾部添加元素。
 * 2. remove()      删除头节点。
 * 3. remove(int)   根据索引删除节点。
 * 4. remove(Object) 根据对象删除节点。
 * 5. set(index,E)  修改指定节点的数据。
 * 6. get(index)    获取指定索引处的数据。
 *
 * LinkedList 底层特点：
 * - 底层采用双向链表实现。
 * - 每个节点(Node)包含：
 *      item：存放数据。
 *      next：指向后继节点。
 *      prev：指向前驱节点。
 *
 * 源码理解：
 * 1. add() 调用 linkLast()，默认采用尾插法。
 * 2. 删除节点时不会移动元素，仅修改前后节点的引用关系。
 * 3. unlinkFirst() 删除头节点时：
 *      - 保存第一个节点的数据。
 *      - first 指向原 first.next。
 *      - next.prev = null，保持链表完整。
 *      - 将删除节点的引用置空，帮助 GC 回收。
 * 4. get(index) 会根据 index 是否位于前半部分，
 *    决定从 first 或 last 开始遍历，提高查找效率。
 * 5. 遍历可以是迭代的方式
 *
 * 注意：
 * LinkedList 擅长插入、删除操作，
 * 不适合频繁随机访问(index)，因为需要沿着 next 或 prev 逐个节点遍历。
 * </pre>
 *
 * @author pawamamama
 * @date 2026/6/18
 */
@SuppressWarnings({"all"})
public class LinkedListCRUD {
    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.add(1);
        list.add(2);
        System.out.println("list"+list);
        //
        //list.remove();//默认删除第一个
     /*   System.out.println("list"+list);
        list.remove(0);//根据索引删除
        Integer i = 1;
        list.remove(i);//进行比较删除指定对象*/

        //修改某个节点的对象
        list.set(0,"wangweixin");
        //得到节点对象、
        System.out.println(list.get(0));
        //遍历方式可以是迭代器
        Iterator itr = list.iterator();
        while (itr.hasNext()) {
            Object o = itr.next();
            System.out.println();
        }
        /*源码解读
        LinkedList list = new LinkedList();
        1. public LinkedList() {}空构造器
        2. list 属性 first =null last =null
        3. public boolean add(E e) {
            linkLast(e);//进入这个方法直接从尾部添加
           return true;
        4.将新的节点，加入到新的双向链表的最后,这里通过 next 引用将新节点连接到链表尾部。
        void linkLast(E e) {
        final Node<E> l = last;//这个是给newNode.prve的，因为next的尾部是prve的头部
                                      prev 方向的：新元素.prve=尾元素
                                      item = e ,
                                      next = null
        final Node<E> newNode = new Node<>(l, e, null);
        last = newNode;//从尾部添加所以要重置last
        if (l == null)//说明 last 没有数值，变相说明 是第一次添加所以 头尾都是 newNode
            first = newNode;
        else
            l.next = newNode;//有数就链接一下next方向的链表，上一个元素.next = 添加的元素
        size++;
        modCount++;
    }
    }
        */
      /*private E unlinkFirst(Node<E> f) {
        // assert f == first && f != null;
        final E element = f.item;//返回删除的数据
        final Node<E> next = f.next;//获取frist 的 下一个指向
        f.item = null;
        f.next = null; // help GC帮助 GC 回收已脱离链表的节点。
        first = next;//删除next头first得指向成原先的frist.next 下一个指向
        if (next == null)//判断删除后是否是空链表
            last = null;//是就把last 也置空
        else
            next.prev = null;//不是就把 prev 方向置空为了链表完整性，也为了断掉 删除的Node 完成gc 回收
        size--;
        modCount++;
        return element;
    }*/
    }

}