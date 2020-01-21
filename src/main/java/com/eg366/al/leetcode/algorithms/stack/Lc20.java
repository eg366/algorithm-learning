package com.eg366.al.leetcode.algorithms.stack;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * 有效的括号
 * <p>
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 * 有效字符串需满足：
 * (1) 左括号必须用相同类型的右括号闭合。
 * (2) 左括号必须以正确的顺序闭合。
 * </p>
 *
 * @Author: zhangjunyu
 * @Date: 2020/1/21 15:09
 */
public class Lc20 {

    private static final Map<String, String> BRACKETS_MAP = new HashMap() {{
        put(")", "(");
        put("}", "{");
        put("]", "[");
    }};

    public boolean isValid(String s) {
        Stack<String> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            String bracket = String.valueOf(s.charAt(i));

            if (!BRACKETS_MAP.containsKey(bracket)) {
                // 如果是左括号，入栈
                stack.push(bracket);
            } else {
                // 如果是右括号，判断栈顶是否为匹配的左括号
                if (stack.size() == 0 || !stack.pop().equals(BRACKETS_MAP.get(bracket))) {
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }

    public static void main(String[] args) {
//        String s = "([)]";
//        String s = "{[]}";
        String s = "[[";

        Lc20 lc = new Lc20();
        System.out.println(lc.isValid(s));
    }
}
