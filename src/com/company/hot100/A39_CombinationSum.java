package com.company.hot100;

import java.util.*;

/**
 * @description: 给定一个无重复元素的数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 * <p>
 * candidates 中的数字可以无限制重复被选取。
 * <p>
 * 说明：
 * <p>
 * 所有数字（包括 target）都是正整数。
 * 解集不能包含重复的组合。 
 * 示例 1：
 * <p>
 * 输入：candidates = [2,3,6,7], target = 7,
 * 所求解集为：
 * [
 * [7],
 * [2,2,3]
 * ]
 * 示例 2：
 * <p>
 * 输入：candidates = [2,3,5], target = 8,
 * 所求解集为：
 * [
 *   [2,2,2,2],
 *   [2,3,3],
 *   [3,5]
 * ]
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= candidates.length <= 30
 * 1 <= candidates[i] <= 200
 * candidate 中的每个元素都是独一无二的。
 * 1 <= target <= 500
 * @author: Mask
 * @time: 2020/11/14 2:51 下午
 */
public class A39_CombinationSum {
    public static void main(String[] args) {
        int[] candidates = {2, 3, 6, 7};
        int target = 7;
        List<List<Integer>> aa = combinationSum(candidates, target);
        for (List<Integer> a : aa) {
            System.out.println("-----");
            for (Integer i : a) {
                System.out.println(i);
            }
        }
    }

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new LinkedList<>();
        if (candidates.length == 0) {
            return result;
        }

        Deque<Integer> curResult = new ArrayDeque<>();
        dfs(result, curResult, target, candidates, 0);

        return result;
    }

    private static void dfs(List<List<Integer>> result, Deque<Integer> curResult, int target, int[] candidates, int index) {

        if (target < 0) {
            return;
        } else if (target == 0) {
            result.add(new ArrayList<>(curResult));
            return;
        }

        for (int i = index; i < candidates.length; i++) {
            curResult.add(candidates[i]);
            dfs(result, curResult, target - candidates[i], candidates, i);
            curResult.removeLast();
        }
    }
}
