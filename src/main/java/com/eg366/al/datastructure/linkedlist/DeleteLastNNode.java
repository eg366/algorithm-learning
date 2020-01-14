package com.eg366.al.datastructure.linkedlist;

import com.eg366.al.vo.ListNode;

import javax.swing.plaf.SliderUI;

/**
 * 删除链表倒数第n个节点
 *
 * @Author: zhangjunyu
 * @Date: 2020/1/14 11:33
 */
public class DeleteLastNNode {

    public static void main(String[] args) {
        ListNode node = ListNode.buildByString("abcdefg");
        System.out.println(node);

        int n = 1;
        ListNode delNode = delete(node, n);
        System.out.println(delNode);
    }

    private static ListNode delete(ListNode node, int n) {
        // 声明快、慢指针
        ListNode fast = node;
        ListNode slow = node;

        ListNode result = slow;

        // 快指针先走n步骤
        for (int i = 0; i < n; i++) {
            fast = fast.next;
        }

        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }

        slow.next = slow.next.next;

        return result;
    }
}
