package com.company.hot100;

import java.util.LinkedList;
import java.util.List;

/**
 * @description: 给定两个大小为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。
 * 请你找出这两个正序数组的中位数，并且要求算法的时间复杂度为 O(log(m + n))。
 * 你可以假设 nums1 和 nums2 不会同时为空。
 * <p>
 * 示例 1:
 * <p>
 * nums1 = [1, 3]
 * nums2 = [2]
 * <p>
 * 则中位数是 2.0
 * 示例 2:
 * <p>
 * nums1 = [1, 2]
 * nums2 = [3, 4]
 * <p>
 * 则中位数是 (2 + 3)/2 = 2.5
 * @author: Mask
 * @time: 2020/7/7 5:04 下午
 */
public class A4_FindMedianSortedArrays {
    public static void main(String[] args) {
        int[] num1 = {1, 3};
        int[] num2 = {2,4};

        A4_FindMedianSortedArrays a4_findMedianSortedArrays = new A4_FindMedianSortedArrays();
        double res = a4_findMedianSortedArrays.findMedianSortedArrays(num1, num2);
        System.out.println(res);
    }

    /**
     * @description: 顺序合并后找中位数(其实应该使用二分的思想才能降低到log级别)
     * @Param: [nums1, nums2]
     * @return: double
     * @author: Mask
     * @time: 2020/7/7
     */
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len = nums1.length + nums2.length;
        List<Integer> nums3 = new LinkedList<>();

        int index1 = 0, index2 = 0;
        for (int i = 0; i < len; i++) {
            if (index1 >= nums1.length) {
                // nums1空了，nums2全部加入
                nums3.add(nums2[index2]);
                index2++;
                continue;
            }
            if (index2 >= nums2.length) {
                // nums2空了，nums1全部加入
                nums3.add(nums1[index1]);
                index1++;
                continue;
            }
            if (nums1[index1] < nums2[index2]) {
                nums3.add(nums1[index1]);
                index1++;
            } else {
                nums3.add(nums2[index2]);
                index2++;
            }
        }

        if (len % 2 == 1) {
            // 奇数
            return nums3.get(len / 2 );
        } else {
            return (nums3.get(len / 2) + nums3.get(len / 2 - 1)) / 2.0;
        }
    }
}
