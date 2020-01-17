package com.eg366.al.datastructure.queue;

/**
 * 基于数组实现的循环队列（不支持扩展）
 *
 * @Author: zhangjunyu
 * @Date: 2020/1/17 16:25
 */
public class CircularQueue {


    // 实现队列的数组
    private String[] items;
    // 数组大小
    private int capacity;

    // 队列头、尾下标
    private int head = 0;
    private int tail = 0;

    public CircularQueue(int capacity) {
        this.capacity = capacity;
        items = new String[this.capacity];
    }

    /**
     * 入队
     */
    public boolean enqueue(String item) {
        // 队列已满
        if ((tail + 1) % capacity == head) {
            return false;
        }

        items[tail++] = item;

        if (tail == capacity) {
            tail = 0;
        }

        return true;
    }

    /**
     * 出队
     */
    public String dequeue() {
        // 队列为空
        if (tail == head) {
            return null;
        }

        String val = items[head++];
        if (head == capacity) {
            head = 0;
        }

        return val;
    }
}
