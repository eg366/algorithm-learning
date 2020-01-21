package com.eg366.al.leetcode.algorithms.linkedlist;

import com.eg366.al.leetcode.algorithms.vo.ListNode;

/**
 * 环形链表
 * 给定一个链表，判断链表中是否有环。
 * <p>
 * 为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。 如果 pos 是 -1，则在该链表中没有环。
 * <p>
 *
 * @Author: zhangjunyu
 * @Date: 2020/1/20 17:17
 */
public class Lc141 {

    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }

        ListNode slow = head;
        ListNode fast = head;

        while (fast.next != null && fast.next.next != null) {
            if (slow.val == fast.next.next.val) {
                return true;
            } else {
                slow = slow.next;
                fast = fast.next.next;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        ListNode head = ListNode.buildByString("32042");

        Lc141 lc = new Lc141();
        boolean hasCycle = lc.hasCycle(head);
        System.out.println(hasCycle);
    }
}
