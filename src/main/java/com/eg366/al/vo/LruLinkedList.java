package com.eg366.al.vo;

import java.util.HashSet;
import java.util.Set;

/**
 * 实现LRU(Least Recently Used, 最近最少使用)淘汰算法的链表
 *
 * @Author: zhangjunyu
 * @Date: 2020/1/14 16:15
 */
public class LruLinkedList {

    // 总容量
    private int capacity;
    // 已使用长度
    private int length = 0;
    // 头节点
    private ListNode headNode;
    // 存储已使用元素的集合
    private Set<String> valSet = new HashSet<>();

    private ListNode guardNode = new ListNode(null);


    /**
     * 构造方法
     *
     * @param capacity 指定链表长度
     */
    public LruLinkedList(int capacity) {
        this.capacity = capacity;
    }

    /**
     * 添加节点
     *
     * @param x 节点值
     */
    public void add(String x) {
        // 判断当前链表中是否存在
        if (valSet.contains(x)) {
            if (x.equals(guardNode.next.val)) {
                // 当前第一个节点为x时，返回
                return;
            }
            // 在链表中已存在，将其从原位置中删除，并添加到头节点
            ListNode node = guardNode.next;
            while (!x.equals(node.next.val)) {
                node = node.next;
            }

            // 是否在最后一个节点
            if (node.next.next == null) {
                // 删除最后一个节点
                node.next = null;
            } else {
                node.next = node.next.next;
            }
            length--;

        } else {
            // 链表是否已用满
            if (length == capacity) {
                // 删除最后一个节点
                ListNode node = guardNode.next;
                while (node.next != null) {
                    node = node.next;
                }
                node.next = null;
                length--;
            }
        }

        // 在新节点放到链表的头部
        addToHead(new ListNode(x));

    }


    /**
     * 在头结点插入元素
     */
    private void addToHead(ListNode newNode) {
        newNode.next = guardNode.next;
        guardNode.next = newNode;

        valSet.add(newNode.val);
        length++;
    }

    /**
     * 获取头结点
     */
    public ListNode getHeadNode() {
        return guardNode.next;
    }
}