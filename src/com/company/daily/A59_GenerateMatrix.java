package com.company.daily;

/**
 * @description: 给你一个正整数 n ，生成一个包含 1 到 n2 所有元素，且元素按顺时针顺序螺旋排列的 n x n 正方形矩阵 matrix 。
 * @author: Mask
 * @time: 2021/3/16 8:49 下午
 */
public class A59_GenerateMatrix {
    public int[][] generateMatrix(int n) {
        int[][] res = new int[n][n];

        int start_x = 0, start_y = 0;
        int left = -1, right = n, top = -1, bottom = n;
        // 方向 右：0，下：1，左：2，上：3
        int direction = 0;

        int count = 1;
        while (true) {
            // 遍历结束
            if (count == n * n + 1) {
                break;
            }

            // 注意xy的方向
            res[start_y][start_x] = count;
            count++;

            switch (direction) {
                case 0:
                    // 向右
                    if (start_x + 1 == right) {
                        direction = 1;
                        start_y++;
                        top++;
                    } else {
                        start_x++;
                    }
                    break;
                case 1:
                    // 向下
                    if (start_y + 1 == bottom) {
                        direction = 2;
                        start_x--;
                        right--;
                    } else {
                        start_y++;
                    }
                    break;
                case 2:
                    // 向左
                    if (start_x - 1 == left) {
                        direction = 3;
                        start_y--;
                        bottom--;
                    } else {
                        start_x--;
                    }
                    break;
                case 3:
                    // 向上
                    if (start_y - 1 == top) {
                        direction = 0;
                        start_x++;
                        left++;
                    } else {
                        start_y--;
                    }
                    break;
                default:
                    break;
            }

        }
        return res;
    }
}
