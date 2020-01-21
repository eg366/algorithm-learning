package com.eg366.al.leetcode.algorithms.stack;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * 下一个更大元素 I
 * <p>
 * 给定两个没有重复元素的数组 nums1 和 nums2 ，其中nums1 是 nums2 的子集。找到 nums1 中每个元素在 nums2 中的下一个比其大的值。
 * nums1 中数字 x 的下一个更大元素是指 x 在 nums2 中对应位置的右边的第一个比 x 大的元素。如果不存在，对应位置输出-1。
 * 示例:
 * 输入: nums1 = [4,1,2], nums2 = [1,3,4,2].
 * 输出: [-1,3,-1]
 * </p>
 *
 * @Author: zhangjunyu
 * @Date: 2020/1/21 17:00
 */
public class Lc496 {

    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] result = new int[nums1.length];

        boolean flag = false;

        for (int i = 0; i < nums1.length; i++) {
            int curVal = nums1[i];
            // 初始为-1，如果找到就覆盖该值
            result[i] = -1;
            flag = false;
            for (int j = 0; j < nums2.length; j++) {
                if (curVal == nums2[j]) {
                    // 找到相等的值节点位置
                    flag = true;
                    continue;
                }

                // 找到相等值后的第一个比i值大的元素
                if (flag && nums2[j] > curVal) {
                    result[i] = nums2[j];
                    break;
                }
            }
        }

        return result;
    }

    public int[] nextGreaterElement2(int[] nums1, int[] nums2) {
        int[] result = new int[nums1.length];

        Stack<Integer> stack = new Stack<>();
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums2.length; i++) {
            int val = nums2[i];

            while (!stack.isEmpty() && val > stack.peek()) {
                map.put(stack.pop(), val);
            }

            stack.push(val);
        }
        while (!stack.isEmpty()) {
            map.put(stack.pop(), -1);
        }

        for (int i = 0; i < nums1.length; i++) {
            result[i] = map.get(nums1[i]);
        }

        return result;
    }

    public static void main(String[] args) {
        /*int[] nums1 = {4, 1, 2};
        int[] nums2 = {1, 3, 4, 2};*/

        /*int[] nums1 = {2, 4};
        int[] nums2 = {1, 2, 3, 4};*/

        int[] nums1 = {1, 3, 5, 2, 4};
        int[] nums2 = {6, 5, 4, 3, 2, 1, 7};

        Lc496 lc = new Lc496();
//        int[] result = lc.nextGreaterElement(nums1, nums2);
        int[] result = lc.nextGreaterElement2(nums1, nums2);
        System.out.println(Arrays.toString(result));
    }
}
