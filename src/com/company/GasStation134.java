package com.company;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * @description: 环形路上有n个加油站，第i个加油站的汽油量是gas[i].
 * 你有一辆车，车的油箱可以无限装汽油。从加油站i走到下一个加油站（i+1）花费的油量是cost[i]，你从一个加油站出发，刚开始的时候油箱里面没有汽油。
 * 求从哪个加油站出发可以在环形路上走一圈。返回加油站的下标，如果没有答案的话返回-1。
 * 注意：答案保证唯一。
 * @author: Mask
 * @time: 2020/6/3 5:29 下午
 */
public class GasStation134 {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        // 贪心，先去最多的油站
        int length = gas.length;
        List<Integer> indexList;
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {

            }
        }
    }
}
