package com.eg366.al.algorithms.sort;

import java.util.Arrays;

/**
 * 排序练习
 */
public class SortPractice01 {

    public static void main(String[] args) {
        int[] a = {4, 5, 6, 3, 2, 1};

        // 升序排列
        SortPractice01 s = new SortPractice01();
        // 冒泡排序
        s.bubbleSort(a);
        System.out.println(Arrays.toString(a));

        // 插入排序
        a = new int[]{4, 5, 6, 3, 2, 1};
        s.insertSort(a);
        System.out.println(Arrays.toString(a));

        // 选择排序
        a = new int[]{4, 5, 6, 3, 2, 1};
        a = new int[]{1, 5, 9, 3, 8, 2, 4};
        s.selectionSort(a);
        System.out.println(Arrays.toString(a));

        // 归并排序
        a = new int[]{4, 5, 6, 3, 2, 1};
        a = new int[]{1, 5, 9, 3, 8, 2, 4};
        s.mergeSort(a);
        System.out.println(Arrays.toString(a));
    }

    /**
     * 归并排序
     */
    private void mergeSort(int[] a) {
        this.doMergeSort(a, 0, a.length - 1);
    }

    private void doMergeSort(int[] a, int p, int r) {
        if (p == r) {
            return;
        }

        int q = (p + r) / 2;
        this.doMergeSort(a, p, q);
        this.doMergeSort(a, q + 1, r);
        this.merge(a, p, q, r);
    }

    /**
     * 按大小顺序合并数组，两个参数数组均为有序的。第一个数组：[p, q]；第二个数组：[q+1, r]
     */
    private void merge(int[] a, int p, int q, int r) {
        int[] b = new int[a.length];

        int index = p;
        int i = p, j = q + 1;
        while (i <= q && j <= r) {
            if (a[i] < a[j]) {
                b[index++] = a[i++];
            } else {
                b[index++] = a[j++];
            }
        }

        while (i <= q) {
            b[index++] = a[i++];
        }
        while (j <= r) {
            b[index++] = a[j++];
        }

        for (int c = p; c <= r; c++) {
            a[c] = b[c];
        }
    }

    /**
     * 选择排序
     */
    private void selectionSort(int[] a) {
        // 初始状态，已排序区：空；未排序区：所有元素；
        // 每次从未排序区间中找到最小的元素，将其放到已排序区间的末尾。

        // 待处理的已排序区域的节点
        for (int i = 0; i < a.length - 1; i++) {
            int minIndex = i;
            int minVal = a[i];
            // 从未排序区域中选择最大的元素，与index节点元素值进行互换
            int j = minIndex + 1;
            for (; j < a.length; j++) {
                if (a[j] < minVal) {
                    minIndex = j;
                    minVal = a[j];
                }
            }
            int tmp = a[i];
            a[i] = a[minIndex];
            a[minIndex] = tmp;
        }
    }

    /**
     * 插入排序
     */
    private void insertSort(int[] a) {
        // 起始状态，已排序区：第一个元素(1个元素)；未排序区：第二个及之后的所有元素（n-1个元素）
        // 遍历未排序区的数据
        for (int i = 1; i < a.length; i++) {
            int value = a[i];
            // 与已排序区的逐一比较（从尾开始）
            int j = i - 1;
            for (; j >= 0; j--) {
                // 当遍历到的已排序元素大于当前未排序元素时，节点向后移动
                if (a[j] > value) {
                    a[j + 1] = a[j];
                } else {
                    break;
                }
            }
            a[j + 1] = value;
        }
    }

    /**
     * 冒泡排序
     */
    private void bubbleSort(int[] a) {
        for (int i = 0; i < a.length - 1; i++) {
            for (int j = 0; j < a.length - 1; j++) {
                if (a[j] > a[j + 1]) {
                    int tmp = a[j + 1];
                    a[j + 1] = a[j];
                    a[j] = tmp;
                }
            }
        }
    }
}
