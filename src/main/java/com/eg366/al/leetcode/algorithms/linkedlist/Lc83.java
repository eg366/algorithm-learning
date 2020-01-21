package com.eg366.al.leetcode.algorithms.linkedlist;

import com.eg366.al.leetcode.algorithms.vo.ListNode;

/**
 * 删除排序链表中的重复元素
 * 给定一个排序链表，删除所有重复的元素，使得每个元素只出现一次
 *
 * @Author: zhangjunyu
 * @Date: 2020/1/20 16:51
 */
public class Lc83 {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode guardNode = head;
        while (head.next != null) {
            if (head.next.val == head.val) {
                head.next = head.next.next;
            } else {
                head = head.next;
            }
        }

        return guardNode;
    }

    public static void main(String[] args) {
//        ListNode head = ListNode.buildByString("112");
        ListNode head = ListNode.buildByString("11233");

        Lc83 lc = new Lc83();
        ListNode result = lc.deleteDuplicates(head);

        System.out.println(result);
    }
}
