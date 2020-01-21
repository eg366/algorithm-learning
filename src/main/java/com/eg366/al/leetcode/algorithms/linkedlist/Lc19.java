package com.eg366.al.leetcode.algorithms.linkedlist;

import com.eg366.al.leetcode.algorithms.vo.ListNode;

/**
 * 删除链表的倒数第N个节点
 *
 * <p>
 * 给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。
 * 给定一个链表: 1->2->3->4->5, 和 n = 2.
 * 当删除了倒数第二个节点后，链表变为 1->2->3->5.
 * </p>
 *
 * @Author: zhangjunyu
 * @Date: 2020/1/21 14:32
 */
public class Lc19 {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode guardNode = new ListNode(0);
        guardNode.next = head;
        ListNode resNode = guardNode;

        ListNode slow = guardNode;
        ListNode fast = guardNode;

        // 快指针先比慢指针夺走n步骤
        while (n-- > 0) {
            fast = fast.next;
        }

        // 快慢指针同时走，直至fast.next为空
        while (fast != null && fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }

        slow.next = slow.next.next;

        return resNode.next;
    }

    public static void main(String[] args) {
//        ListNode head = ListNode.buildByString("12345");
//        ListNode head = ListNode.buildByString("12");
        ListNode head = ListNode.buildByString("2");
        int n = 1;

        Lc19 lc = new Lc19();
        ListNode resNode = lc.removeNthFromEnd(head, n);
        System.out.println(resNode);
    }
}
