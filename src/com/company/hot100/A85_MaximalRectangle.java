package com.company.hot100;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @description: 给定一个仅包含 0 和 1 、大小为 rows x cols 的二维二进制矩阵，找出只包含 1 的最大矩形，并返回其面积。
 * 输入：matrix = [["1","0","1","0","0"],["1","0","1","1","1"],["1","1","1","1","1"],["1","0","0","1","0"]]
 * 输出：6
 * 解释：最大矩形如上图所示。
 * <p>
 * rows == matrix.length
 * cols == matrix.length
 * 0 <= row, cols <= 200
 * matrix[i][j] 为 '0' 或 '1'
 * @author: Mask
 * @time: 2020/11/18 5:50 下午
 */
public class A85_MaximalRectangle {
    public int maximalRectangle(char[][] matrix) {
        int h = matrix.length;
        if (h == 0) {
            return 0;
        }
        int maxArea = 0;
        // 记录每一行中j的位置 最高有几个矩形
        int[] dp = new int[matrix[0].length];
        for (int i = 0; i < h; i++) {
            // 计算第i行的 heghts[] 即是dp[].
            for (int j = 0; j < matrix[0].length; j++) {
                dp[j] = matrix[i][j] == '1' ? dp[j] + 1 : 0;
            }

            // 计算第i行为最后行时 最大的面积。
            maxArea = Math.max(maxArea, largestRectangleArea(dp));
        }

        return maxArea;
    }

    public static int largestRectangleArea(int[] heights) {
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
}
