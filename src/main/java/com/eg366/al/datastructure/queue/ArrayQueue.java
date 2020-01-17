package com.eg366.al.datastructure.queue;

/**
 * 基于数组实现的顺序队列
 *
 * @Author: zhangjunyu
 * @Date: 2020/1/17 13:59
 */
public class ArrayQueue {

    // 实现队列的数组
    private String[] items;
    // 数组大小
    private int capacity;

    // 队列头、尾下标
    private int head = 0;
    private int tail = 0;

    public ArrayQueue(int capacity) {
        this.capacity = capacity;
        items = new String[this.capacity];
    }

    /**
     * 入队
     */
    public boolean enqueue(String item) {
        // 进行扩容
        if (tail == capacity) {
            capacity = 2 * capacity;
            String[] newItems = new String[capacity];
            System.arraycopy(items, head, newItems, 0, (tail - head));
            items = newItems;

            tail = tail - head;
            head = 0;
        }

        items[tail++] = item;

        return true;
    }

    /**
     * 出队
     */
    public String dequeue() {
        if (head == tail) {
            return null;
        }

        return items[head++];
    }
}
