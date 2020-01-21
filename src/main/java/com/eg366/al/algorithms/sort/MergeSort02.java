package com.eg366.al.algorithms.sort;

import java.util.Arrays;

/**
 * 归并排序
 *
 * @Author: zhangjunyu
 * @Date: 2020/1/20 14:38
 */
public class MergeSort02 {

    private void mergeSort(int[] a) {
        this.doMergetSourt(a, 0, a.length - 1);
    }

    private void doMergetSourt(int[] a, int beginPos, int endPos) {
        if (beginPos == endPos) {
            return;
        }
        int midPos = beginPos + (endPos - beginPos) / 2;

        this.doMergetSourt(a, beginPos, midPos);
        this.doMergetSourt(a, midPos + 1, endPos);

        this.merge(a, beginPos, midPos, endPos);
    }

    private void merge(int[] a, int beginPos, int midPos, int endPos) {

    }

    public static void main(String[] args) {
        MergeSort02 obj = new MergeSort02();
        int[] a = new int[]{1, 5, 9, 3, 8, 2, 4};
        obj.mergeSort(a);
        System.out.println(Arrays.toString(a));
    }
}
