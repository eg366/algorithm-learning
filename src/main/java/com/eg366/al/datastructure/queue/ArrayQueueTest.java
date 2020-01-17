package com.eg366.al.datastructure.queue;

/**
 * 基于数组实现的顺序队列 - 测试
 *
 * @Author: zhangjunyu
 * @Date: 2020/1/17 15:14
 */
public class ArrayQueueTest {

    public static void main(String[] args) {
        ArrayQueue queue = new ArrayQueue(2);
        queue.enqueue("a");
        queue.enqueue("b");
        queue.enqueue("c");

        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());

        queue.enqueue("d");
        queue.enqueue("e");
        queue.enqueue("f");

        System.out.println(queue.dequeue());
    }
}
