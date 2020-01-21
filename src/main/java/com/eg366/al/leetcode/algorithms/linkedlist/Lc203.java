package com.eg366.al.leetcode.algorithms.linkedlist;

import com.eg366.al.leetcode.algorithms.vo.ListNode;

/**
 * 移除链表元素
 * 删除链表中等于给定值 val 的所有节点。
 *
 * @Author: zhangjunyu
 * @Date: 2020/1/21 9:36
 */
public class Lc203 {

    public ListNode removeElements(ListNode head, int val) {
        ListNode node = new ListNode(0);
        node.next = head;
        ListNode guardNode = node;

        while (node.next != null) {
            if (node.next.val == val) {
                node.next = node.next.next;
            } else {
                node = node.next;
            }
        }

        return guardNode.next;
    }

    public static void main(String[] args) {
//        ListNode head = ListNode.buildByString("61263456");
        ListNode head = ListNode.buildByString("6");
        int val = 6;

        Lc203 lc = new Lc203();
        ListNode resNode = lc.removeElements(head, val);

        System.out.println(resNode);
    }
}
