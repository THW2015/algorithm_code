package com.thw.one;

import java.util.Stack;

/**
 * 求最大子矩阵的大小
 * @author 谭皓文
 * @date 2019/7/8 23:53
 */
public class FindLargestSubMatrix {
    public int maxRecSize (int[][] map) {
        if(map == null || map[0].length == 0 || map.length == 0) {
            return 0;
        }
        int[] height = new int[map[0].length];
        int maxRec = Integer.MIN_VALUE;
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                height[j] = map[i][j] == 0 ? 0 : height[j] + 1;
            }
            maxRec = Math.max(maxRec, maxRecFromBottom(height));
        }
        return maxRec;
    }
    private int maxRecFromBottom (int[] height) {
        if(height == null || height.length == 0) {
            return 0;
        }
        Stack<Integer> stack = new Stack<Integer>();
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < height.length; i++) {
            while (!stack.isEmpty() && height[stack.peek()] >= height[i]) {
                int j= stack.pop();
                int k = stack.isEmpty() ? -1 : stack.peek();
                max = Math.max(max, (i - k - 1) * height[j]);
            }
            stack.push(i);
        }
        while(!stack.isEmpty()) {
            int j= stack.pop();
            int k = stack.isEmpty() ? -1 : stack.peek();
            max = Math.max(max, (height.length - k - 1) * height[j]);
        }
        return max;
    }
    public static void main(String[] args) {
        int[][] map = {{1, 0, 1, 1}, {1, 1, 1, 1}, {1, 1, 1, 0}};
        System.out.println(new FindLargestSubMatrix().maxRecSize(map));
    }
}
