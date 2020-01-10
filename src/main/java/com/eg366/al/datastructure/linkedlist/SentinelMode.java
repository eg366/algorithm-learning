package com.eg366.al.datastructure.linkedlist;

import com.eg366.al.vo.ListNode;

import javax.sound.midi.Soundbank;
import java.util.List;

/**
 * 利用哨兵，可简化操作
 *
 * @Author: zhangjunyu
 * @Date: 2020/1/3 17:14
 */
public class SentinelMode {
    public static void main(String[] args) {
        ListNode node = ListNode.buildByString("abcdzyx");
        System.out.println(node);

        insertTest();
    }

    public static void insertTest() {
        // 在b后插入c
        ListNode node = ListNode.buildByString("abd");
        ListNode c = new ListNode("c");

        ListNode b = node.next;
        c.next = b.next;
        b.next = c;

        System.out.println(node);
    }
}
