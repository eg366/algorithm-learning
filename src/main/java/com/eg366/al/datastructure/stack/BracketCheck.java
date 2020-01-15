package com.eg366.al.datastructure.stack;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * 括号匹配检查
 *
 * @Author: zhangjunyu
 * @Date: 2020/1/15 15:39
 */
public class BracketCheck {

    public static void main(String[] args) {
        // 合法表达式
        String expression = "{[]{[()]}()}";
//        expression = "{[]()[{}]}";
        expression = "[{()}([])]";

        // 不合法表达式
//        expression = "{[}()]";
        expression = "[({)]";

        boolean result = check(expression);

        System.out.println(expression + " is a right expression. --> " + result);
    }

    // 反括号字典map
    private static Map<String, String> REVERSE_BRACKET = new HashMap() {{
        put(")", "(");
        put("]", "[");
        put("}", "{");
    }};

    private static boolean check(String expression) {
        Stack<String> bracketStack = new Stack<>();

        // 遍历符号
        for (int i = 0; i < expression.length(); i++) {
            String e = String.valueOf(expression.charAt(i));
            // 如果栈中有符号，且当前符号是反向符号，且栈顶符号是当前符号的反向符号，将栈顶符号弹出。否则入栈
            if (bracketStack.size() > 0 && REVERSE_BRACKET.containsKey(e) && bracketStack.peek().equals(REVERSE_BRACKET.get(e))) {
                bracketStack.pop();
            } else {
                bracketStack.push(e);
            }
        }

        // 如果栈中元素已为空，表示表达式正确
        return bracketStack.isEmpty();
    }
}
