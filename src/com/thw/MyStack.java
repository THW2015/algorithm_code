package com.thw;

import java.util.Stack;

/**
 * 实现一个特殊的栈，在实现栈的基础上，在实现返回栈的最小元素操作
 * @author 谭皓文
 * @date 2019/7/5 23:16
 */
public class MyStack {

    private Stack<Integer> stackData;
    private Stack<Integer> stackMin;

    public MyStack(){
        stackData = new Stack<Integer>();
        stackMin = new Stack<Integer>();
    }

    public void push(int num){
        if(this.stackMin.isEmpty()){
            this.stackMin.push(num);
        }else if(num < getMin()){
            this.stackMin.push(num);
        }else{
            this.stackMin.push(this.stackMin.peek());
        }
        this.stackData.push(num);
    }


    public int pop(){
        if(this.stackData.isEmpty()){
            throw new RuntimeException("栈为空");
        }
        stackMin.pop();
        return stackData.pop();
    }

    public int getMin(){
        if(this.stackData.isEmpty()){
            throw new RuntimeException("栈为空");
        }
        return stackMin.peek();
    }


    public static void main(String[] args) {
        MyStack stack = new MyStack();
        stack.push(7);
        stack.push(9);
        stack.push(4);
        stack.push(3);
        System.out.println(stack.getMin());
        stack.pop();
        System.out.println(stack.getMin());
    }
}
