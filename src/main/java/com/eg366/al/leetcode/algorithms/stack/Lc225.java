package com.eg366.al.leetcode.algorithms.stack;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 用队列实现栈
 *
 * @Author: zhangjunyu
 * @Date: 2020/1/21 15:55
 */
public class Lc225 {

    private Queue<Integer> queue;

    /**
     * Initialize your data structure here.
     */
    public Lc225() {
        queue = new LinkedList<>();
    }

    /**
     * Push element x onto stack.
     */
    public void push(int x) {
        Queue<Integer> newQueue = new LinkedList<>();
        newQueue.offer(x);

        while (!queue.isEmpty()) {
            newQueue.offer(queue.poll());
        }

        queue = newQueue;
    }

    /**
     * Removes the element on top of the stack and returns that element.
     */
    public int pop() {
        if (this.queue.isEmpty()) {
            throw new RuntimeException("栈中元素为空");
        }
        return this.queue.poll();
    }

    /**
     * Get the top element.
     */
    public int top() {
        if (this.queue.isEmpty()) {
            throw new RuntimeException("栈中元素为空");
        }
        return this.queue.peek();
    }

    /**
     * Returns whether the stack is empty.
     */
    public boolean empty() {
        return this.queue.isEmpty();
    }

    public static void main(String[] args) {
        Lc225 lc = new Lc225();
        lc.push(1);
        lc.push(2);
        lc.push(3);

        System.out.println(lc.pop());
        System.out.println(lc.pop());
        System.out.println(lc.pop());
    }
}
