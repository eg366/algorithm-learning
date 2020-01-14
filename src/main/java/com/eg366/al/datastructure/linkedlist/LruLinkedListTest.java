package com.eg366.al.datastructure.linkedlist;

import com.eg366.al.vo.LruLinkedList;

/**
 * 实现LRU(Least Recently Used, 最近最少使用)淘汰算法链表的测试类
 *
 * @Author: zhangjunyu
 * @Date: 2020/1/14 16:14
 */
public class LruLinkedListTest {

    public static void main(String[] args) {
        LruLinkedList list = new LruLinkedList(3);

        System.out.println(list.getHeadNode());

        list.add("a");
        System.out.println(list.getHeadNode());

        list.add("b");
        System.out.println(list.getHeadNode());

        list.add("c");
        System.out.println(list.getHeadNode());

        list.add("b");
        System.out.println(list.getHeadNode());

        list.add("a");
        System.out.println(list.getHeadNode());

        list.add("b");
        System.out.println(list.getHeadNode());

        list.add("b");
        System.out.println(list.getHeadNode());

        list.add("c");
        System.out.println(list.getHeadNode());
    }
}
