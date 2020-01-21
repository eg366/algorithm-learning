package com.eg366.al.leetcode.algorithms.linkedlist;

import com.eg366.al.leetcode.algorithms.vo.ListNode;

/**
 * 合并两个有序链表
 * 将两个有序链表合并为一个新的有序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
 *
 * @Author: zhangjunyu
 * @Date: 2020/1/20 16:27
 */
public class Lc21 {

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode l3 = new ListNode(0);
        ListNode guardNode = l3;

        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                l3.next = l1;
                l1 = l1.next;
            } else {
                l3.next = l2;
                l2 = l2.next;
            }
            l3 = l3.next;
        }

        if (l1 != null) {
            l3.next = l1;
        }

        if (l2 != null) {
            l3.next = l2;
        }

        return guardNode.next;
    }

    public static void main(String[] args) {
        Lc21 lc = new Lc21();
        ListNode l1 = ListNode.buildByString("124");
        ListNode l2 = ListNode.buildByString("134");
        ListNode l3 = lc.mergeTwoLists(l1, l2);

        System.out.println(l3);
    }
}
