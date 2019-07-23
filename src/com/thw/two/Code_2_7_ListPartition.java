package com.thw.two;

import com.thw.common.Node;
import com.thw.utils.LinkedBuilderUtil;
import com.thw.utils.PrintLinkedUtil;

/**
 * 把链表按某值，小的放左边，等于放中间，大于放右边
 * @author 谭皓文
 * @date 2019/7/22 23:43
 */
public class Code_2_7_ListPartition {

    public static Node listPartition1(Node head, int pivot) {
        if(head == null || head.next == null) {
            return head;
        }
        Node cur = head;
        int count = 0;
        while(cur != null) {
            count++;
            cur = cur.next;
        }
        int[] arr = new int[count];
//        init
        int k = 0;
        cur = head;
        while(k < count) {
            arr[k] = cur.value;
            cur = cur.next;
            k++;
        }
        partition(arr, 0, count - 1, pivot);
        k = 0;
        Node node1 = null;
        Node node2 = null;
        while(k + 1 < count) {
            if(node1 == null) {
                node1 = new Node(arr[k]);
                head = node1;
            }
            node2 = new Node(arr[k + 1]);
            node1.next = node2;
            node1 = node2;
            k++;
        }

        return head;

    }

    public static Node listPartition2(Node head, int pivot) {
        if(head == null || head.next == null) {
            return head;
        }
        Node sH = null; // 小的头
        Node sT = null; // 小的尾
        Node eH = null; // 等的头
        Node eT = null; // 等的尾
        Node bH = null; // 大的头
        Node bT = null; // 大的尾
        Node next = null;
        while(head != null) {
            next = head.next;
            head.next = null; // 分离head
            if(head.value < pivot) {
                if(sH == null) {
                    sH = head;
                    sT = head;
                }else {
                    sT.next = head;
                    sT = sT.next;

                }
            } else  if(head.value == pivot) {
                    if(eH == null) {
                        eH = head;
                        eT = head;
                    }else {
                        eT.next = head;
                        eT = eT.next;
                    }
                } else {
                    if(bH == null) {
                        bH = head;
                        bT = head;
                    } else {
                        bT.next = head;
                        bT = bT.next;
                    }
                }
                head = next;
        }
        if(sT != null) {
            sT.next = eH;
            eT = eT == null ? sT : eT;
        }
        if(eT != null) {
            eT.next = bH;
        }
        return sH != null ? sH : ( eH != null ? eH : bH );
    }


    private static void partition(int[] arr, int start, int end, int num) {
        int less = start - 1;
        int more = end + 1;
        int k = 0;
        while(k < more) {
            if(arr[k] < num) {
                swap(arr, ++less, k++);
            }else if (arr[k] > num) {
                swap(arr, --more, k);
            }else{
                k++;
            }
        }
    }



    private static void swap(int[] arr, int a, int b) {
        if(a == b) {
            return;
        }
        arr[a] = arr[a] ^ arr[b];
        arr[b] = arr[a] ^ arr[b];
        arr[a] = arr[a] ^ arr[b];
    }

//    test
    public static void main(String[] args) {
        Node head = LinkedBuilderUtil.buildLinked(new int[] {7, 9, 1, 8, 5, 2, 5});
        head = Code_2_7_ListPartition.listPartition2(head, 5);
        PrintLinkedUtil.printLinked(head);
    }
}
