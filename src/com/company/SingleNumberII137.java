package com.company;

import java.util.HashMap;

/**
 * @description: 现在有一个整数类型的数组，数组中只有一个元素只出现一次，其余元素都出现三次。你需要找出只出现一次的元素
 * 注意：
 * 你需要给出一个线性时间复杂度的算法，你能在不使用额外内存空间的情况下解决这个问题么？
 * @author: Mask
 * @time: 2020/5/27 5:50 下午
 */
public class SingleNumberII137 {
    public int singleNumber(int[] A) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int value : A) {
            if (map.containsKey(value)) {
                map.put(value, map.get(value) + 1);
            } else {
                map.put(value, 1);
            }
        }

        for (int i : map.keySet()) {
            if (map.get(i) == 1) {
                return i;
            }
        }

        return -1;
    }
}
