package com.company.hot100;

import java.util.HashSet;
import java.util.Set;

/**
 * @description: 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 * <p>
 * 示例 1:
 * <p>
 * 输入: "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * 示例 2:
 * <p>
 * 输入: "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * 示例 3:
 * <p>
 * 输入: "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 *      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 * @author: Mask
 * @time: 2020/7/6 5:58 下午
 */
public class A3_lengthOfLongestSubstring {
    public static void main(String[] args) {
        String test1 = "pwwkew";
        A3_lengthOfLongestSubstring a3_lengthOfLongestSubstring = new A3_lengthOfLongestSubstring();
        int res = a3_lengthOfLongestSubstring.lengthOfLongestSubstring(test1);
        System.out.println(res);
    }

    public int lengthOfLongestSubstring(String s) {
        int len = s.length();
        Set<Character> ownChar = new HashSet<>();
        int i = 0, j = 0, ans = 0;
        while (i < len && j < len) {
            if (!ownChar.contains(s.charAt(j))) {
                ownChar.add(s.charAt(j));
                j++;
            } else {
                ownChar.remove(s.charAt(i));
                i++;
            }

            if (j - i > ans) {
                ans = j - i;
            }
        }
        return ans;
    }
}
