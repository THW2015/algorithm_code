package com.thw.one;

import com.sun.org.apache.bcel.internal.generic.RETURN;

import java.util.Stack;

/**
 * 栈排序，但只能用到一个辅助栈
 * @author 谭皓文
 * @date 2019/7/6 10:20
 */
public class SorteStack {

    public static void sortStackByStack(Stack<Integer> stack) {
        Stack<Integer> help = new Stack<Integer>();
        while (!stack.isEmpty()) {
            int cur = stack.pop();
            if (!help.isEmpty()) {
                while (!help.isEmpty() && cur > help.peek()) {
                    stack.push(help.pop());
                }
            }
            help.push(cur);
        }
        while(!help.isEmpty()) {
            stack.push(help.pop());
        }
    }

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<Integer>();
        stack.push(6);
        stack.push(3);
        stack.push(7);
        SorteStack.sortStackByStack(stack);
        while(!stack.isEmpty()) {
            System.out.println(stack.pop());
        }
    }
}
