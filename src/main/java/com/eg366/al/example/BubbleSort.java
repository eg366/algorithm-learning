package com.eg366.al.example;

import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * @Author: zhangjunyu
 * @Date: 2020/1/9 17:54
 */
public class BubbleSort {
    public static void main(String[] args) {
        int[] n = {3, 2, 9, 8, 1, 5};
        // n个数据，需执行(n-1)趟的排序
        for (int i = 0; i < n.length - 1; i++) {
            // 在第i趟的排序执行过程中，需要进行(n-1-i)次的数据比较
            for (int j = 0; j < n.length - 1 - i; j++) {
//                if (n[j] > n[j + 1]) {// 升序
                if (n[j] < n[j + 1]) {// 降序
                    int tmp = n[j];
                    n[j] = n[j + 1];
                    n[j + 1] = tmp;
                }
            }
        }

        System.out.println(ToStringBuilder.reflectionToString(n));
    }
}
