package com.eg366.al.leetcode.algorithms.stack;

import java.util.Stack;

/**
 * 你现在是棒球比赛记录员。
 * 给定一个字符串列表，每个字符串可以是以下四种类型之一：
 * 1.整数（一轮的得分）：直接表示您在本轮中获得的积分数。
 * 2. "+"（一轮的得分）：表示本轮获得的得分是前两轮有效 回合得分的总和。
 * 3. "D"（一轮的得分）：表示本轮获得的得分是前一轮有效 回合得分的两倍。
 * 4. "C"（一个操作，这不是一个回合的分数）：表示您获得的最后一个有效 回合的分数是无效的，应该被移除。
 * <p>
 * 每一轮的操作都是永久性的，可能会对前一轮和后一轮产生影响。
 * 你需要返回你在所有回合中得分的总和。
 * <p>
 * 输入: ["5","2","C","D","+"]
 * 输出: 30
 */
public class Lc682 {

    /**
     * 通过stack实现
     */
    public int calPoints(String[] ops) {
        int result = 0;
        Stack<Integer> stack = new Stack<>();
        for (String c : ops) {
            switch (c) {
                case "+":
                    int pre = stack.pop();
                    int prePre = stack.pop();
                    stack.push(prePre);
                    stack.push(pre);
                    stack.push(pre + prePre);
                    result += stack.peek();
                    break;
                case "D":
                    stack.push(stack.peek() * 2);
                    result += stack.peek();
                    break;
                case "C":
                    result -= stack.pop();
                    break;
                default:
                    stack.push(Integer.valueOf(c));
                    result += stack.peek();
            }
        }

        return result;
    }

    /**
     * 通过数组实现，比通过stack方式执行时间短
     */
    public int calPointsByArray(String[] ops) {
        int result = 0;
        int step = 0;
        int[] stepScore = new int[ops.length];
        for (String c : ops) {
            switch (c) {
                case "+":
                    int pre = stepScore[step - 1];
                    int prePre = stepScore[step - 2];

                    stepScore[step] = pre + prePre;
                    result += stepScore[step];
                    step++;
                    break;
                case "D":
                    pre = stepScore[step - 1];
                    stepScore[step] = pre * 2;
                    result += stepScore[step];
                    step++;
                    break;
                case "C":
                    result -= stepScore[step - 1];
                    stepScore[step - 1] = 0;
                    step--;
                    break;
                default:
                    stepScore[step] = Integer.valueOf(c);
                    result += stepScore[step];
                    step++;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        String[] ops = new String[]{"5", "2", "C", "D", "+"};

        Lc682 lc = new Lc682();
//        int result = lc.calPoints(ops);
        int result = lc.calPointsByArray(ops);
        System.out.println(result);
    }
}
