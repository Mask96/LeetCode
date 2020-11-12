package com.company.hot100;

import java.util.Stack;

/**
 * @description: 给定一个只包含 '(' 和 ')' 的字符串，找出最长的包含有效括号的子串的长度。
 * <p>
 * 示例 1:
 * <p>
 * 输入: "(()"
 * 输出: 2
 * 解释: 最长有效括号子串为 "()"
 * 示例 2:
 * <p>
 * 输入: ")()())"
 * 输出: 4
 * 解释: 最长有效括号子串为 "()()"
 * @author: Mask
 * @time: 2020/11/11 5:01 下午
 */
public class A32_LongestValidParentheses {
    public static void main(String[] args) {
        String input = "(()())";
        int i = longestValidParentheses(input);
        System.out.println(i);
    }

    // 栈
    public static int longestValidParentheses2(String s) {
        int max = 0;
        Stack<Integer> stack = new Stack();
        stack.push(-1);
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else {
                stack.pop();
                if (stack.isEmpty()) {
                    stack.push(i);
                } else {
                    max = Math.max(max, i - stack.peek());
                }
            }
        }
        return max;
    }

    //    动态规划
    public static int longestValidParentheses(String s) {
        int[] dp = new int[s.length()];
        int max = 0;

        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == ')') {
                if (s.charAt(i - 1) == '(') {
                    dp[i] = (i - 2 > 0 ? dp[i - 2] : 0) + 2;
                } else if (i - dp[i - 1] > 0 && s.charAt(i - dp[i - 1] - 1) == '(') {
                    if (i - dp[i - 1] - 2 > 0 && dp[i - dp[i - 1] - 2] > 0) {
                        dp[i] = dp[i - dp[i - 1] - 2] + dp[i - 1] + 2;
                    } else {
                        dp[i] = dp[i - 1] + 2;
                    }
                }
            }
            max = Math.max(max, dp[i]);
        }
        return max;
    }
}
