package com.pawamamama.collection_.set.hashset_;

/**
 * Class: HashSetStructure 模拟 HashSet 的底层（HashMap的底层结构）
 *
 * <pre>
 * </pre>
 *
 * @author pawamamama
 * @date 2026/6/19
 */
public class HashSetStructure {
    public static void main(String[] args) {
        //1.创建一个数组
        Node[] table = new Node[16];
        //2.创建节点
        Node john = new Node("john",null);

        table[2] = john;

        Node jack = new Node("jack", null);

        //形成链表
        john.next = jack;
        //
        Node rose = new Node("rose", null);
        //形成链表
        jack.next = rose;

    }

}

class Node {//节点，存储数据，可以指向下一个节点，形成链表
    Object item;
    Node next;//指向下一个节点

    public Node(Object item, Node next) {
        this.item = item;
        this.next = next;
    }
}