package com.leetcode.test.solution;

import com.leetcode.main.solution.ClimbStairs;
import com.leetcode.main.solution.CountOfRangeSum;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class TestCountRangeSum {
    private static CountOfRangeSum soln;

    @BeforeClass
    public static void setUp() {
        soln = new CountOfRangeSum();
    }

    @Test
    public void testCountRangeSum() {
        int[] nums = new int[] {-2, 5, -1};
        Assert.assertEquals(3, soln.countRangeSum(nums, -2, 2));
    }
}
