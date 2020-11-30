package com.company.hot100;

import java.util.ArrayList;
import java.util.List;

/**
 * @description: 给定一组不含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
 * <p>
 * 说明：解集不能包含重复的子集。
 * 输入: nums = [1,2,3]
 * 输出:
 * [
 * [3],
 *   [1],
 *   [2],
 *   [1,2,3],
 *   [1,3],
 *   [2,3],
 *   [1,2],
 *   []
 * ]
 * @author: Mask
 * @time: 2020/11/30 7:41 下午
 */
public class A78_Subsets {
    public List<List<Integer>> subsets(int[] nums) {

        List<List<Integer>> result = new ArrayList<List<Integer>>();
        List<Integer> curResult = new ArrayList<Integer>();
        dfs(nums, 0, curResult, result);
        return result;
    }

    private void dfs(int[] nums, int index, List<Integer> curResult, List<List<Integer>> result) {
        if (index == nums.length) {
            // tips: 要新建一个对象，不然之后的修改会对前面已加入的有影响
            result.add(new ArrayList<>(curResult));
            return;
        }

        // 添加本节点
        curResult.add(nums[index]);
        dfs(nums, index + 1, curResult, result);
        curResult.remove(curResult.size() - 1);

        // 不添加本节点
        dfs(nums, index + 1, curResult, result);
    }
}
