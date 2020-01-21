package com.eg366.al.leetcode.algorithms.vo;

import org.apache.commons.lang3.StringUtils;

import java.util.HashSet;
import java.util.Set;

/**
 * 链表节点
 *
 * @Author: zhangjunyu
 * @Date: 2020/1/20 16:30
 */
public class ListNode {

    public int val;
    public ListNode next;

    public ListNode(int x) {
        this.val = x;
    }

    /**
     * 按照字符串参数data的字符顺序构建链表节点
     */
    public static ListNode buildByString(String data) {
        if (StringUtils.isEmpty(data)) {
            return null;
        }

        // 初始化头结点
        ListNode head = new ListNode(Integer.valueOf(String.valueOf(data.charAt(0))));
        ListNode pre = head;
        for (int i = 1; i < data.length(); i++) {
            ListNode cur = new ListNode(Integer.valueOf(String.valueOf(data.charAt(i))));
            pre.next = cur;
            pre = cur;
        }
        return head;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(val);
        Set<Integer> charSet = new HashSet<>();

        ListNode node = next;
        while (node != null) {
            int nodeVal = node.val;
            sb.append(" --> ").append(nodeVal);
            node = node.next;

            // 如果已经存在该节点值了，跳出循环。（针对有环的链表）
            if (!charSet.add(nodeVal)) {
                break;
            }
        }

        return sb.toString();
    }
}
