package com.company;

/**
 * @description: 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
 * 说明：
 * 你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？
 * @author: Mask
 * @time: 2020/5/27 5:35 下午
 */
public class SingleNumber136 {
    public int singleNumber(int[] A) {
        // 异或:相同数异或结果为0，不同异或为1
        // 0与其他任何数异或都等于原值

        int ans = 0;
        for (int i = 0; i < A.length; i++) {
            ans = ans ^ A[i];
        }
        return ans;
    }
}
