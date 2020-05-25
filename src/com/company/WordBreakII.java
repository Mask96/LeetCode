package com.company;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

/**
 * @description:给定一个非空字符串 s 和一个包含非空单词列表的字典 wordDict，在字符串中增加空格来构建一个句子，使得句子中所有的单词都在词典中。返回所有这些可能的句子。
 * 说明：
 * 分隔时可以重复使用字典中的单词。
 * 你可以假设字典中没有重复的单词。
 * <p>
 * 示例 1：
 * 输入:
 * s = "catsanddog"
 * wordDict = ["cat", "cats", "and", "sand", "dog"]
 * 输出:
 * [
 *   "cats and dog",
 *   "cat sand dog"
 * ]
 * @author: Mask
 * @time: 2020/5/14 8:29 下午
 */
public class WordBreakII {
    public ArrayList<String> wordBreak(String s, Set<String> dict) {

        return DFS(s, dict, new HashMap<String, ArrayList<String>>());
    }

    private ArrayList<String> DFS(String s, Set<String> dict, HashMap<String, ArrayList<String>> map) {

        if (map.containsKey(s)) {
            return map.get(s);
        }

        ArrayList<String> res = new ArrayList<>();
        if (s.length() == 0) {
            res.add("");
            return res;
        }
        for (String subStr : dict) {
            if (s.startsWith(subStr)) {
                for (String str : DFS(s.substring(subStr.length()), dict, map)) {
                    res.add(subStr + (str.equals("") ? "" : " ") + str);
                }
            }
        }
        map.put(s, res);
        return res;
    }
}
