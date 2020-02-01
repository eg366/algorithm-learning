package com.eg366.al.leetcode.algorithms.stack;

import java.util.Stack;

/**
 * 比较含退格的字符串<br/
 * 给定 S 和 T 两个字符串，当它们分别被输入到空白的文本编辑器后，判断二者是否相等，并返回结果。 # 代表退格字符。
 */
public class Lc844 {

    public boolean backspaceCompare(String S, String T) {
        return getProcessedStr(S).equals(getProcessedStr(T));
    }


    private Stack<String> getProcessedStr(String org) {
        Stack<String> stack = new Stack<>();
        for (int i = 0; i < org.length(); i++) {
            String c = String.valueOf(org.charAt(i));
            if ("#".equals(c)) {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            } else {
                stack.push(c);
            }
        }

        return stack;
    }

    public static void main(String[] args) {
        String S = "ab#c", T = "ad#c";

        S = "y#fo##f";
        T = "y#f#o##f";

        Lc844 lc = new Lc844();
        boolean result = lc.backspaceCompare(S, T);
        System.out.println(result);
    }
}
