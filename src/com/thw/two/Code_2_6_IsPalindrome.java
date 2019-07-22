package com.thw.two;

import com.thw.common.Node;
import com.thw.utils.LinkedBuilderUtil;
import com.thw.utils.PrintLinkedUtil;

import java.util.Stack;

/**
 * 判断链表是否回文
 * @author 谭皓文
 * @date 2019/7/21 23:03
 */
public class Code_2_6_IsPalindrome{

//    解法1
    public static boolean isPalindrome1(Node head) {
        if(head == null) {
            throw new RuntimeException("head is null");
        }
        Stack<Integer> stack = new Stack<Integer>();
        Node cur = head;
        while(cur != null) {
            stack.push(cur.value);
            cur = cur.next;
        }
        cur = head;
        while(cur != null) {
            if(stack.pop() != cur.value) {
                return false;
            }
            cur = cur.next;
        }
        return true;
    }

//    解法2

    public static boolean isPalindrome2(Node head) {
        if(head == null) {
            throw new RuntimeException("head is null");
        }
        Stack<Integer> stack = new Stack<Integer>();
        Node slow = head; //慢指针
        Node quick = head; //快指针
        while(quick != null  && quick.next != null ) {
            slow = slow.next;
            quick = quick.next.next;
        }
        Node cur = slow;
        while(cur != null) {
            stack.push(cur.value);
            cur = cur.next;
        }
        cur = head;
        while(cur != null) {
            if(stack.isEmpty()) {
                break;
            }
            if(stack.pop() != cur.value) {
                return false;
            }
            cur = cur.next;
        }
        return true;

    }
//    解法3 不用stack
    public static boolean isPalindrome3(Node head) {
        boolean res = true;
        if(head == null) {
            throw new RuntimeException("head is null");
        }

        Node slow = head; //慢指针
        Node quick = head; //快指针
        while(quick != null  && quick.next != null ) {
            slow = slow.next;
            quick = quick.next.next;
        }
        //reverse
        Node pre = null;
        Node cur = slow.next;
        Node next = null;
        while(cur != null) {
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        cur = head;
        Node tmp = pre;
        while(tmp != null) {
            if (cur.value != tmp.value) {
                res = false;
            }
            tmp = tmp.next;
            cur = cur.next;
        }

        cur = pre;
        pre = null;
        next = null;
        while(cur != null) {
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        slow.next = pre;
        PrintLinkedUtil.printLinked(head);
        return res;
    }


//    test
    public static void main(String[] args) {
        Node head = LinkedBuilderUtil.buildLinked(new int[] {1, 2 , 3, 2, 3});
        System.out.println(Code_2_6_IsPalindrome.isPalindrome3(head));
    }

}
