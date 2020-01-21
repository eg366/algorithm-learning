package com.eg366.al.leetcode.algorithms.linkedlist;

import com.eg366.al.leetcode.algorithms.vo.ListNode;

/**
 * 反转单链表
 *
 * @Author: zhangjunyu
 * @Date: 2020/1/21 10:02
 */
public class Lc206 {
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode reverseNode = new ListNode(head.val);

        while (head.next != null) {
            ListNode tmp = new ListNode(head.next.val);
            tmp.next = reverseNode;
            reverseNode = tmp;
            head = head.next;
        }

        return reverseNode;
    }

    public ListNode reverseList02(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode tail = null;
        ListNode pre = null;
        while (head != null) {
            tail = head;
            head = head.next;
            tail.next = pre;
            pre = tail;
        }

        return tail;
    }

    public static void main(String[] args) {
        ListNode head = ListNode.buildByString("12345");

        Lc206 lc = new Lc206();
//        ListNode resNode = lc.reverseList(head);
        ListNode resNode = lc.reverseList02(head);

        System.out.println(resNode);
    }
}
