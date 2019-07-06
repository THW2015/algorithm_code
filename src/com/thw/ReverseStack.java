package com.thw;

import java.util.Stack;

/**
 * 递归版逆序一个栈
 * @author 谭皓文
 * @date 2019/7/6 0:42
 */
public class ReverseStack <T>{

    private  T getAndRemoveLastElement(Stack<T> stack){
        T result = stack.pop();
        if(stack.isEmpty()){
            return result;
        }
        T last = getAndRemoveLastElement(stack);
        stack.push(result);
        return last;
    }

    public void doReverse(Stack<T> stack){
        if(stack.isEmpty()){
            return;
        }
        T last = getAndRemoveLastElement(stack);
        doReverse(stack);
        stack.push(last);
    }

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<Integer>();
        ReverseStack<Integer> reverseStack = new ReverseStack<Integer>();
        stack.push(2);
        stack.push(3);
        stack.push(4);
        reverseStack.doReverse(stack);
        while (!stack.isEmpty()) {
            System.out.println(stack.pop());
        }
    }
}
