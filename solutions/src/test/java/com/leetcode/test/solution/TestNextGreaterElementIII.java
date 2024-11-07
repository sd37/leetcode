package com.leetcode.test.solution;

import com.leetcode.main.solution.NextGreaterElementIII;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class TestNextGreaterElementIII {
    private static NextGreaterElementIII soln;

    @BeforeClass
    public static void setUp() {
        soln = new NextGreaterElementIII();
    }

    @Test
    public void testNextGreaterElementIII() {
        int n1 = 124322;
        int n2 = 21;
        var result = soln.nextGreaterElement(n2);
        Assert.assertNotNull(result);
    }
}
