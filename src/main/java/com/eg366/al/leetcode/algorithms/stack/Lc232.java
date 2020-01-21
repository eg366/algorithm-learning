package com.eg366.al.leetcode.algorithms.stack;

import java.util.Stack;

/**
 * 用栈实现队列
 * <p>
 * 使用栈实现队列的下列操作：
 * push(x) -- 将一个元素放入队列的尾部。
 * pop() -- 从队列首部移除元素。
 * peek() -- 返回队列首部的元素。
 * empty() -- 返回队列是否为空。
 * </p>
 *
 * @Author: zhangjunyu
 * @Date: 2020/1/21 16:18
 */
public class Lc232 {

    private Stack<Integer> stack;

    /**
     * Initialize your data structure here.
     */
    public Lc232() {
        this.stack = new Stack<>();
    }

    /**
     * Push element x to the back of queue.
     */
    public void push(int x) {
        Stack<Integer> newStack = new Stack<>();
        newStack.push(x);

        Stack<Integer> tmp = new Stack<>();
        while (!this.stack.isEmpty()) {
            tmp.push(this.stack.pop());
        }

        while (!tmp.isEmpty()) {
            newStack.push(tmp.pop());
        }


        this.stack = newStack;
    }

    /**
     * Removes the element from in front of queue and returns that element.
     */
    public int pop() {
        if (this.stack.isEmpty()) {
            throw new RuntimeException("队列中元素为空");
        }
        return this.stack.pop();
    }

    /**
     * Get the front element.
     */
    public int peek() {
        if (this.stack.isEmpty()) {
            throw new RuntimeException("队列中元素为空");
        }
        return this.stack.peek();
    }

    /**
     * Returns whether the queue is empty.
     */
    public boolean empty() {
        return this.stack.isEmpty();
    }

    public static void main(String[] args) {
        Lc232 lc = new Lc232();
        lc.push(1);
        lc.push(2);
        lc.push(3);

        System.out.println(lc.pop());
        System.out.println(lc.pop());
        System.out.println(lc.pop());
    }
}
