package com.company;

/**
 * @description: 给你 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0)。找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
 * <p>
 * 说明：你不能倾斜容器，且 n 的值至少为 2。
 * @author: Mask
 * @time: 2020/10/28 5:25 下午
 */
public class A11_MaxArea {

    public int maxArea(int[] height) {

        int max = 0;

        for (int i = 1; i < height.length; i++) {
            for (int j = i - 1; j >= 0; j--) {
                max = Math.max(max, getArea(height[i], height[j], i - j));
            }
        }
        return max;
    }

    public int getArea(int x, int y, int h) {
        int l = Math.min(x, y);
        return h * l;
    }
}
