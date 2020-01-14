package com.eg366.al.datastructure.linkedlist;

import com.eg366.al.vo.ListNode;

/**
 * 查找链表的中间节点
 *
 * @Author: zhangjunyu
 * @Date: 2020/1/14 13:53
 */
public class FindMiddleNode {

    public static void main(String[] args) {
        ListNode node = ListNode.buildByString("abcdefg");
        System.out.println(node);

        ListNode mNode = getMiddleNode(node);
        System.out.println(mNode.val);
    }

    private static ListNode getMiddleNode(ListNode node) {
        ListNode mNode = null;

        ListNode slowNode = node;
        ListNode fastNode = node;

        while (fastNode != null && fastNode.next != null) {
            fastNode = fastNode.next.next;
            slowNode = slowNode.next;
        }

        mNode = slowNode;

        return mNode;
    }
}
