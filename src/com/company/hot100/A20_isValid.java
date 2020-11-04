package com.company.hot100;

import java.util.Stack;

/**
 * @description: 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 * <p>
 * 有效字符串需满足：
 * <p>
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 注意空字符串可被认为是有效字符串。
 * @author: Mask
 * @time: 2020/11/4 7:27 下午
 */
public class A20_isValid {
    // 更好解法
    public boolean isValidBetter(String s) {
        if (s.isEmpty()) {
            return true;
        }
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '(') {
                stack.push(')');
            } else if (c == '[') {
                stack.push(']');
            } else if (c == '{') {
                stack.push('}');
            } else if (stack.isEmpty() || c != stack.pop()) {
                return false;
            }
        }
        return stack.isEmpty();
    }


    public boolean isValid(String s) {
        if ("".equals(s)) {
            return true;
        }

        boolean res = true;
        Stack<String> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if ("(".equals(c + "") || "[".equals(c + "") || "{".equals(c + "")) {
                stack.push(c + "");
            } else {
                // 传入右括号时，栈为空，必然错误。
                if (stack.isEmpty()) {
                    res = false;
                    break;
                }
                String pop = stack.pop();
                boolean result = true;
                switch (pop) {
                    case "(":
                        result = ")".equals(c + "");
                        break;
                    case "[":
                        result = "]".equals(c + "");
                        break;
                    case "{":
                        result = "}".equals(c + "");
                        break;
                    default:
                        break;
                }
                if (!result) {
                    res = false;
                    break;
                }
            }
        }

        // 栈结束时必须为空
        if (!stack.isEmpty()) {
            res = false;
        }
        return res;
    }
}
