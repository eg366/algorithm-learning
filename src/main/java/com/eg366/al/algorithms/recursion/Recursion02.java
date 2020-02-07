package com.eg366.al.algorithms.recursion;

/**
 * 阶乘
 */
public class Recursion02 {

    /**
     * 递归实现：
     * 递推公式：f(n) = n*f(n-1)
     * 终止条件：n = 1; return 1;
     */
    public int method01(int n) {
        if (n == 1) {
            return n;
        }

        int result = 0;

        result = n * this.method01(n - 1);

        return result;
    }

    /**
     * 循环实现
     */
    public int method02(int n) {
        int result = 1;

        for (int i = n; i > 0; i--) {
            result *= i;
        }

        return result;
    }

    public static void main(String[] args) {
        Recursion02 r = new Recursion02();

        int n = 2;
        System.out.println(n + " --> " + r.method01(n) + ", " + r.method02(n));
        n = 3;
        System.out.println(n + " --> " + r.method01(n) + ", " + r.method02(n));
        n = 4;
        System.out.println(n + " --> " + r.method01(n) + ", " + r.method02(n));
        n = 5;
        System.out.println(n + " --> " + r.method01(n) + ", " + r.method02(n));
    }
}
