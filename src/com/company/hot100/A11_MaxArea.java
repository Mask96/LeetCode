package com.company.hot100;

/**
 * @description: 给你 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0)。找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
 * <p>
 * 说明：你不能倾斜容器，且 n 的值至少为 2。
 * @author: Mask
 * @time: 2020/10/28 5:25 下午
 */
public class A11_MaxArea {

    public static void main(String[] args) {
        int[] height = {2, 3, 4, 5, 18, 17, 6};
        int max = maxArea2(height);
        System.out.println(max);
    }

    /**
     * @description: 双指针发，初始将双指针设置在左右两端，移动双指针分别记录最大值，当双指针重合时，最大的值即是所求。
     * 移动规则，移动指针是为了求比当前值更大的面积，因为面积由短边决定，所以移动长边指针不会影响面积（h还会变小），只有移动短边指针时，如果指向了一条更长边，面积才会变大。
     * 所以每次移动短边求面积，并和前一个最大值比较。
     * @author: Mask
     * @time: 2020/10/29
     */
    public static int maxArea2(int[] height) {
        int l = 0, r = height.length - 1;
        int max = getArea(height[l], height[r], r - l);

        while (l != r) {
            System.out.println("l:" + l + "->" + height[l]);
            System.out.println("r:" + r + "->" + height[r]);
            System.out.println("max:" + max);
            if (height[l] > height[r]) {
                r--;
            } else {
                l++;
            }
            max = Math.max(max, getArea(height[l], height[r], r - l));
        }
        return max;
    }

    // 方法一，两层遍历，暴力解法
    public int maxArea1(int[] height) {
        int max = 0;

        for (int i = 1; i < height.length; i++) {
            for (int j = i - 1; j >= 0; j--) {
                max = Math.max(max, getArea(height[i], height[j], i - j));
            }
        }
        return max;
    }

    public static int getArea(int x, int y, int h) {
        int l = Math.min(x, y);
        return h * l;
    }
}
