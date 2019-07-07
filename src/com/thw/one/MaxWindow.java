package com.thw.one;

import java.util.LinkedList;

/**
 * 生成窗口的最大值数组
 * @author 谭皓文
 * @date 2019/7/7 15:57
 */
public class MaxWindow {
    /**
     * @param arr 给定数组
     * @param w 窗口大小
     * @return
     */
    public int[] getMaxWindow(int[] arr, int w) {
        if (arr.length == 0 || arr == null || w == 0) {
            throw new RuntimeException("请给我一个正确参数");
        }
        int[] res = new int[arr.length - w + 1];
        int index = 0;
        LinkedList<Integer> index_queue = new LinkedList<Integer>(); //双端队列存取的是索引
        for (int i = 0; i < arr.length; i++){
            while (!index_queue.isEmpty() && arr[index_queue.peekLast()] <= arr[i]) {
                index_queue.pollLast();
            }
                index_queue.addLast(i);
            if(index_queue.peekFirst() == i - w) {
                index_queue.pollFirst();
            }
            if(i >= w - 1) {
                res[index++] = arr[index_queue.peekFirst()];
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = {4, 3, 5, 4, 3, 3, 6, 7};
        arr = new MaxWindow().getMaxWindow(arr, 3);
        for (int a : arr) {
            System.out.print(a + " ");
        }
    }
}
