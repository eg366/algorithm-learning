package com.eg366.al.algorithms.sort;

import java.util.Arrays;

/**
 * 快速排序
 */
public class QuickSort01 {

    private void sort(int[] a) {
        this.doSort(a, 0, a.length - 1);
    }

    /**
     * 递归执行排序
     *
     * @param a 数组
     * @param p 排序开始索引下标
     * @param r 排序结束索引下标
     */
    private void doSort(int[] a, int p, int r) {
        // 排序节点数量为1时
        if (p >= r) {
            return;
        }

        // 对数组进行分区，并返回分区下标
//        int q = this.partition01(a, p, r);
        int q = this.partition02(a, p, r);

        // 对前后分区再进行分区排序
        this.doSort(a, p, q - 1);
        this.doSort(a, q + 1, r);
    }

    /**
     * 选择一个点作为pivot（一般是最后一个元素），然后对p...r进行分区操作，小于pivot节点值的，放到前面，小于pivot节点值的，放到后面
     * 申请了额外的空间，非原地算法。
     * 原地算法，见partition02
     *
     * @param a 数组
     * @param p 待分区区域的起始节点
     * @param r 待分区区域的结束节点
     * @return 分区后，pivot所处的节点位置
     */
    private int partition01(int[] a, int p, int r) {
        // 小于pivot节点值的分区
        int[] x = new int[r - p + 1];
        // 大于pivot节点值的分区
        int[] y = new int[r - p + 1];
        int xIndex = 0, yIndex = 0;

        int pivotVal = a[r];

        for (int i = p; i < r; i++) {
            if (a[i] < pivotVal) {
                x[xIndex++] = a[i];
            } else {
                y[yIndex++] = a[i];
            }
        }
        int q = p + xIndex;

        xIndex = 0;
        yIndex = 0;
        // 将排序后的节点写会到a数组中
        for (int i = p; i <= r; i++) {
            if (i < q) {
                a[i] = x[xIndex++];
            } else if (i > q) {
                a[i] = y[yIndex++];
            } else {
                a[i] = pivotVal;
            }
        }
        return q;
    }

    /**
     * 原地的分区方式
     *
     * @param a 数组
     * @param p 待分区区域的起始节点
     * @param r 待分区区域的结束节点
     * @return 分区后，pivot所处的节点位置
     */
    private int partition02(int[] a, int p, int r) {
        // 选择下标为r的元素作为pivot节点
        int pivotVal = a[r];

        // 将数组划分为两个区域，初始i=p，小于i-1部分的区间为已处理的区间，存储值小于pivotVal的节点。[i...r-1]为未处理区域。
        // 每次从[i...r-1]中去一个节点j，如果小于pivotVal，放到与处理区间内，也就是a[i]的节点位置

        // 小于i-1部分的数据为已处理区间，存储的是小于pivotVal的所有值
        int i = p;
        for (int j = p; j < r; j++) {
            if (a[j] < pivotVal) {
                int tmp = a[i];
                a[i] = a[j];
                a[j] = tmp;
                i++;
            }
        }

        a[r] = a[i];
        a[i] = pivotVal;

        return i;
    }

    public static void main(String[] args) {
        QuickSort01 qs = new QuickSort01();

        int[] a = {2, 4, 6, 5, 3};
        int q = qs.partition02(a, 0, a.length - 1);
        System.out.println(q);

        a = new int[]{8, 10, 2, 3, 6, 1, 5};
        qs.sort(a);
        System.out.println(Arrays.toString(a));
    }
}