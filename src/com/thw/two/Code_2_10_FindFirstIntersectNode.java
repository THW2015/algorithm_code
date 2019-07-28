package com.thw.two;

import com.thw.common.Node;

/**
 * 两个单链表相交问题
 * @author 谭皓文
 * @date 2019/7/28 12:20
 */
public class Code_2_10_FindFirstIntersectNode {

    public static Node getIntersectNode(Node head1, Node head2) {
        if(head1 == null || head2 == null) {
            return null;
        }
        Node loop1 = getLoopNode(head1);
        Node loop2 = getLoopNode(head2);
        if(loop1 == null && loop2 == null) {
            return noLoop(head1, head2);
        }
        if(loop1 != null && loop2 != null) {
            return bothLoop(head1, loop1, head2, loop2);
        }
        return null;
    }
    //看是否有循环节点
    public static Node getLoopNode(Node head) {
        if(head == null || head.next == null || head.next.next == null) {
            return null;
        }
        Node slow = head;
        Node fast = head;
        do {
            if(fast.next == null || fast.next.next == null) {
                return null;
            }
            slow = slow.next;
            fast = fast.next.next;
        } while (slow != fast);
            fast = head;
        while (fast != slow) {
            slow = slow.next;
            fast = fast.next;
        }
        return fast;
    }

    public static Node noLoop(Node node1, Node node2) {
        Node cur1 = node1;
        Node cur2 = node2;
        int n = 0;
        while(cur1 != null) {
            cur1 = cur1.next;
            n++;
        }
        while(cur2 != null) {
            cur2 = cur2.next;
            n--;
        }
        //始终cur1指向长的那个
        if(n >= 0) {
            cur1 = node1;
            cur2 = node2;
        }else{
            cur1 = node2;
            cur2 = node1;
        }
        n = Math.abs(n); // |n|
        while(n != 0) {
            n--;
            cur1 = cur1.next;
        }
        while(cur1 != cur2) {
            cur1 = cur1.next;
            cur2 = cur2.next;
        }
        return cur1;
    }

    public static Node bothLoop(Node node1, Node loop1, Node node2, Node loop2) {
        Node cur1 = node1;
        Node cur2 = node2;
        if(loop1 == loop2) {
            int n = 0;
            while(cur1 != loop1) {
                cur1 = cur1.next;
                n++;
            }
            while(cur2 != loop2) {
                cur2 = cur2.next;
                n--;
            }
            //始终cur1指向长的那个
            if(n >= 0) {
                cur1 = node1;
                cur2 = node2;
            }else{
                cur1 = node2;
                cur2 = node1;
            }
            n = Math.abs(n); // |n|
            while(n != 0) {
                n--;
                cur1 = cur1.next;
            }
            while(cur1 != cur2) {
                cur1 = cur1.next;
                cur2 = cur2.next;
            }
            return cur1;
        }else {
            cur1 = loop1;
            do {
                if(cur1 == loop2) {
                    return loop1;
                }
                cur1 = cur1.next;
            }while (cur1 != loop1);
            return null;
        }
    }

//test
    public static void main(String[] args) {
        // 1->2->3->4->5->6->7->null
        Node head1 = new Node(1);
        head1.next = new Node(2);
        head1.next.next = new Node(3);
        head1.next.next.next = new Node(4);
        head1.next.next.next.next = new Node(5);
        head1.next.next.next.next.next = new Node(6);
        head1.next.next.next.next.next.next = new Node(7);

        // 0->9->8->6->7->null
        Node head2 = new Node(0);
        head2.next = new Node(9);
        head2.next.next = new Node(8);
        head2.next.next.next = head1.next.next.next.next.next; // 8->6
        System.out.println(getIntersectNode(head1, head2).value);

        // 1->2->3->4->5->6->7->4...
        head1 = new Node(1);
        head1.next = new Node(2);
        head1.next.next = new Node(3);
        head1.next.next.next = new Node(4);
        head1.next.next.next.next = new Node(5);
        head1.next.next.next.next.next = new Node(6);
        head1.next.next.next.next.next.next = new Node(7);
        head1.next.next.next.next.next.next = head1.next.next.next; // 7->4

        // 0->9->8->2...
        head2 = new Node(0);
        head2.next = new Node(9);
        head2.next.next = new Node(8);
        head2.next.next.next = head1.next; // 8->2
        System.out.println(getIntersectNode(head1, head2).value);

        // 0->9->8->6->4->5->6..
        head2 = new Node(0);
        head2.next = new Node(9);
        head2.next.next = new Node(8);
        head2.next.next.next = head1.next.next.next.next.next; // 8->6
        System.out.println(getIntersectNode(head1, head2).value);
    }
}
