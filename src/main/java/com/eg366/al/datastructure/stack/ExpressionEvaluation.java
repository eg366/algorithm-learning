package com.eg366.al.datastructure.stack;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * 对包含“+-*\/”的四则运算字符串进行计算
 *
 * @Author: zhangjunyu
 * @Date: 2020/1/15 13:40
 */
public class ExpressionEvaluation {

    public static void main(String[] args) {
        String expression = "3+2*5-6/3+2";

        int result = evaluation(expression);

        System.out.println(expression + " = " + result);
    }


    private static int evaluation(String expression) {
        int result = 0;

        // 保存数字的栈
        Stack<Integer> numStack = new Stack<>();
        // 保存运算符号的栈
        Stack<String> symbolStack = new Stack<>();

        // 遍历字符
        for (int i = 0; i < expression.length(); i++) {
            char c = expression.charAt(i);
            // 如果是数字，压入数字栈中，跳出本次循环
            if (c >= '0' && c <= '9') {
                numStack.push(Integer.valueOf(c + ""));
                continue;
            }

            // 符号
            String symbol = String.valueOf(c);
            // 首个符号，或当前符号的优先级高于栈顶元素的优先级，直接压入符号栈中
            if (symbolStack.size() == 0 || symbolpriorityCompare(symbol, symbolStack.peek()) == 1) {
                symbolStack.push(String.valueOf(c));
            } else {
                // 当前符号的优先级低于或等于栈顶元素的优先级
                while (symbolStack.size() > 0 && symbolpriorityCompare(symbol, symbolStack.peek()) <= 1) {
                    // 进行计算并将结果压入数字栈中
                    int num = calculationByStack(numStack, symbolStack);
                    numStack.push(num);
                }
                // 将符号压入符号栈中
                symbolStack.push(String.valueOf(c));
            }
        }

        result = calculationByStack(numStack, symbolStack);

        return result;
    }

    private static Map<String, Integer> SYMBOL_PRIORITY_MAP = new HashMap() {{
        put("+", 0);
        put("-", 0);
        put("*", 1);
        put("/", 1);
    }};

    /**
     * 运算符号优先级比较
     *
     * @return 返回-1：s1优先级小于s2；返回0：优先级相同；返回1：s1优先级大于s2
     */
    private static int symbolpriorityCompare(String s1, String s2) {
        int p1 = SYMBOL_PRIORITY_MAP.get(s1);
        int p2 = SYMBOL_PRIORITY_MAP.get(s2);

        return p1 - p2;
    }

    /**
     * 根据stack进行计算
     */
    private static int calculationByStack(Stack<Integer> numStack, Stack<String> symbolStack) {
        // 取出数字栈顶的两个数字
        int preNum = numStack.pop();
        int prePreNum = numStack.pop();

        // 取出栈顶的符号
        String preSymbol = symbolStack.pop();

        // 计算结果
        return calculation(prePreNum, preNum, preSymbol);
    }

    /**
     * 四则运算
     */
    private static int calculation(int n1, int n2, String symbol) {
        switch (symbol) {
            case "+":
                return n1 + n2;
            case "-":
                return n1 - n2;
            case "*":
                return n1 * n2;
            case "/":
                return n1 / n2;
            default:
                return 0;
        }
    }
}
