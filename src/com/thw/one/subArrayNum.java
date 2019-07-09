package com.thw.one;

import java.util.LinkedList;

/**
 * 最大值减去最小值小于或者等于num的子数组数量
 * @author 谭皓文
 * @date 2019/7/9 21:08
 */
public class subArrayNum {

    public static int getNum (int[] arr, int num) {
        if (arr.length == 0 || arr == null) {
            return 0;
        }
        int res = 0;
        int i = 0, j = 0;
        LinkedList<Integer> qmax = new LinkedList<Integer>();
        LinkedList<Integer> qmin = new LinkedList<Integer>();
        while(i < arr.length) {
            while (j < arr.length) {
                while(!qmax.isEmpty() && arr[qmax.peekLast()] <= arr[j]) {
                    qmax.pollLast();
                }
                qmax.addLast(j);
                while(!qmin.isEmpty() && arr[qmin.peekLast()] >= arr[j]) {
                    qmin.pollLast();
                }
                qmin.addLast(j);
                if((arr[qmax.peekFirst()] - arr[qmin.peekFirst()])> num) {
                    break;
                }
                j++;
            }
            if (qmax.peekFirst() == i) {
                qmax.peekFirst();
            }
            if (qmin.peekFirst() == i) {
                qmin.peekFirst();
            }
            res += j - i;
            i++;
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = {1, 7, 5, 4, 3};
        System.out.println(subArrayNum.getNum(arr, 6));
    }
}
