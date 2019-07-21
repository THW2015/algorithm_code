package com.thw.two;

import com.thw.common.Node;
import com.thw.utils.LinkedBuilderUtil;
import com.thw.utils.PrintLinkedUtil;

/**
 * 反转部分节点
 * @author 谭皓文
 * @date 2019/7/21 13:43
 */
public class ReversePart {

    public static Node doReversePart(Node head, int from, int to) {
        int len = 0;
        Node node1 = head;
        Node fPre= null; // 第from前一个节点
        Node tPos = null; // 第to前一个节点
        while (node1 != null) {
            len++;
            fPre = len + 1 == from ? node1 : fPre;
            tPos = len - 1 == to ? node1 : tPos;
            node1 = node1.next;
        }

        if(from < 1 || from >= to || to > len) {
            return head;
        }
        Node pre = fPre;
        Node now = fPre == null ? head : fPre.next;
        Node tmp = now;
        Node next = null;
        while(now != tPos) {
            next = now.next;
            now.next = pre;
            pre = now;
            now = next;
        }

        if(fPre != null) {
            fPre.next = pre;
            tmp.next = tPos;
            return head;
        }
        tmp.next = tPos;
        return pre;
    }
//    test
    public static void main(String[] args) {
        PrintLinkedUtil.printLinked(ReversePart.doReversePart(LinkedBuilderUtil.buildLinked(new int[]{1, 2, 3, 4, 5}), 1, 4));
    }
}
