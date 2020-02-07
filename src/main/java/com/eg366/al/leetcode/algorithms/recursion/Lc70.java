package com.eg366.al.leetcode.algorithms.recursion;

import java.util.HashMap;
import java.util.Map;

/**
 * 爬楼梯
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 * <p>
 * 示例 1：
 * 输入： 2
 * 输出： 2
 * 解释： 有两种方法可以爬到楼顶。
 * 1.  1 阶 + 1 阶
 * 2.  2 阶
 * <p>
 * 示例 2：
 * 输入： 3
 * 输出： 3
 * 解释： 有三种方法可以爬到楼顶。
 * 1.  1 阶 + 1 阶 + 1 阶
 * 2.  1 阶 + 2 阶
 * 3.  2 阶 + 1 阶
 * </p>
 */
public class Lc70 {

    // key: 台阶数, value：对应可走的方式
    private Map<Integer, Integer> map = new HashMap<>();

    /**
     * 递推公式
     * f(n) = f(n-1) + f(n-2);
     * f(n-1)：第一步选择走一步的可能方式
     * f(n-2)：第一步选择走两步的可能方式
     * <p>
     * f(n) = f(n-1) + f(n-2)
     * f(1) = 1;
     * f(2) = 2;
     * <p>
     * f(3) = 1+1+1;1+2;2+1; -->3
     * f(4) = 1+1+1+1;2+1+1;1+2+1;1+1+2;2+2; --> 5
     * f(5) = 1+1+1+1+1;2+1+1+1;1+2+1+1;1+1+2+1;1+1+1+2;1+2+2;2+1+2;2+2+1; --> 8
     */
    public int climbStairs(int n) {
        // 如果已计算过，直接返回
        if (map.containsKey(n)) {
            System.out.println("1111111");
            return map.get(n);
        }

        int result;
        if (n == 1) {
            // 只有一个台阶的情况
            result = 1;
        } else if (n == 2) {
            // 有两个台阶的情况
            result = 2;
        } else {
            result = this.climbStairs(n - 1) + this.climbStairs(n - 2);
        }

        // 计算过的放到map中储存起来
        if (!map.containsKey(n)) {
            map.put(n, result);
        }
        return result;
    }

    public static void main(String[] args) {
        Lc70 lc = new Lc70();

        int n = 3;
//        System.out.println(n + " --> " + lc.climbStairs(n));
//        n = 4;
//        System.out.println(n + " --> " + lc.climbStairs(n));
        n = 45;
        System.out.println(n + " --> " + lc.climbStairs(n));
    }

}
