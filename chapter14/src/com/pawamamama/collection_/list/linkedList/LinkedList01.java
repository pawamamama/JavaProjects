package com.pawamamama.collection_.list.linkedList;
/**
 * Class: LinkedList01 双向链表模拟
 *
 * <pre>
 * 学习内容：
 * 1. 手动创建 Node 节点。
 * 2. 使用 next、prev 将多个节点连接成双向链表。
 * 3. 从头节点(head)遍历到尾节点(tail)。
 * 4. 从尾节点(tail)遍历到头节点(head)。
 * 5. 在链表尾部添加新节点。
 * 6. 在指定节点之间插入新节点。
 *
 * 底层思想：
 * - Node.item：存放真正的数据。
 * - Node.next：指向后继节点。
 * - Node.prev：指向前驱节点。
 * - 双向链表通过修改节点引用完成插入、删除操作，
 *   不需要像数组一样移动大量元素。
 *
 * 本例演示：
 * java <-> tom <-> pawa
 *                     │
 *                     ▼
 * 添加：
 * java <-> tom <-> pawa <-> lll
 *
 * 插入：
 * java <-> tom <-> pawa <-> aaa <-> lll
 * </pre>
 *
 * @author pawamamama
 * @date 2026/6/18
 */
public class LinkedList01 {
    public static void main(String[] args) {
        Node java = new Node("java");
        Node tom = new Node("tom");
        Node pawa = new Node("pawa");
        //链接三个节点，形成双向链表
        // java-> tom ->pawa->lll
        java.next = tom;
        tom.next = pawa;
        //pawa -> tom -> java
        pawa.prev = tom;
        tom.prev = java;

        Node first = java;//first 引用指向java,就是双向链表的头节点
        Node list = pawa;//list 引用指向pawa,就是双向链表的尾节点

        //短暂获取头节点
        //头->尾
        Node newFirst = first;
        while (newFirst != null) {
            System.out.println(newFirst);
            newFirst = newFirst.next;
        }
        //尾->头
        Node newLast = list;
        while (newLast != null) {
            System.out.println(newLast);
            newLast = newLast.prev;
        }
        //添加一个对象
        Node lll = new Node("lll");
        list.next =lll;
        lll.prev = list;
        list = lll;
        System.out.println("==========================");
        System.out.println("==========================");
        System.out.println("==========================");
        //从 next 顺序添加
        Node newFirst2 = first;
        while (true) {
            if (newFirst2 == null) {
                break;
            }
            System.out.println(newFirst2);
            newFirst2 = newFirst2.next;
        }
        // 从 pawa 和 lll 之间插入数据
        System.out.println("==========================");
        System.out.println("==========================");
        System.out.println("==========================");
        System.out.println("==========================");
        Node aaa = new Node("aaa");
        pawa.next = aaa;
        aaa.next = lll;
        aaa.prev =pawa;
        lll.prev =aaa;
        Node newFirst3 = first;
        while (true) {
            if (newFirst3 == null) {
                break;
            }
            System.out.println(newFirst3);
            newFirst3 = newFirst3.next;
        }


    }
}
/**
 * 双向链表节点
 *
 * item：存储数据
 * next：指向下一个节点
 * prev：指向上一个节点
 */
class Node {
    public Object item;//真正存放数据的地方
    public Node next;//指向下一个节点
    public Node prev;//指向上一个节点

    public Node(Object item) {
        this.item = item;
    }

    @Override
    public String toString() {
        return "Node name = " + item;
    }
}