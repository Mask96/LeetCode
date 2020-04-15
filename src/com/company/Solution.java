package com.company;

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

class Point {
    int x;
    int y;

    Point() {
        x = 0;
        y = 0;
    }

    Point(int a, int b) {
        x = a;
        y = b;
    }
}

public class Solution {
    public int maxPoints(Point[] points) {
        int max = 0;
        for (Point pointA : points) {
            HashMap<Double, Integer> aMap = new HashMap<>();
            // 重复点
            int repeat = 1;
            // 垂直线点
            int vertical = 1;
            for (Point pointB : points) {
                if (points.length == 1) {
                    aMap.put(1.0, 1);
                    break;
                }
                if (pointA.x == pointB.x && pointA.y == pointB.y) {
                    // 两个点重合
                    repeat++;
                } else if (pointA.x == pointB.x) {
                    // 两个点垂直。斜率无法计算
                    vertical++;
                } else {
                    double k = (pointB.y - pointA.y) / (pointB.x - pointA.x);
                    if (aMap.containsKey(k)) {
                        int num = aMap.get(k) + 1;
                    } else {
                        aMap.put(k, 2);
                    }
                }
            }

            // 获取map中最多的值
            int maxMapNum = 0;
            for (double k : aMap.keySet()) {
                maxMapNum = max(maxMapNum, aMap.get(k));
            }
            int maxNum = max(repeat, vertical);
            maxNum = max(maxNum, maxMapNum);
            max = max(max, maxNum);
        }
        return max;
    }
}
