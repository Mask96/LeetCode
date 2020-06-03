package com.company;

import java.util.Arrays;

/**
 * @description: 老师想给孩子们分发糖果，有 N 个孩子站成了一条直线，老师会根据每个孩子的表现，预先给他们评分。
 * 你需要按照以下要求，帮助老师给这些孩子分发糖果：
 * 每个孩子至少分配到 1 个糖果。
 * 相邻的孩子中，评分高的孩子必须获得更多的糖果。
 * 那么这样下来，老师至少需要准备多少颗糖果呢？
 * @author: Mask
 * @time: 2020/6/1 5:38 下午
 */
public class Candy135 {
    public int candy(int[] ratings) {
        // 用num数组来记录每个小孩的糖果数量，初始值都为1.
        int[] num = new int[ratings.length];
        Arrays.fill(num, 1);

        // 正面遍历
        for (int i = 1; i < ratings.length; i++) {
            if (ratings[i] > ratings[i - 1]) {
                // 如果后面人分数比前面高，则需要给后面人更多的糖果
                num[i] = num[i - 1] + 1;
            }
        }

        // 反面遍历
        for (int i = ratings.length - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1] && num[i] <= num[i + 1]) {
                // 如果后面人分数比前面高 并且 后面人糖果没比前面人多，则需要给后面人更多的糖果
                num[i] = num[i + 1] + 1;
            }
        }

        int count = 0;
        for (int a : num) {
            count = count + a;
        }
        return count;
    }
}
