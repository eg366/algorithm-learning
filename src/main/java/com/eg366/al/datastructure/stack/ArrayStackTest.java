package com.eg366.al.datastructure.stack;

/**
 * 基于数组实现的顺序栈 - 测试类
 *
 * @Author: zhangjunyu
 * @Date: 2020/1/15 17:44
 */
public class ArrayStackTest {

    public static void main(String[] args) {
        ArrayStack stack = new ArrayStack(2);
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
