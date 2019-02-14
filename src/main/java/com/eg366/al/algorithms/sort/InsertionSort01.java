package com.eg366.al.algorithms.sort;

import java.util.Arrays;

/**
 * 插入排序
 * 稳定的排序算法
 *
 * @author juny-zhang
 * @date 2019/2/14 10:03
 */
public class InsertionSort01 {

    public void method01(int[] a) {
        if (a == null || a.length <= 1)
            return;

        int n = a.length;

        // 将数组a分为两个区间（已排序区间和未排序区间）。已排序区间初始只有一个元素（即第一个元素）。
        for (int i = 1; i < n; i++) {
            // 取未排序区间中的元素，与已排序区间中的数据进行比较和移动，找到合适的位置将其插入。重复这个过程，直至未排序区间中元素为空
            int val = a[i];
            int j = i - 1;
            for (; j >= 0; j--) {
                if (a[j] > val) {
                    a[j + 1] = a[j];
                } else {
                    break;
                }
            }
            a[j + 1] = val;
        }
    }

    public static void main(String[] args) {
        InsertionSort01 obj = new InsertionSort01();
        int[] a = new int[]{1, 5, 9, 3, 8, 2, 4};
        obj.method01(a);
        System.out.println(Arrays.toString(a));

        int x = 1;
        System.out.println(~x);
    }
}
