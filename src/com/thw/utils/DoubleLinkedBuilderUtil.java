package com.thw.utils;

import com.thw.common.DoubleNode;

/**
 * 双向链表创造器
 * @author 谭皓文
 * @date 2019/7/10 21:58
 */
public class DoubleLinkedBuilderUtil {

    public static DoubleNode buildDoubleLinked (int[] arr) {
        if(arr == null || arr.length == 0) {
            return null;
        }
        DoubleNode now = null;
        DoubleNode next = null;
        DoubleNode head = null;
        if (arr.length == 1) {
            now = new DoubleNode(arr[0]);
            now.next = null;
            now.last = null;
            return now;
        }

        for (int i = 0; i < arr.length - 1; i++) {
            if(i == 0) {
                now = new DoubleNode(arr[i]);
                next = new DoubleNode(arr[i + 1]);
                head = now;
                now.next = next;
                next.last = now;
                now = next;
            }else {
                next = new DoubleNode(arr[i + 1]);
                now.next = next;
                next.last = now;
                now = next;
            }
        }
        next.next = null;
        return head;
    }
    
    
//    test
    public static void main(String[] args) {
//        1<-->3<-->4
        PrintLinkedUtil.printDoubleLinked(DoubleLinkedBuilderUtil.buildDoubleLinked(new int[]{1, 3, 4}));
    }
}
