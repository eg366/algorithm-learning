package com.eg366.al.vo;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import java.util.HashSet;
import java.util.Set;

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
        Set<String> charSet = new HashSet<>();

        ListNode node = next;
        while (node != null) {
            String nodeVal = node.val;
            sb.append(" --> ").append(nodeVal);
            node = node.next;

            // 如果已经存在该节点值了，跳出循环。（针对有环的链表）
            if (!charSet.add(nodeVal)) {
                break;
            }
        }

        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        ListNode listNode = (ListNode) o;

        return new EqualsBuilder()
                .append(val, listNode.val)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(val)
                .toHashCode();
    }

    /**
     * 按照字符串参数data的字符顺序构建链表节点
     */
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

    /**
     * 构建存在环的链表
     *
     * @param data     链表节点数据
     * @param overChar 将链表尾.next指向值为overChar的链表节点
     * @return 链表头节点
     */
    public static ListNode buildLookByString(String data, String overChar) {
        // 先构建链表
        ListNode head = buildByString(data);

        // 将链表尾节点.next，指向值为overChar的节点
        ListNode overNode = null, tailNode = head;

        // 遍历获取尾节点，并将overNode指向值为overChar的节点
        while (tailNode.next != null) {
            if (overNode == null && overChar.equals(tailNode.val)) {
                overNode = tailNode;
            }

            tailNode = tailNode.next;
        }

        // 如果存在overNode节点，将尾结点.next指向它
        if (overNode != null) {
            tailNode.next = overNode;
        }


        return head;
    }
}
