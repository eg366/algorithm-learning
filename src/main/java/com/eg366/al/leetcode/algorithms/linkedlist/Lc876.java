package com.eg366.al.leetcode.algorithms.linkedlist;

import com.eg366.al.leetcode.algorithms.vo.ListNode;

/**
 * 给定一个带有头结点 head 的非空单链表，返回链表的中间结点。
 * 如果有两个中间结点，则返回第二个中间结点。
 *
 * @Author: zhangjunyu
 * @Date: 2020/1/21 11:59
 */
public class Lc876 {
    public ListNode middleNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    public static void main(String[] args) {
        ListNode head = ListNode.buildByString("123456");

        Lc876 lc = new Lc876();
        ListNode middleNode = lc.middleNode(head);

        System.out.println(middleNode);
    }
}
