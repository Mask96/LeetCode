package com.company;

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
        int len = gas.length;
        for (int i = 0; i < len; i++) {
            // 开始遍历起点
            int j = i;
            int count = gas[i];
            while (count >= cost[j]) {
                // 现有的油还足够到下个点
                count = count - cost[j];
                // 下个点的index为j，因为是个圈，所以可以取余数。
                j = (j + 1) % len;
                count = count + gas[j];
                // j回到了i
                if (j == i) {
                    return i;
                }
            }
        }
        return -1;
    }
}
