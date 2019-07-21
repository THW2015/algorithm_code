package com.thw.two;

import com.thw.common.DoubleNode;
import com.thw.common.Node;
import com.thw.utils.DoubleLinkedBuilderUtil;
import com.thw.utils.LinkedBuilderUtil;
import com.thw.utils.PrintLinkedUtil;

/**
 * 反转单链表和双链表
 * @author 谭皓文
 * @date 2019/7/21 12:45
 */
public class ReverseList {
//    单链表
    public static Node doReverseList(Node head) {
        if(head == null || head.next == null) {
            return head;
        }
        Node pre = null;
        Node now = head;
        Node next = null;
        while(now != null) {
            next = now.next;
            now.next = pre;
            pre = now;
            now = next;
        }
        return pre;
    }

//    双链表
    public static DoubleNode doReverseDoubleList(DoubleNode head) {
        if(head == null || head.next == null) {
            return head;
        }

        DoubleNode pre = null;
        DoubleNode now = head;
        DoubleNode next = null;
        while(now != null) {
            next = now.next;
            now.next = pre;
//            if(pre != null) {
//                pre.last = now;
//            }
            now.last = next;
            pre = now;
            now = next;
        }
        return pre;
    }


//    test
    public static void main(String[] args) {
        Node node1 = LinkedBuilderUtil.buildLinked(new int[]{1, 2, 3});
        Node reverseNode = ReverseList.doReverseList(node1);
        PrintLinkedUtil.printLinked(reverseNode);

        DoubleNode node2 = DoubleLinkedBuilderUtil.buildDoubleLinked(new int[]{1, 2, 3});
        DoubleNode reverseDoubleNode = ReverseList.doReverseDoubleList(node2);
        PrintLinkedUtil.printDoubleLinked(reverseDoubleNode);
    }

}
