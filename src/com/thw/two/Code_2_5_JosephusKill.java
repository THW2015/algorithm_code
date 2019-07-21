package com.thw.two;

import com.thw.common.Node;
import com.thw.utils.LinkedBuilderUtil;

/**
 * 环形单链表的约瑟夫问题
 * @author 谭皓文
 * @date 2019/7/21 17:14
 */
public class Code_2_5_JosephusKill {

//    解法1 O(m*n) 重点是last指针移动
    public static Node josephusKill1(Node head, int m) {
        if(head == null || head.next == head || m < 1) {
            return head;
        }
        Node last = head;
        int count = 0;
        while(last.next != head) {
            last = last.next;
        }
        while(head != last) {
            if(++count == m) {
                last.next = head.next;
                count = 0;
            }else {
                last = last.next;
            }
            head = last.next;
        }
        return head;
    }
//    解法2
    public static Node josephusKill2(Node head, int m) {
        if(head == null || head.next == head || m < 1) {
            return head;
        }
        Node cur = head.next;
        int tmp = 1;
        while(cur != head) {
            tmp++;
            cur = cur.next;
        }
        tmp = getLive(tmp, m);
        while(--tmp != 0) {
            head = head.next;
        }
        head.next = head;
        return head;
    }
    // old = (new + m - 1) % i + 1
    //i为node个数
    private static int getLive(int i, int m) {
        if(i == 1) {
            return 1;
        }
        return (getLive(i -1, m) + m - 1)% i + 1;
    }

//    test
    public static void main(String[] args) {
        Node head = LinkedBuilderUtil.buildLinked(new int[] {1, 2, 3, 4, 5});
        Node node = head;
        while (node.next != null) {
            node = node.next;
        }
        node.next = head;
        System.out.println(Code_2_5_JosephusKill.josephusKill1(head, 3).value);
//        System.out.println(Code_2_5_JosephusKill.josephusKill2(head, 3).value);
    }
}
