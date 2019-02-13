package com.eg366.al.test.algorithms.recursion;

import com.eg366.al.algorithms.recursion.Recursion01;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author juny-zhang
 * @date 2019/2/13 15:48
 */
public class Recursion01Test {

    Recursion01 obj = new Recursion01();

    @Test
    public void testMethod01() {
        Assert.assertEquals(1, obj.method01(1));
        Assert.assertEquals(2, obj.method01(2));
        Assert.assertEquals(3, obj.method01(3));
        Assert.assertEquals(5, obj.method01(4));
        Assert.assertEquals(8, obj.method01(5));
        Assert.assertEquals(13, obj.method01(6));
        Assert.assertEquals(21, obj.method01(7));
    }

    @Test
    public void testMethod02() {
        Assert.assertEquals(1, obj.method02(1));
        Assert.assertEquals(2, obj.method02(2));
        Assert.assertEquals(3, obj.method02(3));
        Assert.assertEquals(5, obj.method02(4));
        Assert.assertEquals(8, obj.method02(5));
        Assert.assertEquals(13, obj.method02(6));
        Assert.assertEquals(21, obj.method02(7));
    }

    @Test
    public void testCompareTwoMethod() {
        Assert.assertEquals(obj.method01(1), obj.method02(1));
        Assert.assertEquals(obj.method01(2), obj.method02(2));
        Assert.assertEquals(obj.method01(3), obj.method02(3));
        Assert.assertEquals(obj.method01(4), obj.method02(4));
        Assert.assertEquals(obj.method01(5), obj.method02(5));
        Assert.assertEquals(obj.method01(6), obj.method02(6));
        Assert.assertEquals(obj.method01(7), obj.method02(7));
    }
}
