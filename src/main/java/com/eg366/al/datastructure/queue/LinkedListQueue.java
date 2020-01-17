package com.eg366.al.datastructure.queue;

import com.eg366.al.vo.ListNode;

import java.util.Optional;

/**
 * 基于链表实现的链式队列
 *
 * @Author: zhangjunyu
 * @Date: 2020/1/17 15:20
 */
public class LinkedListQueue {

    // 头节点
    private ListNode headNode;
    // 尾节点
    private ListNode tailNode;

    /**
     * 入队
     */
    public boolean enqueue(String item) {
        ListNode newNode = new ListNode(item);

        if (tailNode == null) {
            headNode = newNode;
            tailNode = newNode;
        } else {
            tailNode.next = newNode;
            tailNode = newNode;
        }

        return true;
    }

    /**
     * 出队
     */
    public String dequeue() {
        ListNode head = null;
        if (headNode != null) {
            head = headNode;
            headNode = headNode.next;
        }

        if (headNode == null) {
            tailNode = null;
        }

        return Optional.ofNullable(head).map(u -> u.val).orElse(null);
    }
}
