package com.eg366.al.leetcode.algorithms.stack;

import java.util.Stack;

/**
 * 最小栈
 * <p>
 * 设计一个支持 push，pop，top 操作，并能在常数时间内检索到最小元素的栈。
 * push(x) -- 将元素 x 推入栈中。
 * pop() -- 删除栈顶的元素。
 * top() -- 获取栈顶元素。
 * getMin() -- 检索栈中的最小元素。
 *
 * </p>
 *
 * @Author: zhangjunyu
 * @Date: 2020/1/21 15:23
 */
public class Lc155 {

    // 记录数据的栈
    private Stack<Integer> dataStack;
    // 记录当前min最小值的栈
    private Stack<Integer> helperStack;

    public Lc155() {
        this.dataStack = new Stack<>();
        this.helperStack = new Stack<>();
    }

    public void push(int x) {
        dataStack.push(x);
        helperStack.push(helperStack.isEmpty() ? x : Math.min(x, helperStack.peek()));
    }

    public void pop() {
        if (!dataStack.isEmpty()) {
            dataStack.pop();
            helperStack.pop();
        }
    }

    public int top() {
        if (dataStack.isEmpty()) {
            throw new RuntimeException("栈中元素为空");
        }

        return dataStack.peek();
    }

    public int getMin() {
        if (helperStack.isEmpty()) {
            throw new RuntimeException("栈中元素为空");
        }

        return helperStack.peek();
    }

    public static void main(String[] args) {
        Lc155 lc = new Lc155();
        lc.push(2);
        System.out.println(lc.getMin());
        lc.push(1);
        System.out.println(lc.getMin());
        lc.push(3);
        System.out.println(lc.getMin());
        lc.push(5);
        System.out.println(lc.getMin());
    }
}
