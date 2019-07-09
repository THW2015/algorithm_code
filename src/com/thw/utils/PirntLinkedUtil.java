package com.thw.utils;

import com.thw.common.Node;

/**
 * 打印链表工具类
 * @author 谭皓文
 * @date 2019/7/9 22:27
 */
public class PirntLinkedUtil {

    public static void printLinked (Node head) {
        if(head == null) {
            throw new RuntimeException("the head is null");
        }
        while (head.next != null) {
            System.out.print(head.value + "-->");
            head = head.next;
        }
        System.out.print(head.value);
        System.out.println();
    }

    //test
    public static void main(String[] args) {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        node1.next = node2;
        node2.next = node3;
        PirntLinkedUtil.printLinked(node1);

    }
}
