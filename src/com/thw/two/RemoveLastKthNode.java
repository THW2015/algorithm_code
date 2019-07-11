package com.thw.two;

import com.thw.common.DoubleNode;
import com.thw.common.Node;
import com.thw.utils.DoubleLinkedBuilderUtil;
import com.thw.utils.LinkedBuilderUtil;
import com.thw.utils.PrintLinkedUtil;

/**
 * 删除单链表和双链表倒数第K个节点
 * @author 谭皓文
 * @date 2019/7/10 21:37
 */
public class RemoveLastKthNode {
     public static Node doRemoveLastKthNode (Node head, int lastKth) {
         if (head == null || lastKth < 1) {
             return head;
         }
         Node cur = head;
         while (cur != null) {
             --lastKth;
             cur = cur.next;
         }
         if (lastKth == 0) {
             head = head.next;
             return head;
         }

         if (lastKth > 0) {
             return head;
         }

         cur = head;
         lastKth += 1;
         while (lastKth != 0) {
             cur = cur.next;
             lastKth++;
         }
         cur.next = cur.next.next;
         return head;
     }

    public static DoubleNode doRemoveDoubleLinkedLastKthNode (DoubleNode head, int lastKth) {
        if (head == null || lastKth < 1) {
            return head;
        }
        DoubleNode cur = head;
        while (cur != null) {
            --lastKth;
            cur = cur.next;
        }
        if (lastKth == 0) {
            head = head.next;
            head.last = null;
            return head;
        }

        if (lastKth > 0) {
            return head;
        }

        cur = head;
        lastKth += 1;
        while (lastKth != 0) {
            cur = cur.next;
            lastKth++;
        }
        DoubleNode node = cur.next;
        cur.next = cur.next.next;
        if (cur.next == null) {
            return head;
        }
        cur = cur.next.last;
        node = null;
        return head;
    }


    public static void main(String[] args) {
        PrintLinkedUtil.printLinked(RemoveLastKthNode.doRemoveLastKthNode(LinkedBuilderUtil.buildLinked(new int[]{1, 3, 4, 6}), 1));
        PrintLinkedUtil.printDoubleLinked(RemoveLastKthNode.doRemoveDoubleLinkedLastKthNode(DoubleLinkedBuilderUtil.buildDoubleLinked(new int[]{1, 3, 4, 6}), 1));
    }
}
