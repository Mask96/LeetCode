package com.company.hot100;

import java.util.Arrays;

/**
 * @description: 在未排序的数组中找到第 k 个最大的元素。请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [3,2,1,5,6,4] 和 k = 2
 * 输出: 5
 * 示例 2:
 * <p>
 * 输入: [3,2,3,1,2,4,5,5,6] 和 k = 4
 * 输出: 4
 * @author: Mask
 * @time: 2020/11/25 3:21 下午
 */
public class A215_FindKthLargest {
    public int findKthLargest(int[] nums, int k) {
        quickSort(nums, 0, nums.length - 1);
        return nums[nums.length - k];
    }

    /**
     * 递归
     * 以获取的游标为分界，继续往下分
     */
    public void quickSort(int[] nums, int left, int right) {
        if (left >= right) {
            return;
        }
        int index = getIndex(nums, left, right);
        quickSort(nums, left, index - 1);
        quickSort(nums, index + 1, right);
    }

    // 获取key排序后所在的index
    public int getIndex(int[] nums, int left, int right) {
        int key = nums[left];
        while (left < right) {
            while (nums[right] >= key && left < right) {
                right--;
            }
            swap(nums, left, right);
            while (nums[left] <= key && left < right) {
                left++;
            }
            swap(nums, left, right);
        }
        return left;
    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

}
