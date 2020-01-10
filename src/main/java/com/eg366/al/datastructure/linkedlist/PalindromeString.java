package com.eg366.al.datastructure.linkedlist;

import com.eg366.al.vo.ListNode;

/**
 * 回文字符串判断
 *
 * @Author: zhangjunyu
 * @Date: 2020/1/2 17:42
 */
public class PalindromeString {

    public static void main(String[] args) {
//        String str = "abcdeedcba";
        String str = "";
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

//        System.out.println(isPalindrome(head));
        System.out.println(isPalindrome2(head));
    }

    public static boolean isPalindrome2(ListNode head) {
        // 个数小于2，返回true
        if (head == null || head.next == null) {
            return true;
        }

        // 慢指针
        ListNode slow = head;
        // 快指针
        ListNode fast = head;

        // 保存颠倒后的前半部分
        ListNode reverse = head;
        ListNode pre = null;

        // 从头开始遍历，快指针走到结尾时，慢指针走一半
        while (fast != null && fast.next != null) {
            reverse = slow;
            // 慢指针：一次走一个
            slow = slow.next;
            // 快指针：一次走两个
            fast = fast.next.next;

            // "aba", "abccba"
            reverse.next = pre;
            pre = reverse;
        }

        System.out.println(reverse);

        // 如果
        if (fast != null) {
            slow = slow.next;
        }

        while (reverse != null) {
            if (!reverse.val.equals(slow.val)) {
                return false;
            }

            reverse = reverse.next;
            slow = slow.next;
        }

        return true;
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

