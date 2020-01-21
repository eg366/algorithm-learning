package com.eg366.al.leetcode.algorithms.linkedlist;

import com.eg366.al.leetcode.algorithms.vo.ListNode;

/**
 * 删除链表中的节点
 *
 * @Author: zhangjunyu
 * @Date: 2020/1/21 11:28
 */
public class Lc237 {
    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }

    public static void main(String[] args) {
        ListNode head = ListNode.buildByString("4519");

        ListNode node = head;
        node = node.next;

        Lc237 lc = new Lc237();
        lc.deleteNode(node);
        System.out.println(head);
    }
}
