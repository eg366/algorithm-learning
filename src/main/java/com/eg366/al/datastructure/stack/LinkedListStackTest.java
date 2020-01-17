package com.eg366.al.datastructure.stack;

/**
 * 基于链表实现的链式栈 - 测试类
 *
 * @Author: zhangjunyu
 * @Date: 2020/1/17 13:42
 */
public class LinkedListStackTest {

    public static void main(String[] args) {
        LinkedListStack stack = new LinkedListStack();
        stack.push("a");
        stack.push("b");
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());

        stack.push("c");
        stack.push("d");
        stack.push("e");
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
    }
}
