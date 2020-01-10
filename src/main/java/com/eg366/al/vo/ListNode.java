package com.eg366.al.vo;

import org.apache.commons.lang3.StringUtils;

/**
 * @Author: zhangjunyu
 * @Date: 2020/1/3 17:47
 */
public class ListNode {
    public String val;
    public ListNode next;

    public ListNode(String x) {
        val = x;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(val);

        ListNode node = next;
        while (node != null) {
            sb.append(" --> ").append(node.val);
            node = node.next;
        }

        return sb.toString();
    }

    public static ListNode buildByString(String data) {
        if (StringUtils.isEmpty(data)) {
            return null;
        }

        // 初始化头结点
        ListNode head = new ListNode(String.valueOf(data.charAt(0)));
        ListNode pre = head;
        for (int i = 1; i < data.length(); i++) {
            ListNode cur = new ListNode(String.valueOf(data.charAt(i)));
            pre.next = cur;
            pre = cur;
        }
        return head;
    }
}
