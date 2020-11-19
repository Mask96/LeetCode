package com.company.hot100;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @description: 给定 n 个非负整数，用来表示柱状图中各个柱子的高度。每个柱子彼此相邻，且宽度为 1 。
 * <p>
 * 求在该柱状图中，能够勾勒出来的矩形的最大面积。
 * @author: Mask
 * @time: 2020/11/18 5:09 下午
 */
public class A84_LargestRectangleArea {
    public static void main(String[] args) {
//        int[] heights = {1,1};
        int[] heights = {2, 1, 5, 6, 2, 3};
//        int[] heights = {2, 0, 2};
        int i = largestRectangleArea2(heights);
        System.out.println(i);
    }

    // 使用单调栈
    public static int largestRectangleArea2(int[] heights) {
        int max = 0;
        int len = heights.length;
        int[] left = new int[len];
        int[] right = new int[len];


        Deque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i < len; i++) {
            while (!stack.isEmpty() && heights[stack.peekLast()] >= heights[i]) {
                stack.removeLast();
            }
            left[i] = stack.isEmpty() ? -1 : stack.peekLast();
            stack.addLast(i);
        }
        stack.clear();
        for (int i = len - 1; i >= 0; i--) {
            while (!stack.isEmpty() && heights[stack.peekLast()] >= heights[i]) {
                stack.removeLast();
            }
            right[i] = stack.isEmpty() ? len : stack.peekLast();
            stack.addLast(i);
        }

        for (int i = 0; i < len; i++) {
            max = Math.max(max, heights[i] * (right[i] - left[i] - 1));
        }
        return max;
    }


    public static int largestRectangleArea(int[] heights) {
        int len = heights.length;
        if (len == 1) {
            return heights[0];
        }
        int max = 0;
        for (int l = 0; l < len; l++) {
            int minHeight = heights[l];
            for (int r = l; r < len; r++) {
                minHeight = Math.min(minHeight, heights[r]);
                max = Math.max(max, (r - l + 1) * minHeight);
            }
        }
        return max;
    }
}
