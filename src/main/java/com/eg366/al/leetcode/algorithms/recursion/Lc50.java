package com.eg366.al.leetcode.algorithms.recursion;

/**
 * 实现 pow(x, n) ，即计算 x 的 n 次幂函数。
 */
public class Lc50 {

    /**
     * 递归方式
     */
    public double myPow(double x, int n) {
        if (n == 0) {
            return 1;
        }
        if (n == 1) {
            return x;
        }

        if (n < 0) {
            return 1 / this.myPow(x, -n);
        } else {
            return x * this.myPow(x, n - 1);
        }
    }

    /**
     * 通过for循环
     */
    public double myPow02(double x, int n) {
        if (n == 0) {
            return 1;
        }

        double d = 1;
        for (int i = 0; i < Math.abs(n); i++) {
            d *= x;
        }

        if (n < 0) {
            d = 1 / d;
        }
        return d;
    }

    /**
     * 分治方式
     */
    public double myPow03(double x, int n) {
        if (n == 0) {
            return 1;
        }
        if (n == 1) {
            return x;
        }

        if (n < 0) {
            return 1 / myPow03(x, -n);
        } else if (n % 2 == 0) {
            return myPow03(x, n / 2) * myPow03(x, n / 2);
        } else {
            return myPow03(x, (n - 1) / 2) * myPow03(x, (n - 1) / 2) * x;
        }
    }

    /**
     * 分治方式优化
     */
    public double myPow04(double x, int n) {
        if (n == 0) {
            return 1;
        }
        if (n == 1) {
            return x;
        }

        if (n < 0) {
            if (n == Integer.MIN_VALUE) {
                n = Integer.MAX_VALUE - 1;
            }
            return 1 / myPow04(x, Math.abs(n));
        } else if (n % 2 == 0) {
            return myPow04(x * x, n / 2);
        } else {
            return x * myPow04(x, n - 1);
        }
    }

    public static void main(String[] args) {
        int n = -2147483648;
        n = -2;
        System.out.println(n);
        System.out.println(-n);

        Lc50 lc = new Lc50();
        System.out.println(lc.myPow(2.00000, 10));
        System.out.println(lc.myPow(2.10000, 3));
        System.out.println(lc.myPow(2.00000, -2));

        System.out.println(lc.myPow02(2.00000, 10));
        System.out.println(lc.myPow02(2.10000, 3));
        System.out.println(lc.myPow02(2.00000, -2));

        System.out.println(lc.myPow03(2.00000, 10));
        System.out.println(lc.myPow03(2.10000, 3));
        System.out.println(lc.myPow03(2.00000, -2));

        /*System.out.println(lc.myPow04(2.00000, 10));
        System.out.println(lc.myPow04(2.10000, 3));
        System.out.println(lc.myPow04(2.00000, -2));*/

        System.out.println(lc.myPow04(1.00000, -2147483648));
        System.out.println(lc.myPow04(2.00000, -2147483648));
    }
}
