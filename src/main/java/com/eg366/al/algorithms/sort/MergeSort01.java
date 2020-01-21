package com.eg366.al.algorithms.sort;

import java.util.Arrays;

/**
 * 归并排序
 *
 * @Author: zhangjunyu
 * @Date: 2020/1/20 10:11
 */
public class MergeSort01 {

    /**
     * 通过递归代码实现归并排序
     */
    private int[] method01(int[] a) {
        return this.md01MergeSort(a, 0, a.length - 1);
    }

    private int[] md01MergeSort(int[] a, int beginPos, int endPos) {
        int n = a.length;
        if (n == 1) {
            return a;
        }

        int middlePos = n / 2;
        int[] x = new int[middlePos];
        System.arraycopy(a, beginPos, x, 0, x.length);
        int[] y = new int[n - middlePos];
        System.arraycopy(a, middlePos, y, 0, y.length);
        return this.merge01(this.md01MergeSort(x, 0, x.length), this.md01MergeSort(y, 0, y.length));
    }

    /**
     * 按照顺序合并x, y数组中的元素
     */
    private int[] merge01(int[] x, int[] y) {
        int[] a = new int[x.length + y.length];

        // i: 数组x的下标; j: 数组y的下标
        int i = 0, j = 0;
        // 数组a的下标
        int k = 0;

        while (i < x.length || j < y.length) {
            if (i == x.length) {
                // x数组已取完
                a[k++] = y[j++];
            } else if (j == y.length) {
                // y数组已取完
                a[k++] = x[i++];
            } else {
                // 均有值时，进行比较
                int xv = x[i];
                int yv = y[j];
                if (xv < yv) {
                    a[k++] = x[i++];
                } else {
                    a[k++] = y[j++];
                }
            }

        }

        return a;
    }

    public static void main(String[] args) {
        MergeSort01 obj = new MergeSort01();
        int[] a = new int[]{1, 5, 9, 3, 8, 2, 4};
        int[] res = obj.method01(a);
        System.out.println(Arrays.toString(res));
    }
}
