package com.company.hot100;

import java.util.*;

/**
 * @Classname A49_GroupAnagrams
 * @Description 给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。
 * <p>
 * 示例:
 * <p>
 * 输入: ["eat", "tea", "tan", "ate", "nat", "bat"]
 * 输出:
 * [
 * ["ate","eat","tea"],
 * ["nat","tan"],
 * ["bat"]
 * ]
 * @Date 2020/11/16 22:20
 * @Created by Mask
 */
public class A49_GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> hashMap = new HashMap<>();
        for (int i = 0; i < strs.length; i++) {
            char[] c = strs[i].toCharArray();
            Arrays.sort(c);
            String key = String.valueOf(c);
            if (!hashMap.containsKey(key)) {
                hashMap.put(key, new LinkedList<String>());
            }
            hashMap.get(key).add(strs[i]);
        }

        List<List<String>> result = new ArrayList<List<String>>();
        for (String str : hashMap.keySet()) {
            List<String> strings = hashMap.get(str);
            result.add(strings);
        }
        return result;
    }
}
