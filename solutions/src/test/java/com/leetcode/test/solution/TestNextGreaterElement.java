package com.leetcode.test.solution;

import com.leetcode.main.solution.CountOfRangeSum;
import com.leetcode.main.solution.NextGreaterElementI;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class TestNextGreaterElement {
    private static NextGreaterElementI soln;

    @BeforeClass
    public static void setUp() {
        soln = new NextGreaterElementI();
    }

    @Test
    public void testNextGreaterElement() {
        int[] nums1 = new int[]{4, 1, 2};
        int[] nums2 = new int[]{1, 3, 4, 2};

        var result = soln.nextGreaterElement(nums1, nums2);
        Assert.assertNotNull(result);
    }
}
