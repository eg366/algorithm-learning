package com.eg366.al.leetcode.algorithms;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * twoSum
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 * 你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。
 * 示例:
 * 给定 nums = [2, 7, 11, 15], target = 9
 * 因为 nums[0] + nums[1] = 2 + 7 = 9
 * 所以返回 [0, 1]
 *
 * @author juny-zhang
 * @date 2019/2/15 14:09
 */
public class Lc01 {
    public int[] method01(int[] nums, int target) {
        int[] result = new int[2];
        int count = nums.length;
        for (int i = 0; i < count - 1; i++) {
            for (int j = i + 1; j < count; j++) {
                if ((nums[i] + nums[j]) == target) {
                    result[0] = i;
                    result[1] = j;
                    break;
                }
            }
        }
        return result;
    }

    public int[] method02(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }

        for (int i = 0; i < nums.length; i++) {
            int tmp = (target - nums[i]);
            if (map.containsKey(tmp) && map.get(tmp) != i)
                return new int[]{i, map.get(tmp)};
        }

        throw new IllegalArgumentException("No two sum solution");
    }

    public static void main(String[] args) {
        Lc01 obj = new Lc01();
        int[] nums = new int[]{2, 7, 11, 15};
        int target = 9;

        System.out.println(Arrays.toString(obj.method01(nums, target)));
        System.out.println(Arrays.toString(obj.method02(nums, target)));
    }
}
