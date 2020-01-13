package com.eg366.al.datastructure.linkedlist;

import com.eg366.al.vo.ListNode;

/**
 * 链表中环的检测
 *
 * @Author: zhangjunyu
 * @Date: 2020/1/7 20:08
 */
public class LoopCheck {

    public static void main(String[] args) {
        // 构建节点（带环的）
        ListNode node = ListNode.buildLookByString("abcdefg", "t");
        System.out.println(node);

        // 检测是否带环
        boolean result = check01(node);
        System.out.println(result);
    }

    private static boolean check01(ListNode node) {
        ListNode slow = node;
        ListNode fast = node;

        // 如果快、慢节点相遇，表示在链表中存在环. 如果不存在环，会出现.next为空的时候
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow.equals(fast)) {
                return true;
            }
        }

        return false;
    }
}
