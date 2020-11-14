package com.company.hot100;

/**
 * @description: 给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
 * <p>
 * 你的算法时间复杂度必须是 O(log n) 级别。
 * <p>
 * 如果数组中不存在目标值，返回 [-1, -1]。
 * <p>
 * 示例 1:
 * <p>
 * 输入: nums = [5,7,7,8,8,10], target = 8
 * 输出: [3,4]
 * 示例 2:
 * <p>
 * 输入: nums = [5,7,7,8,8,10], target = 6
 * 输出: [-1,-1]
 * @author: Mask
 * @time: 2020/11/13 5:29 下午
 */
public class A34_SearchRange {

    public int[] searchRange(int[] nums, int target) {

        int l = 0;
        int r = nums.length - 1;
        int[] res = new int[2];

        res[0] = -1;
        res[1] = -1;

        //        找左节点
        while (l <= r) {
            int mid = (l + r) / 2;
            if (nums[mid] == target && (mid == 0 || nums[mid - 1] != target)) {
                res[0] = mid;
            }
            if (nums[l] <= target && target <= nums[mid]) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }

        //        找右节点
        l = 0;
        r = nums.length - 1;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (nums[mid] == target && (mid == nums.length - 1 || nums[mid + 1] != target)) {
                res[1] = mid;
            }
            if (nums[mid] <= target && target <= nums[r]) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return res;
    }
}
