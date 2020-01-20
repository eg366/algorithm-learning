package com.eg366.al.algorithms.sort;

/**
 * 冒泡排序
 * <p>
 * 1. 是原地排序算法，空间复杂度为O(1)；
 * 2. 是稳定的排序算法，相邻的两个元素大小相等时，不会进行交换；
 * 3. 时间复杂度：O(n^2)；[最好情况：1,2,3,4,5,6；一次冒泡；时间复杂度O(n)];[最坏情况：6,5,4,3,2,1；6次冒泡；时间复杂度O(n^2)]
 *
 * @author juny-zhang
 * @date 2019/2/13 16:53
 */
public class BubbleSort01 {

    public void method01(int[] a) {
        if (a == null || a.length <= 1) {
            return;
        }

        int n = a.length;
        // 对n个数字进行排序，需要进行n-1趟排序
        for (int i = 0; i < n - 1; i++) {
            // 提前退出冒泡排序标识，标识本趟排序是否进行了数据交换
            boolean flag = false;
            // 第i趟排序，需要进行数据比较的次数是(n-i-1)次
            for (int j = 0; j < n - i - 1; j++) {
                if (a[j] > a[j + 1]) {
                    int tmp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = tmp;
                    flag = true;
                }
            }

            // 如果本趟排序中没有进行数据交换，说明已达到完全有序
            if (!flag) {
                break;
            }
        }
    }

    public static void main(String[] args) {
        BubbleSort01 obj = new BubbleSort01();
        obj.method01(new int[]{1, 3, 2});
    }
}
