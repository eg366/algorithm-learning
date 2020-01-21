package com.eg366.al.leetcode.algorithms.linkedlist;

import com.eg366.al.leetcode.algorithms.vo.ListNode;

/**
 * 相交链表
 * 编写一个程序，找到两个单链表相交的起始节点。
 *
 * @Author: zhangjunyu
 * @Date: 2020/1/20 17:30
 */
public class Lc160 {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode ha = headA;
        ListNode hb = headB;

        // 计算两个链表的总长度
        int lengthA = 0, lengthB = 0;
        while (headA != null || headB != null) {
            if (headA != null) {
                headA = headA.next;
                lengthA++;
            }

            if (headB != null) {
                headB = headB.next;
                lengthB++;
            }
        }

        // 长度差值
        int lengthDiff = Math.abs(lengthA - lengthB);

        ListNode headLong, headShort;

        if (lengthA > lengthB) {
            headLong = ha;
            headShort = hb;
        } else {
            headLong = hb;
            headShort = ha;
        }

        // 去掉长度差值，让两个链表的剩余节点长度一致
        while (lengthDiff-- > 0) {
            headLong = headLong.next;
        }


        while (headLong != null) {
            if (headLong.val == headShort.val) {
                return headLong;
            } else {
                headLong = headLong.next;
                headShort = headShort.next;
            }
        }
        return null;
    }


    public static void main(String[] args) {
        ListNode headA = ListNode.buildByString("42845");
//        ListNode headA = ListNode.buildByString("8");
        ListNode headB = ListNode.buildByString("501845");

        Lc160 lc = new Lc160();
        ListNode intersectionNode = lc.getIntersectionNode(headA, headB);
        System.out.println(intersectionNode);
    }
}
