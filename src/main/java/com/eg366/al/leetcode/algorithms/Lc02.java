package com.eg366.al.leetcode.algorithms;

import java.util.ArrayList;
import java.util.List;

/**
 * add-two-numbers
 * <p>
 * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 * 示例：
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 0 -> 8
 * 原因：342 + 465 = 807
 *
 * @author juny-zhang
 * @date 2019/2/15 14:25
 */
public class Lc02 {

    public ListNode method01(ListNode l1, ListNode l2) {
        List<Integer> list = new ArrayList<Integer>();

        int carry = 0;
        while ((l1 != null || l2 != null) || carry == 1) {
            int v1 = (l1 != null ? l1.val : 0);
            int v2 = (l2 != null ? l2.val : 0);
            int sum = v1 + v2 + carry;

            if (sum < 10) {
                carry = 0;
                list.add(sum);
            } else {
                carry = 1;
                list.add(sum % 10);
            }

            if (l1 != null)
                l1 = l1.next;
            if (l2 != null)
                l2 = l2.next;
        }

        ListNode result = new ListNode(list.get(0));
        ListNode current = result;
        for (int i = 1; i < list.size(); i++) {
            current.next = new ListNode(list.get(i));
            current = current.next;
        }

        return result;
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}