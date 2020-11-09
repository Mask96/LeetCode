package com.company.hot100;

import java.util.ArrayList;
import java.util.List;

/**
 * @description: 数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
 * 输入：n = 3
 * 输出：[
 * "((()))",
 * "(()())",
 * "(())()",
 * "()(())",
 * "()()()"
 * ]
 * @author: Mask
 * @time: 2020/11/5 5:28 下午
 */
public class A22_GenerateParenthesis {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<String>();
        if (n == 0) {
            return res;
        }

        dfs("", n, n, res);
        return res;
    }

    /**
     * 通过递归实现深度遍历
     *
     * @param curStr 当前递归得到的结果
     * @param left   左括号还有几个可以使用
     * @param right  右括号还有几个可以使用
     * @param res    结果集
     */
    public void dfs(String curStr, int left, int right, List<String> res) {
        if (left == 0 && right == 0) {
            res.add(curStr);
            return;
        }

//        剪枝，左边剩的比右边多，不符合规范
        if (left > right) {
            return;
        }
//        有左括号先加左括号，深度遍历
        if (left > 0) {
            dfs(curStr + "(", left - 1, right, res);
        }
        if (right > 0) {
            dfs(curStr + ")", left, right - 1, res);
        }
    }
}
