package com.eg366.al.algorithms.sort;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;

/**
 * 计数排序
 */
public class CountingSort {

    private static final Logger LOGGER = LoggerFactory.getLogger(CountingSort.class);

    public void doSort(int[] a) {
        if (a == null || a.length <= 1) {
            return;
        }
        int n = a.length;

        // 查找最大值
        int max = 0;
        for (int i = 0; i < n; i++) {
            if (a[i] > max) {
                max = a[i];
            }
        }

        // 创建计数数组c，数组长度是max+1，数组下标0...max 分别对象相应得分的个数
        int[] c = new int[max + 1];

        // 计算每个得分的个数
        for (int i = 0; i < n; i++) {
            c[a[i]]++;
        }

        // 依次累加后. c[i]为分数小于等于i的考生个数
        for (int i = 1; i <= max; i++) {
            c[i] += c[i - 1];
        }

        // 临时数组，保存排序之后的结果
        int[] r = new int[n];
        // 对数组a从尾部开始进行遍历
        for (int i = n - 1; i >= 0; i--) {
            int val = a[i];
            int cVal = c[val];
            r[cVal - 1] = val;
            c[val]--;
        }

        // 将结果拷贝到a数组
        for (int i = 0; i < n; i++) {
            a[i] = r[i];
        }
    }

    public static void main(String[] args) {
        CountingSort cs = new CountingSort();

        // 8 个考生，分数在 0 到 5 分之间。这 8 个考生的成绩放在一个数组 A[8]中，它们分别是：2, 5, 3, 0, 2, 3, 0, 3
        int[] a = new int[]{2, 5, 3, 0, 2, 3, 0, 3};
        cs.doSort(a);
        System.out.println(Arrays.toString(a));

//        LOGGER.info("aaaaa");

        LOGGER.error("aaaaa", new NullPointerException());
    }
}
