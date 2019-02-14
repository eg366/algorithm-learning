package com.eg366.al.test.algorithms.sort;

import com.eg366.al.algorithms.sort.BubbleSort01;
import com.eg366.al.algorithms.sort.InsertionSort01;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

/**
 * @author juny-zhang
 * @date 2019/2/13 17:46
 */
public class InsertionSort01Test {

    InsertionSort01 obj = new InsertionSort01();

    @Test
    public void testMethod01() {
        int[] a = new int[]{4, 5, 6, 3, 2, 1};
        obj.method01(a);
        System.out.println(Arrays.toString(a));
        Assert.assertArrayEquals(new int[]{1, 2, 3, 4, 5, 6}, a);
    }
}
