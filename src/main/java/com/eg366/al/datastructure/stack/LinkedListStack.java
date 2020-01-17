package com.eg366.al.datastructure.stack;

import com.eg366.al.vo.ListNode;

import java.util.Optional;

/**
 * 基于链表实现的链式栈（支持动态扩容）
 *
 * @Author: zhangjunyu
 * @Date: 2020/1/15 17:50
 */
public class LinkedListStack {

    // 哨兵（头）节点
    private ListNode guardNode;

    // 栈中元素的个数
    private int count;

    public LinkedListStack() {
        guardNode = new ListNode(null);
    }

    /**
     * 入栈操作
     */
    public boolean push(String data) {
        ListNode newNode = new ListNode(data);
        newNode.next = guardNode.next;
        guardNode.next = newNode;

        return true;
    }

    // 出栈操作
    public String pop() {
        ListNode node = guardNode.next;
        if (node != null) {
            guardNode.next = guardNode.next.next;
        }

        return Optional.ofNullable(node).map(u -> u.val).orElse(null);
    }
}
