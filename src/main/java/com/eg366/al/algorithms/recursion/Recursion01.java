package com.eg366.al.algorithms.recursion;

/**
 * 假如有 n 个台阶，每次可以跨 1 个台阶或者 2 个台阶，请问走这 n 个台阶有多少种走法？
 *
 * @author juny-zhang
 * @date 2019/2/13 15:43
 */
public class Recursion01 {

    /**
     * 可以根据第一步的走法把所有走法分为两类，第一类是第一步走了 1 个台阶，另一类是第一步走了 2 个台阶。
     * 所以 n 个台阶的走法就等于先走 1 阶后，n-1 个台阶的走法 加上先走 2 阶后，n-2 个台阶的走法。
     * 用公式表示就是：f(n) = f(n-1) + f(n-2)
     *
     * @param n 台阶数
     * @return 多少种走法
     */
    public int method01(int n) {
        if (n == 1)
            return 1;
        if (n == 2)
            return 2;

        return method01(n - 1) + method01(n - 2);
    }

    /**
     * 递归的弊端：
     * 1. 空间复杂度高（栈溢出风险）
     * 2. 存在重复计算
     * <p>
     * 可根据情况选择使用非递归的写法
     *
     * @param n 台阶数
     * @return 多少种走法
     */
    public int method02(int n) {
        if (n == 1)
            return 1;
        if (n == 2)
            return 2;

        int result = 0;
        int pre = 2;
        int prepre = 1;
        for (int i = 3; i <= n; i++) {
            result = pre + prepre;
            prepre = pre;
            pre = result;
        }

        return result;
    }
}
