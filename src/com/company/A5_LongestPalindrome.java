package com.company;

/**
 * @description: 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
 * 示例 1：
 * 输入: "babad"
 * 输出: "bab"
 * 注意: "aba" 也是一个有效答案。
 * 示例 2：
 * 输入: "cbbd"
 * 输出: "bb"
 * @author: Mask
 * @time: 2020/7/7 5:52 下午
 */
public class A5_LongestPalindrome {
    public static void main(String[] args) {
        String test = "babad";
        A5_LongestPalindrome a5_longestPalindrome = new A5_LongestPalindrome();
        String res = a5_longestPalindrome.longestPalindrome2(test);
        System.out.println(res);
    }

    /**
     * @description: 2. 将预警计算完的结果保存起来
     * dp[start][end] = dp[start + 1][end - 1] && s.charAt(start) == s.charAt(end)
     * @Param: [s]
     * @return: java.lang.String
     * @author: Mask
     * @time: 2020/7/8
     */
    public String longestPalindrome2(String s) {
        int length = s.length();
        boolean[][] dp = new boolean[length][length];

        int maxLen = 0;
        String ans = "";

        for (int len = 1; len <= length; len++) {
            // 要判断的字符串的长度
            for (int start = 0; start < length; start++) {
                int end = start + len - 1;
                if (end >= length) {
                    break;
                }
                // len为1和2时单独判断
                if (len == 1) {
                    dp[start][end] = true;
                } else if (len == 2) {
                    dp[start][end] = s.charAt(start) == s.charAt(end);
                } else {
                    dp[start][end] = dp[start + 1][end - 1] && s.charAt(start) == s.charAt(end);
                }

                if (dp[start][end] && len > maxLen) {
                    ans = s.substring(start, end + 1);
                }

            }
        }

        return ans;
    }

    /**
     * @description: 1.暴力，用所有的子串判断是不是回文(超时)
     * @Param: [s]
     * @return: java.lang.String
     * @author: Mask
     * @time: 2020/7/7
     */
    public String longestPalindrome(String s) {
        String ans = "";
        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 1; j <= s.length(); j++) {
                if (isPalindrome(s.substring(i, j)) && j - i > ans.length()) {
                    ans = s.substring(i, j);
                }
            }
        }
        return ans;
    }

    public boolean isPalindrome(String s) {
        int len = s.length();
        for (int i = 0; i <= len / 2; i++) {
            if (s.charAt(i) != s.charAt(len - i - 1)) {
                return false;
            }
        }
        return true;
    }
}
