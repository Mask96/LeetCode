package com.company.hot100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @description: 给出一个区间的集合，请合并所有重叠的区间。
 * <p>
 *  
 * <p>
 * 示例 1:
 * <p>
 * 输入: intervals = [[1,3],[2,6],[8,10],[15,18]]
 * 输出: [[1,6],[8,10],[15,18]]
 * 解释: 区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
 * 示例 2:
 * <p>
 * 输入: intervals = [[1,4],[4,5]]
 * 输出: [[1,5]]
 * 解释: 区间 [1,4] 和 [4,5] 可被视为重叠区间。
 * @author: Mask
 * @time: 2020/11/17 5:39 下午
 */
public class A56_Merge {
    public int[][] merge(int[][] intervals) {
        List<int[]> res = new ArrayList<>();
        if (intervals.length == 0) {
            return res.toArray(new int[0][]);
        }
//        1.先排序，根据左区间从小到大
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));

        int len = intervals.length;
        for (int i = 0; i < len; i++) {
            int left = intervals[i][0];
            int right = intervals[i][1];
//            2. 结果数组为空，或者是数组的左区间大于了目前有的最大又区间，加入一个新的结果数组区间
            if (res.size() == 0 || res.get(res.size() - 1)[1] < left) {
                res.add(intervals[i]);
                continue;
            }
//            3. 更新数组右区间
            res.get(res.size() - 1)[1] = Math.max(res.get(res.size() - 1)[1], right);
        }

        return res.toArray(new int[res.size()][]);
    }
}
