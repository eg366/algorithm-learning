package com.eg366.al.leetcode.algorithms.linkedlist;

import com.eg366.al.leetcode.algorithms.vo.ListNode;

/**
 * 判断一个链表是否为回文链表
 *
 * @Author: zhangjunyu
 * @Date: 2020/1/21 10:54
 */
public class Lc234 {

    public boolean isPalindrome(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        ListNode reverseNode = null;
        ListNode reversePreNode = null;
        while (fast != null && fast.next != null) {
            // 快指针走两步
            fast = fast.next.next;

            // 慢指针走一步，并进行反转指向reverseNode
            reverseNode = slow;
            slow = slow.next;
            reverseNode.next = reversePreNode;
            reversePreNode = reverseNode;
        }

        if (fast != null) {
            slow = slow.next;
        }

        while (slow != null) {
            if (slow.val != reverseNode.val) {
                return false;
            }
            slow = slow.next;
            reverseNode = reverseNode.next;
        }

        return true;
    }

    public static void main(String[] args) {
        ListNode head = ListNode.buildByString("124421");

        Lc234 lc = new Lc234();
        System.out.println(lc.isPalindrome(head));
    }
}
