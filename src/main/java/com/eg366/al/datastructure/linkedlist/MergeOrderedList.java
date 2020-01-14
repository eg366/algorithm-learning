package com.eg366.al.datastructure.linkedlist;

import com.eg366.al.vo.ListNode;

/**
 * 合并有序链表
 *
 * @Author: zhangjunyu
 * @Date: 2020/1/13 17:07
 */
public class MergeOrderedList {

    public static void main(String[] args) {
//        ListNode node1 = ListNode.buildByString("aceghkm");
        ListNode node1 = ListNode.buildByString("aceghkm");
        System.out.println("node1: " + node1);
//        ListNode node2 = ListNode.buildByString("bdfijln");
        ListNode node2 = ListNode.buildByString("bdfijlno");
        System.out.println("node2: " + node2);

        ListNode node3 = merge(node1, node2);
        System.out.println("node3: " + node3);
    }

    private static ListNode merge(ListNode node1, ListNode node2) {
        // baseNode: 基础节点; forNode: 执行外层for循环的节点
        ListNode baseNode, forNode;
        // 将头节点值小的作为baseNode
        if (node1.val.compareTo(node2.val) <= 0) {
            baseNode = node1;
            forNode = node2;
        } else {
            baseNode = node2;
            forNode = node1;
        }

        // 哨兵节点
//        ListNode headNode = new ListNode("");
        ListNode mergedNode = baseNode;
        ListNode headNode = mergedNode;

        // 从baseNode的第二个节点开始遍历
        baseNode = baseNode.next;
        while (forNode != null) {
            String forVal = forNode.val;

            // 当不存在baseNode节点时
            if (baseNode == null) {
                // 插入余下的forNode节点
                mergedNode.next = forNode;

                // 跳出循环
                break;
            }

            while (baseNode != null) {
                // 当 forVal小于baseNode.val，插入forNode节点
                if (forVal.compareTo(baseNode.val) < 0) {
                    mergedNode.next = forNode;
                    mergedNode = mergedNode.next;

                    forNode = forNode.next;
                    // 跳出循环，遍历下一个forNode节点
                    break;
                } else {
                    // 查询baseNode节点
                    mergedNode.next = baseNode;
                    mergedNode = mergedNode.next;

                    baseNode = baseNode.next;
                }
            }
        }

        // 如果还存在baseNode节点，插入余下baseNode节点
        if (baseNode != null) {
            mergedNode.next = baseNode;
        }

        return headNode;
    }
}
