package com.thw.two;

import com.thw.common.Node;
import com.thw.utils.LinkedBuilderUtil;
import com.thw.utils.PrintLinkedUtil;

/**
 * 将单链表每K个节点逆序
 * @author 谭皓文
 * @date 2019/7/29 0:25
 */
public class Code_2_11_ReverseKNode {

    public static Node reverseKNode(Node head, int k) {
        if(head == null || k <= 1) {
            return head;
        }
        Node cur = head;
        Node left = null, right = null, start = head, end = null;
        int c = 0;
        int first = 0;
        while(cur != null) {
            if(c == k) {
                reverse(left, start, end, right);
                c = 0;
                left = start;
                start = start.next;
                head = ++first == 1 ? end : head;
            }
            end = cur;
            right = cur.next;
            cur = cur.next;
            c++;
        }
        return head;
    }

    private static void reverse(Node left, Node start, Node end, Node right) {
        Node pre = left, cur = start, next;
        while (cur != right) {
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        if(left != null) {
            left.next = pre;
        }
          start.next = right;
    }

//    test
    public static void main(String[] args) {
        Node head = LinkedBuilderUtil.buildLinked(new int[] {1, 2, 3, 4, 5, 6, 7, 8});
        head = Code_2_11_ReverseKNode.reverseKNode(head,3);
        PrintLinkedUtil.printLinked(head);
    }
}

