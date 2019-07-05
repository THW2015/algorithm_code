package com.thw;

import java.util.Stack;

/**
 * 两个栈构成队列
 * @author 谭皓文
 * @date 2019/7/6 0:09
 */
public class TwoStacksQueue {

    private Stack<Integer> stack1; //push
    private Stack<Integer> stack2; //pop

    public  TwoStacksQueue(){
        stack1 = new Stack<Integer>();
        stack2 = new Stack<Integer>();
    }

    public void push(int num){
        stack1.push(num);
    }

    public int pop(){
        if(stack1.isEmpty() && stack2.isEmpty()){
            throw new RuntimeException("the queue is empty");
        }else if(stack2.isEmpty()) {
            do {

                int num = stack1.pop();
                stack2.push(num);

            } while (!stack1.isEmpty());
        }
        return stack2.pop();
    }

    public int peek(){
        if(stack1.isEmpty() && stack2.isEmpty()){
            throw new RuntimeException("the queue is empty");
        }else if(stack2.isEmpty()) {
            do {

                int num = stack1.pop();
                stack2.push(num);

            } while (!stack1.isEmpty());
        }
        return stack2.peek();
    }

    public static void main(String[] args) {
        TwoStacksQueue queue = new TwoStacksQueue();
        queue.push(1);
        queue.push(3);
        queue.push(2);
        queue.push(8);
        System.out.println(queue.pop());
        System.out.println(queue.peek());
    }
}
