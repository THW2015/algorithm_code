package com.thw.one;

import com.thw.common.Node;
import com.thw.utils.LinkedBuilderUtil;

/**
 * 打印两个有序链表公共部分
 * @author 谭皓文
 * @date 2019/7/9 22:24
 */
public class PrintTwoLinkedCommonPart {

    public static void doPrintTwoLinkedCommonPart (Node node1,
                                                   Node node2) {

        if(node1 == null || node2 == null) {
            return;
        }

        while (node1 != null && node2 != null) {
            if (node1.value == node2.value) {
                System.out.println(node1.value);
                node1 = node1.next;
                node2 = node2.next;
            }else if (node1.value < node2.value) {
                node1 = node1.next;
            }else {
                node2 = node2.next;
            }
        }

    }

    public static void main(String[] args) {
        PrintTwoLinkedCommonPart.doPrintTwoLinkedCommonPart(LinkedBuilderUtil.buildLinked(new int[]{1, 2, 3, 4, 6, 8}),
                LinkedBuilderUtil.buildLinked(new int[]{1, 2, 3, 6, 6, 8}));
    }
}
