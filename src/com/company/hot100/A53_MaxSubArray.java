package com.company.hot100;

import java.util.LinkedList;
import java.util.List;

import static java.lang.Integer.MIN_VALUE;

/**
 * @Classname A53_MaxSubArray
 * @Description 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 * <p>
 * 示例:
 * <p>
 * 输入: [-2,1,-3,4,-1,2,1,-5,4]
 * 输出: 6
 * 解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
 * @Date 2020/11/16 22:56
 * @Created by Mask
 */
public class A53_MaxSubArray {
    public static void main(String[] args) {
        int[] nums = {-1, -2};
        System.out.println(maxSubArray(nums));
    }

    public static int maxSubArray(int[] nums) {
        int[] dp = new int[nums.length];
        if (nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        dp[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            // 状态转移方程
            dp[i] = Math.max(dp[i - 1] + nums[i], nums[i]);
        }

        int max = dp[0];
        for (int i = 1; i < dp.length; i++) {
            max = Math.max(max, dp[i]);
        }
        return max;
    }
}
