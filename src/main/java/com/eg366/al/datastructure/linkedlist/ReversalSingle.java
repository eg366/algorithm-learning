package com.eg366.al.datastructure.linkedlist;

import com.eg366.al.vo.ListNode;

/**
 * 单链表反转
 *
 * @Author: zhangjunyu
 * @Date: 2020/1/6 14:36
 */
public class ReversalSingle {

    public static void main(String[] args) {
        ListNode org = ListNode.buildByString("abcd");
        ListNode result = reverse01(org);
        System.out.println(result);
    }

    private static ListNode reverse01(ListNode head) {
        ListNode tail = null;
        if (head == null || head.next == null) {
            tail = head;
            return tail;
        }

        ListNode pre = null;
        while (head != null) {
            // 方式一
            /*tail = head;
            head = head.next;
            tail.next = pre;
            pre = tail;*/
            // 方式二
            ListNode tmp = head.next;
            head.next = tail;
            tail = head;
            head = tmp;
        }

        return tail;
    }
}
