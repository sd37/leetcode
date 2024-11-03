package com.leetcode.test.solution;

import com.leetcode.main.solution.CountOfRangeSum;
import com.leetcode.main.solution.InversionCount;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class TestInversionCount {
    private static InversionCount soln;

    @BeforeClass
    public static void setUp() {
        soln = new InversionCount();
    }

    @Test
    public void testCountRangeSum() {
        int[] nums = new int[] {3, 1, 2};
        Assert.assertEquals(2, soln.getInvCount(nums, nums.length));
    }
}
