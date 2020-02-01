package com.eg366.al.leetcode.algorithms.stack;

import java.util.Stack;

/**
 * 删除字符串中的所有相邻重复项
 * 给出由小写字母组成的字符串 S，重复项删除操作会选择两个相邻且相同的字母，并删除它们。
 * 输入："abbaca"
 * 输出："ca"
 */
public class Lc1047 {

    public String removeDuplicates(String s) {
        String result = "";
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (!stack.empty() && stack.peek().equals(c)) {
                stack.pop();
            } else {
                stack.push(c);
            }
        }

        while (!stack.isEmpty()) {
            result = stack.pop() + result;
        }

        return result;
    }

    public String removeDuplicatesByArrays(String s) {
        char[] data = new char[s.length()];
        int index = 0;
        boolean append = true;
        for (char c : s.toCharArray()) {
            append = true;
            if ((index - 1) >= 0 && c == data[index - 1]) {
                index--;
                append = false;
            }
            if (append) {
                data[index++] = c;
            }
        }
        return new String(data, 0, index);
    }

    public static void main(String[] args) {
        String s = "abbaca";

        Lc1047 lc = new Lc1047();
        System.out.println(s + " ==> " + lc.removeDuplicates(s));
        System.out.println(s + " ==> " + lc.removeDuplicatesByArrays(s));
    }
}
