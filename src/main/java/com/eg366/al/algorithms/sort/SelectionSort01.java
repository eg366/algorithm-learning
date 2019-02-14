package com.eg366.al.algorithms.sort;

import java.util.Arrays;

/**
 * 选择排序
 *
 * 不是稳定的排序算法
 *
 * 将集合分为已排序区间和未排序区间。初始状态，集合整体均属于未排序区间。
 * 每次循环中，会对未排序区间进行遍历，找到最小的值，将该值放到已排序区间的尾部。
 * @author juny-zhang
 * @date 2019/2/14 13:51
 */
public class SelectionSort01 {

    public void method01(int[] a) {
        if (a == null || a.length <= 1)
            return;

        int n = a.length;

        for (int i = 0; i < n; i++) {
            // 遍历查询最小值的索引号
            int minIndex = i;
            for (int j = i; j < n; j++) {
                if (a[j] < a[minIndex])
                    minIndex = j;
            }

            // 将未排序区间的最小值，放到已排序区间的末尾
            int tmp = a[i];
            a[i] = a[minIndex];
            a[minIndex] = tmp;
        }
    }

    public static void main(String[] args) {
        SelectionSort01 obj = new SelectionSort01();
        int[] a = new int[]{1, 5, 9, 3, 8, 2, 4};
        obj.method01(a);
        System.out.println(Arrays.toString(a));
    }
}
