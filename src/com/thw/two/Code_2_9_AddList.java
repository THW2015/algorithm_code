package com.thw.two;

import com.thw.common.Node;
import com.thw.utils.LinkedBuilderUtil;
import com.thw.utils.PrintLinkedUtil;

import java.util.Stack;

/**
 * 将两链表相加 比如9->3->7 和 6->3 1->0->0->0
 * @author 谭皓文
 * @date 2019/7/23 22:38
 */
public class Code_2_9_AddList {

    public static Node addList1(Node head1, Node head2) {
        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();
        Node cur1 = head1;
        Node cur2 = head2;
        while(cur1 != null || cur2 != null) {
            if(cur1 != null) {
                stack1.push(cur1.value);
                cur1 = cur1.next;
            }
            if(cur2 != null){
                stack2.push(cur2.value);
                cur2 = cur2.next;
            }
        }
        int ca = 0; // 进位
        int sum = 0, num1 = 0, num2 = 0;
        Node next = null, cur = null;
        while(!stack1.isEmpty() || !stack2.isEmpty() || ca > 0) {
            num1 = !stack1.isEmpty() ? stack1.pop() : 0;
            num2 = !stack2.isEmpty() ? stack2.pop() : 0;
            sum = num1 + num2 + ca;
            ca = 0;
            if(sum >= 10) {
                ca = sum / 10;
                sum = sum % 10;
            }
            cur = new Node(sum);
            cur.next = next;
            next = cur;
        }
        return cur;
    }

    public static Node addList2(Node head1, Node head2) {
        Node cur1 = reverse(head1);
        Node cur2 = reverse(head2);
        int ca = 0, sum, num1, num2;
        Node next = null, cur = null;
        while(cur1 != null || cur2 != null || ca > 0) {
            num1 = 0;
            num2 = 0;
            if(cur1 != null) {
                num1 = cur1.value;
                cur1 = cur1.next;
            }
            if(cur2 != null) {
                num2 = cur2.value;
                cur2 = cur2.next;
            }
            sum = num1 + num2 + ca;
            ca = 0;
            if(sum >= 10) {
                ca = sum / 10;
                sum = sum % 10;
            }
            cur = new Node(sum);
            cur.next = next;
            next = cur;
        }
        return cur;
    }

    private static Node reverse(Node head) {
        // reverse
        Node pre = null;
        Node cur = head;
        Node next = null;
        while (cur != null) {
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }

    public static void main(String[] args) {
        Node head1 = LinkedBuilderUtil.buildLinked(new int[] {9, 3, 7});
        Node head2 = LinkedBuilderUtil.buildLinked(new int[] {6, 3});
        PrintLinkedUtil.printLinked(Code_2_9_AddList.addList1(head1, head2));
        PrintLinkedUtil.printLinked(Code_2_9_AddList.addList2(head1, head2));
    }
}
