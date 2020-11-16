package com.company.hot100;

/**
 * @description: 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
 * 输入：height = [0,1,0,2,1,0,1,3,2,1,2,1]
 * 输出：6
 * 解释：上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。
 * @author: Mask
 * @time: 2020/11/16 4:56 下午
 */
public class A42_Trap {
    // 双指针法
    public int trap2(int[] height) {
        int left = 0, right = height.length - 1;
        int sum = 0;
        int left_max = 0, right_max = 0;
        while (left < right) {
            if (height[left] < height[right]) {
                if (height[left] > left_max) {
                    left_max = height[left];
                } else {
                    sum += left_max - height[left];
                }
                left++;
            } else {
                if (height[right] > right_max) {
                    right_max = height[right];
                } else {
                    sum += right_max - height[right];
                }
                right--;
            }
        }
        return sum;
    }

    // 暴力方法 对于数组中的每个元素，我们找出下雨后水能达到的最高位置，等于两边最大高度的较小值减去当前高度的值。
    public int trap(int[] height) {
        int sum = 0;
        int size = height.length;
        for (int i = 0; i < size; i++) {
            int left = 0;
            for (int lIndex = i - 1; lIndex >= 0; lIndex--) {
                left = Math.max(left, height[lIndex]);
            }
            int right = 0;
            for (int rIndex = i + 1; rIndex < size; rIndex++) {
                right = Math.max(right, height[rIndex]);
            }
            if (Math.min(left, right) > height[i]) {
                sum = sum + Math.min(left, right) - height[i];
            }
        }
        return sum;
    }
}
