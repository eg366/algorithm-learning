package com.eg366.al.leetcode.algorithms.stack;

import org.apache.commons.lang3.time.StopWatch;

import java.util.Stack;
import java.util.concurrent.TimeUnit;

/**
 * 删除最外层的括号
 * <p>
 * 示例 1：
 * 输入："(()())(())"
 * 输出："()()()"
 * 示例 2：
 * * 输入："(()())(())(()(()))"
 * 输出："()()()()(())"
 * 示例 3：
 * 输入："()()"
 * 输出：""
 */
public class Lc1021 {

    private static final String RIGHT_BRACKET = ")";

    public String removeOuterParentheses(String s) {
        // 返回结果
        StringBuilder result = new StringBuilder();
        // 记录已遍历括号的栈
        Stack<String> stack = new Stack<>();
        // 左括号的数量
        int leftBracketCount = 0;
        // 开始遍历每一个符号
        for (int i = 0; i < s.length(); i++) {
            String c = String.valueOf(s.charAt(i));
            // 如果当前为右括号，且已遍历的括号个数为奇数，且左括号的个数为已遍历符号数的一半
            if (RIGHT_BRACKET.equals(c) && stack.size() % 2 == 1 && leftBracketCount == ((stack.size() + 1) / 2)) {
                // 对已遍历的数据进行出栈及拼接
                String tmp = "";
                while (stack.size() != 1) {
                    tmp = stack.pop() + tmp;
                }
                result.append(tmp);
                stack.pop();
                // 将左括号数量置为0
                leftBracketCount = 0;
            } else {
                // 入栈
                stack.push(c);
                // 当为左括号时，将左括号数量计数加1
                if (!RIGHT_BRACKET.equals(c)) {
                    leftBracketCount++;
                }
            }
        }
        return result.toString();
    }

    public String removeOuterParentheses02(String s) {
        StringBuilder result = new StringBuilder();
        int level = 0;

        for (char c : s.toCharArray()) {
            if (level == 0) {
                // 一级左括号
                level++;
                continue;
            } else if (level == 1 && ')' == c) {
                level--;
                continue;
            } else {
                // 非一级括号
                result.append(c);
                if ('(' == c) {
                    level++;
                } else {
                    level--;
                }
            }
        }

        return result.toString();
    }

    public static void main(String[] args) {

        Lc1021 lc = new Lc1021();

        String s = "(()())(())";
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        System.out.println(s + " ==> " + lc.removeOuterParentheses(s) + ", use time:" + stopWatch.getTime());

        s = "(()())(())(()(()))";
        stopWatch.reset();
        System.out.println(s + " ==> " + lc.removeOuterParentheses(s) + ", use time:" + stopWatch.getTime());

        s = "()()";
        stopWatch.reset();
        System.out.println(s + " ==> " + lc.removeOuterParentheses(s) + ", use time:" + stopWatch.getTime());
    }
}
