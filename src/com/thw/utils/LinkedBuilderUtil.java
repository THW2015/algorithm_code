package com.thw.utils;

import com.thw.common.Node;


/**
 * 链表生成器
 * @author 谭皓文
 * @date 2019/7/9 22:45
 */
public class LinkedBuilderUtil {

    public static Node buildLinked (int[] arr) {
        if(arr == null || arr.length == 0) {
            return null;
        }
        Node now = null;
        Node next = null;
        Node head = null;
        if (arr.length == 1) {
            now = new Node(arr[0]);
            now.next = null;
            return  null;
        }
        
        for (int i = 0; i < arr.length - 1; i++) {
            if(i == 0) {
                now = new Node(arr[i]);
                next = new Node(arr[i + 1]);
                head = now;
                now.next = next;
                now = next;
            }else {
                next = new Node(arr[i + 1]);
                now.next = next;
                now = next;
            }
        }
        next.next = null;
        return head;
    }


//    test
    public static void main(String[] args) {
        
        Node head = LinkedBuilderUtil.buildLinked(new int[]{1, 3, 4, 6, 5});
        PrintLinkedUtil.printLinked(head);
    }
}
