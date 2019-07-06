package com.thw.one;


import java.util.Stack;

/**
 * 汉诺塔问题 递归和非递归
 * @author 谭皓文
 * @date 2019/7/7 0:02
 */
public class HanoiProblem {

    /**
     * 解决问题
     * @param n N层汉诺塔
     * @param from 左
     * @param mid 中
     * @param to 右
     */
    public static void doHanoiProblem(int n, String from, String mid, String to) {
        if (n == 0) {
            System.out.println("无需移动");
        }
//        process1(n, from, mid, to);
        process2(n, from, mid, to);
    }

    //递归版本
    private static void process1(int n, String from, String mid, String to) {
        if (n == 1) {
            System.out.println(String.format("num: %d from: %s, to: %s", n, from, to));
            return;
        }

        process1(n - 1, from, to, mid);
        System.out.println(String.format("num: %d from: %s, to: %s", n, from, to));
        process1(n - 1, mid, from, to);
    }
    public enum Action {
        NO, LTOM, MTOL, RTOM, MTOR
    }
    //非递归版本
    private static int process2(int n, String from, String mid, String to) {
        Stack<Integer> ls = new Stack<Integer>();
        Stack<Integer> ms = new Stack<Integer>();
        Stack<Integer> rs = new Stack<Integer>();
        ls.push(Integer.MAX_VALUE); //避免stack为空进行的额外判断
        ms.push(Integer.MAX_VALUE);
        rs.push(Integer.MAX_VALUE);
        //init
        for (int i = n; i >= 1; i--)
            ls.push(i);

        Action[] record = {Action.NO};
        int step = 0;
        while(rs.size() != n + 1) {
            step += fStackTotStack(record, Action.MTOL, Action.LTOM, ls, ms, from, mid);
            step += fStackTotStack(record, Action.LTOM, Action.MTOL, ms, ls, mid, from);
            step += fStackTotStack(record, Action.RTOM, Action.MTOR, ms, rs, mid, to);
            step += fStackTotStack(record, Action.MTOR, Action.RTOM, rs, ms, to, mid);
        }
        return step;
    }

    private static int fStackTotStack(Action[] record, Action preAction, Action nowAction, Stack<Integer> fs, Stack<Integer> ts, String from, String to) {
        if(record[0] != preAction && fs.peek() < ts.peek()) {
            ts.push(fs.pop());
            System.out.println(String.format("move %d: %s ---> %s", ts.peek(), from, to));
            record[0] = nowAction;
            return 1;
        }
        return 0;
    }

    public static void main(String[] args) {
        HanoiProblem.doHanoiProblem(1, "from", "mid", "to");
    }



}
