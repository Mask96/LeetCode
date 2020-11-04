package com.company;

import com.company.base.Point;

import java.util.HashMap;

import static java.lang.Integer.max;

/**
 * 给定一个二维平面，平面上有 n 个点，求最多有多少个点在同一条直线上。
 * 示例 1:
 * <p>
 * 输入: [[1,1],[2,2],[3,3]]
 * 输出: 3
 * 解释:
 * ^
 * |
 * |        o
 * |     o
 * |  o  
 * +------------->
 * 0  1  2  3  4
 */
public class MaxPointsOnLine {
    public int maxPoints(Point[] points) {
        if (points.length == 1) {
            return 1;
        } else if (points.length == 0) {
            return 0;
        }
        int max = 0;
        for (int i = 0; i < points.length; i++) {

            int curMax = 1;
            HashMap<Double, Integer> aMap = new HashMap<>();
            // 重复点
            int repeat = 0;
            // 垂直线点
            int vertical = 0;

            for (int j = 0; j < points.length; j++) {
                if (i != j) {
                    double x1 = points[i].x - points[j].x;
                    double y1 = points[i].y - points[j].y;
                    if (x1 == 0 && y1 == 0) {
                        // 两个点重合
                        repeat++;
                    } else if (x1 == 0) {
                        // 两个点垂直。斜率无法计算
                        if (vertical == 0) {
                            vertical = 2;
                        } else {
                            vertical++;
                        }
                        curMax = max(curMax, vertical);
                    } else {
                        double k = y1 / x1;
                        if (aMap.containsKey(k)) {
                            int num = aMap.get(k) + 1;
                            aMap.put(k, num);
                        } else {
                            aMap.put(k, 2);
                        }
                        curMax = max(curMax, aMap.get(k));
                    }
                }

            }

            // 获取map中最多的值
            max = max(max, curMax + repeat);
        }
        return max;
    }
}
