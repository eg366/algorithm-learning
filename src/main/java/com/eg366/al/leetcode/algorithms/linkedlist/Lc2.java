package com.eg366.al.leetcode.algorithms.linkedlist;

import com.eg366.al.leetcode.algorithms.vo.ListNode;

/**
 * 两数相加
 * <p>
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 0 -> 8
 * 原因：342 + 465 = 807
 * </p>
 *
 * @Author: zhangjunyu
 * @Date: 2020/1/21 14:00
 */
public class Lc2 {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode l3 = new ListNode(0);
        ListNode resNode = l3;

        while (l1 != null || l2 != null) {
            int v1 = (l1 == null ? 0 : l1.val);
            int v2 = (l2 == null ? 0 : l2.val);
            int v3 = l3.val;

            l3.val = (v1 + v2 + v3) % 10;
            if ((v1 + v2 + v3) >= 10) {
                // 需要进位
                l3.next = new ListNode(1);
            } else if ((l1 != null && l1.next != null) || (l2 != null && l2.next != null)) {
                // 还有下一个节点
                l3.next = new ListNode(0);
            }

            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
            l3 = l3.next;
        }

        return resNode;
    }

    public static void main(String[] args) {
        ListNode l1 = ListNode.buildByString("243");
        ListNode l2 = ListNode.buildByString("564");

        Lc2 lc = new Lc2();
        ListNode resNode = lc.addTwoNumbers(l1, l2);

        System.out.println(resNode);
    }
}
