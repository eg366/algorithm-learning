package com.eg366.al.datastructure.array;

import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * 打印螺旋矩阵（二维数组）
 *
 * @Author: zhangjunyu
 * @Date: 2020/4/3 9:18
 */
public class SpiralMatrix01 {

    public static void main(String[] args) {
        System.out.println(ToStringBuilder.reflectionToString(createMatrix01(4)));
        System.out.println(ToStringBuilder.reflectionToString(createMatrix02(5)));

        int[][] matrix01 = createMatrix02(5);
        printMatrix(matrix01, 5, 5);

        System.out.println();

        int[][] matrix02 = {
                {0, 1, 2, 3, 4, 5, 6, 7},
                {23, 24, 25, 26, 27, 28, 29, 8},
                {22, 39, 40, 41, 42, 43, 30, 9},
                {21, 38, 47, 46, 45, 44, 31, 10},
                {20, 37, 36, 35, 34, 33, 32, 11},
                {19, 18, 17, 16, 15, 14, 13, 12}};
        printMatrix(matrix02, 8, 6);
    }

    /**
     * 创建一个 n*n 的二维数组，起始从1开始
     */
    private static int[][] createMatrix01(int n) {
        // 二维数组
        int[][] matrix = new int[n][n];
        // 二维数组坐标
        int x = 0, y = 0;

        // 方向（0：向右，y++； 1：向下，x++；3：向左，y--；4：向上，x--）
        int direct = 0;

        // 起始数值
        int i = 1;
        // 最大值
        int max = n * n;
        while (i <= max) {
            matrix[x][y] = i++;

            // 判断是否需要调整方向
            switch (direct) {
                case 0:
                    if ((y + 1) >= n || matrix[x][y + 1] != 0) {
                        direct++;
                    }
                    break;
                case 1:
                    if ((x + 1) >= n || matrix[x + 1][y] != 0) {
                        direct++;
                    }
                    break;
                case 2:
                    if ((y - 1) < 0 || matrix[x][y - 1] != 0) {
                        direct++;
                    }
                    break;
                case 3:
                    if ((x - 1) < 0 || matrix[x - 1][y] != 0) {
                        direct = 0;
                    }
                    break;
            }

            // 根据下一步要执行的方向，调整x, y坐标
            switch (direct) {
                case 0:
                    y++;
                    break;
                case 1:
                    x++;
                    break;
                case 2:
                    y--;
                    break;
                case 3:
                    x--;
                    break;
            }
        }

        return matrix;
    }

    /**
     * 创建一个 n*n 的二维数组，起始从1开始
     */
    private static int[][] createMatrix02(int n) {
        // 二维数组
        int[][] matrix = new int[n][n];
        // 二维数组坐标
        int x = 0, y = 0;

        // 方向（0：向右，y++； 1：向下，x++；3：向左，y--；4：向上，x--）
        int direct = 0;

        // 起始数值
        int i = 1;
        // 最大值
        int max = n * n;
        while (i <= max) {
            matrix[x][y] = i++;

            // 判断是否需要调整方向
            switch (direct) {
                case 0:
                    // 到达边界或，非初始值
                    if ((y + 1) >= n || matrix[x][y + 1] != 0) {
                        direct++;
                        x++;
                    } else {
                        y++;
                    }
                    break;
                case 1:
                    if ((x + 1) >= n || matrix[x + 1][y] != 0) {
                        direct++;
                        y--;
                    } else {
                        x++;
                    }
                    break;
                case 2:
                    if ((y - 1) < 0 || matrix[x][y - 1] != 0) {
                        direct++;
                        x--;
                    } else {
                        y--;
                    }
                    break;
                case 3:
                    if ((x - 1) < 0 || matrix[x - 1][y] != 0) {
                        direct = 0;
                        y++;
                    } else {
                        x--;
                    }
                    break;
            }
        }

        return matrix;
    }

    /**
     * 打印二维矩阵
     *
     * @param matrix 矩阵
     * @param m      宽
     * @param n      高
     */
    private static void printMatrix(int[][] matrix, int m, int n) {
        int i = 0;
        int count = m * n;

        int x = 0, y = 0;
        // 方向（0：向右，y++； 1：向下，x++；3：向左，y--；4：向上，x--）
        int direct = 0;

        // 设置边界
        int minM = 0, minN = 0, maxM = m, maxN = n;

        // 遍历元素个数
        while (i < count) {
            System.out.print(matrix[x][y]);
            if (i++ < (count - 1)) {
                System.out.print(", ");
            }

            switch (direct) {
                case 0:
                    // 向右：没到达最大宽度时，一直向右
                    if ((y + 1) < maxM) {
                        y++;
                    } else {
                        // 改变方向；向下；最小高度+1
                        direct++;
                        x++;
                        minN++;
                    }
                    break;
                case 1:
                    // 向下：没到达最大高度时，一直向下
                    if ((x + 1) < maxN) {
                        x++;
                    } else {
                        // 改变方向；向左；最大宽度-1
                        direct++;
                        y--;
                        maxM--;
                    }
                    break;
                case 2:
                    // 向左：没到达最小宽度时，一直向左
                    if (y > minM) {
                        y--;
                    } else {
                        // 改变方向；向上；最大高度-1
                        direct++;
                        x--;
                        maxN--;
                    }
                    break;
                case 3:
                    // 向上：没达到最小高度时，一直向上
                    if (x > minN) {
                        x--;
                    } else {
                        // 改变方向；向右；最小宽度+1
                        direct = 0;
                        y++;
                        minM++;
                    }
                    break;
            }
        }
    }
}
