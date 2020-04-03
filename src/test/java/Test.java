import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * @author juny-zhang
 * @date 2019/2/13 14:54
 */
public class Test {
    public static void main(String[] args) {
        /*System.out.println(recursion01A(1) == recursion01B(1));
        System.out.println(recursion01A(2) == recursion01B(2));
        System.out.println(recursion01A(3) == recursion01B(3));
        System.out.println(recursion01A(4) == recursion01B(4));
        System.out.println(recursion01A(5) == recursion01B(5));*/

        /*System.out.println(recursion02A(1) == recursion02B(1));
        System.out.println(recursion02A(2) == recursion02B(2));
        System.out.println(recursion02A(3) == recursion02B(3));
        System.out.println(recursion02A(4) == recursion02B(4));
        System.out.println(recursion02A(5) == recursion02B(5));*/

        int[] array = {4, 5, 3, 1, 6, 2};
        bubble01(array);
        System.out.println(ToStringBuilder.reflectionToString(array));

    }

    /**
     * 冒泡排序
     *
     * @param array
     */
    private static void bubble01(int[] array) {
        if (array == null || array.length <= 1) {
            return;
        }

        int length = array.length;
        for (int i = 0; i < length - 1; i++) {
            boolean noChange = true;
            for (int j = 0; j < length - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    int tmp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = tmp;
                    noChange = false;
                }
            }

            if (noChange) {
                break;
            }
        }
    }

    /**
     * 阶乘
     * f(n) = n * f(n-1)
     */
    private static int recursion02A(int n) {
        if (n == 1) {
            return 1;
        }

        return n * recursion02A(n - 1);
    }

    /**
     * 阶乘
     */
    private static int recursion02B(int n) {
        if (n == 1) {
            return 1;
        }
        int result = 1;
        for (int i = 1; i <= n; i++) {
            result = result * i;
        }

        return result;
    }

    /**
     * 台阶的走法A
     * f(n) = f(n-1) + f(n-2)
     */
    private static int recursion01A(int n) {
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }

        return recursion01A(n - 1) + recursion01A(n - 2);
    }

    /**
     * 台阶的走法B
     */
    private static int recursion01B(int n) {
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }

        int result = 0;
        int prePre = 1;
        int pre = 2;
        for (int i = 3; i <= n; i++) {
            result = pre + prePre;
            prePre = pre;
            pre = result;

        }

        return result;
    }
}
