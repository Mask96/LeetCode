package com.company;

import java.util.LinkedList;
import java.util.List;

/**
 * @description: 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。
 * <p>
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 * @author: Mask
 * @time: 2020/10/30 5:33 下午
 */
public class A17_LetterCombinations {
    public static void main(String[] args) {
        String input = "23";
        List<String> out = letterCombinations(input);
        for (String letter : out) {
            System.out.println(letter);
        }
    }

    private static final String[] KEYS = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    public static List<String> letterCombinations(String digits) {
        if ("".equals(digits)) {
            return new LinkedList<>();
        }
        List<String> result = new LinkedList<>();

        findWord(0, digits, new StringBuffer(), result);

        return result;
    }

    /**
     * @description: index 当前位置 digits-输入字符串 res-目前拼接结果 result-结果列表
     * @Param: [index, digits, res, result]
     * @return: void
     * @author: Mask
     * @time: 2020/11/2
     */
    private static void findWord(int index, String digits, StringBuffer sb, List<String> result) {
        if (index == digits.length()) {
            result.add(sb.toString());
            return;
        }

        char c = digits.charAt(index);
        String letters = KEYS[c - '0'];
        for (int i = 0; i < letters.length(); i++) {
            sb.append(letters.charAt(i));
            findWord(index + 1, digits, sb, result);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
