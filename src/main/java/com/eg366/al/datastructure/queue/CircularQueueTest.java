package com.eg366.al.datastructure.queue;

/**
 * 基于数组实现的循环队列（不支持扩展） - 测试
 *
 * @Author: zhangjunyu
 * @Date: 2020/1/17 17:10
 */
public class CircularQueueTest {

    public static void main(String[] args) {
        CircularQueue queue = new CircularQueue(4);

        System.out.println(queue.enqueue("a"));
        System.out.println(queue.enqueue("b"));
        System.out.println(queue.enqueue("c"));
        System.out.println(queue.enqueue("d"));

        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
    }
}