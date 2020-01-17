package com.eg366.al.datastructure.queue;

/**
 * 基于链表实现的链式队列 - 测试
 *
 * @Author: zhangjunyu
 * @Date: 2020/1/17 15:25
 */
public class LinkedListQueueTest {

    public static void main(String[] args) {
        LinkedListQueue queue = new LinkedListQueue();
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
