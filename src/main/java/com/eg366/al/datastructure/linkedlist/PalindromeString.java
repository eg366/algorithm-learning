package com.eg366.al.datastructure.linkedlist;

/**
 * 回文字符串判断
 *
 * @Author: zhangjunyu
 * @Date: 2020/1/2 17:42
 */
public class PalindromeString {

    public static void main(String[] args) {
        String str = "abcddcba";
//        String str = "abcddddd";
        ListNode head = null;
        ListNode pre = null;
        for (int i = 0; i < str.length(); i++) {
            ListNode cur = new ListNode(String.valueOf(str.charAt(i)));
            if (head == null) {
                head = cur;
                pre = cur;
            } else {
                pre.next = cur;
                pre = cur;
            }
        }

        System.out.println(head);

        System.out.println(isPalindrome(head));
    }

    public static boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }

        ListNode prev = null;
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            ListNode next = slow.next;
            slow.next = prev;
            prev = slow;
            slow = next;
        }

        if (fast != null) {
            slow = slow.next;
        }

        while (slow != null) {
            if (!slow.val.equals(prev.val)) {
                return false;
            }
            slow = slow.next;
            prev = prev.next;
        }

        return true;
    }
}


class ListNode {
    String val;
    ListNode next;

    ListNode(String x) {
        val = x;
    }
}

