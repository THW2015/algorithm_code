package com.thw.one;

import com.thw.common.TreeNode;
import com.thw.utils.TreePrintUtil;

import java.util.HashMap;
import java.util.Stack;

/**
 * 构造数组MaxTree
 * @author 谭皓文
 * @date 2019/7/7 16:23
 */
public class MaxTree {

    public TreeNode getMaxTree(int[] arr) {

        TreeNode root = null;

        //init all nodes
        TreeNode[] nodes = new TreeNode[arr.length];
        for (int i = 0; i < arr.length; i++) {
            nodes[i] = new TreeNode(arr[i]);
        }
        Stack<TreeNode> stack = new Stack<TreeNode>();
        HashMap<TreeNode, TreeNode> bigLeftMap = new HashMap<TreeNode, TreeNode>();
        HashMap<TreeNode, TreeNode> bigRightMap = new HashMap<TreeNode, TreeNode>();
        //init bigLeftMap
        for (int i = 0; i < arr.length; i++) {
            while (!stack.isEmpty() && stack.peek().val < nodes[i].val) {
                popStackSetMap(stack, bigLeftMap);
            }
            stack.push(nodes[i]);
        }

        while (!stack.isEmpty()) {
            popStackSetMap(stack, bigLeftMap);
        }

        //init bigRightMap
        for (int i = arr.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && stack.peek().val < nodes[i].val) {
                popStackSetMap(stack, bigRightMap);
            }
            stack.push(nodes[i]);
        }

        while (!stack.isEmpty()) {
            popStackSetMap(stack, bigRightMap);
        }

        for (int i = 0; i < arr.length; i++) {
            TreeNode big_left = bigLeftMap.get(nodes[i]);
            TreeNode big_right = bigRightMap.get(nodes[i]);
            if (big_left == null && big_right == null) {
                root = nodes[i];
            }else if (big_left == null) {
                if (big_right.left == null) {
                    big_right.left = nodes[i];
                }else {
                    big_right.right = nodes[i];
                }
            }else if (big_right == null) {
                if(big_left.left == null) {
                    big_left.left = nodes[i];
                }else {
                    big_left.right = nodes[i];
                }
            }else {
                //取两者最小的为父节点
                TreeNode parent = big_left.val > big_right.val ? big_right : big_left;
                if(parent.left == null) {
                    parent.left = nodes[i];
                }else {
                    parent.right = nodes[i];
                }
            }
        }
        return root;

    }



    private void popStackSetMap(Stack<TreeNode> stack, HashMap<TreeNode, TreeNode> map) {
        TreeNode node = stack.pop();
        if (stack.isEmpty()) {
            map.put(node, null);
        }else {
            map.put(node, stack.peek());
        }

    }




    public static void main(String[] args) {
        int[] arr = {3, 4, 5, 1, 2};
        TreePrintUtil.show(new MaxTree().getMaxTree(arr)); //print the tree
    }
}
