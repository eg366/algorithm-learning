package com.eg366.al.datastructure.stack;

/**
 * 基于数组实现的顺序栈（支持动态扩容）
 *
 * @Author: zhangjunyu
 * @Date: 2020/1/15 17:14
 */
public class ArrayStack {
    // 数组
    private String[] item;
    // 栈的大小
    private int n;
    // 栈中元素的个数
    private int count;

    public ArrayStack(int n) {
        this.n = n;
        this.count = 0;
        item = new String[this.n];
    }

    /**
     * 入栈操作
     */
    public boolean push(String data) {
        // 当栈中元素个数等于栈大小时，对栈进行扩容
        if (count == n) {
            n = 2 * n;
            String[] newItem = new String[n];
            System.arraycopy(item, 0, newItem, 0, count);
            item = newItem;
        }

        // 将元素添加到数组中
        item[count++] = data;
        return true;
    }

    // 出栈操作
    public String pop() {
        if (count == 0) {
            return null;
        }

        return item[--count];
    }
}
