package com.leetcode.test.solution;

import com.leetcode.main.solution.ClimbStairs;
import com.leetcode.main.solution.Combinations;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class TestCombinations {
    private static Combinations soln;

    @BeforeClass
    public static void setUp() {
        soln = new Combinations();
    }

    @Test
    public void testCombinations() {
        Assert.assertEquals(6, soln.combine(4, 2).size());
    }
}
