package com.eg366.al.leetcode.algorithms.linkedlist;

import com.eg366.al.leetcode.algorithms.vo.ListNode;

/**
 * 二进制链表转整数
 * <p>
 * 给你一个单链表的引用结点 head。链表中每个结点的值不是 0 就是 1。已知此链表是一个整数数字的二进制表示形式。
 * 请你返回该链表所表示数字的 十进制值
 * <p>
 *
 * @Author: zhangjunyu
 * @Date: 2020/1/21 13:43
 */
public class Lc1290 {
    public int getDecimalValue(ListNode head) {
        // 先进行反转
        ListNode tail = null;
        ListNode pre = null;
        while (head != null) {
            tail = head;
            head = head.next;
            tail.next = pre;
            pre = tail;
        }

        System.out.println(tail);

        // 再按位计算
        int decimalVal = 0;
        int bit = 0;

        while (tail != null) {
            if (tail.val == 1) {
                decimalVal += Math.pow(2, bit);
            }
            bit++;
            tail = tail.next;
        }

        return decimalVal;
    }

    public int getDecimalValue2(ListNode head) {
        int sum = 0;
        while (head != null) {
            sum = sum * 2 + head.val;
            head = head.next;
        }
        return sum;
    }

    public static void main(String[] args) {
//        ListNode head = ListNode.buildByString("100100111000000");
        ListNode head = ListNode.buildByString("101");

        Lc1290 lc = new Lc1290();
//        int decimalVal = lc.getDecimalValue(head);
        int decimalVal = lc.getDecimalValue2(head);

        System.out.println(decimalVal);
    }
}
