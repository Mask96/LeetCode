package com.company.hot100;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @description: 给定一个 没有重复 数字的序列，返回其所有可能的全排列。
 * <p>
 * 示例:
 * <p>
 * 输入: [1,2,3]
 * 输出:
 * [
 * [1,2,3],
 * [1,3,2],
 * [2,1,3],
 * [2,3,1],
 * [3,1,2],
 * [3,2,1]
 * ]
 * @author: Mask
 * @time: 2020/11/16 5:49 下午
 */
public class A46_Permute {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        List<List<Integer>> permute = permute(nums);
        for (List<Integer> list : permute) {
            System.out.println("---------");
            for (Integer i : list) {
                System.out.println(i);
            }
        }
    }

    /**
     * @description: dfs 树的回溯
     * @param: [nums]
     * @return: java.util.List<java.util.List<java.lang.Integer>>
     * @author: Mask
     * @time: 2020/11/16
     */
    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        Deque<Integer> deque = new ArrayDeque<>();
        dfs(deque, nums, result);
        return result;
    }

    public static void dfs(Deque<Integer> deque, int[] nums, List<List<Integer>> result) {
        if (deque.size() == nums.length) {
            result.add(new ArrayList<>(deque));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (deque.contains(nums[i])) {
                continue;
            }
            deque.addLast(nums[i]);
            dfs(deque, nums, result);
            deque.removeLast();
        }
    }
}
