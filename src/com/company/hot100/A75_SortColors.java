package com.company.hot100;

import java.util.LinkedList;

/**
 * @description: 给定一个包含红色、白色和蓝色，一共 n 个元素的数组，原地对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。
 * <p>
 * 此题中，我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色。
 * <p>
 *  
 * <p>
 * 进阶：
 * <p>
 * 你可以不使用代码库中的排序函数来解决这道题吗？
 * 你能想出一个仅使用常数空间的一趟扫描算法吗？
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [2,0,2,1,1,0]
 * 输出：[0,0,1,1,2,2]
 * 示例 2：
 * <p>
 * 输入：nums = [2,0,1]
 * 输出：[0,1,2]
 * 示例 3：
 * <p>
 * 输入：nums = [0]
 * 输出：[0]
 * @author: Mask
 * @time: 2020/11/27 5:29 下午
 */
public class A75_SortColors {
    public static void main(String[] args) {
        int[] input = {2, 0, 2, 1, 1, 0};
        sortColors(input);
    }

    public static void sortColors(int[] nums) {
        quickSort(nums, 0, nums.length - 1);

        for(int i:nums){
            System.out.println(i);
        }
    }

    private static void quickSort(int[] nums, int left, int right) {
        if (left >= right) {
            return;
        }
        int index = getIndex(nums, left, right);
        quickSort(nums, left, index - 1);
        quickSort(nums, index + 1, right);
    }

    private static int getIndex(int[] nums, int left, int right) {
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

    private static void swap(int[] nums, int index1, int index2) {
        int temp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = temp;
    }
}
