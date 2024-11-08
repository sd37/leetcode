package com.leetcode.test.solution;

import com.leetcode.common.TreeNode;
import com.leetcode.main.solution.BinaryTreeRightSideView;
import com.leetcode.main.solution.TrappingRainWater;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class TestTrappingWater {

    private static TrappingRainWater soln;

    @BeforeClass
    public static void setUp() {
        soln = new TrappingRainWater();
    }

    @Test
    public void testTrappingRainWater() {
        int[] heights1 = new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        int[] heights2 = new int[]{2, 1, 2};
        int[] heights3 = new int[]{3, 2, 1, 2, 1};
        int[] heights4 = new int[]{2, 1, 0, 1, 3, 2, 1, 2, 1};
        int[] heights5 = new int[]{2, 1, 0, 1, 3};

        var result = soln.trap(heights1);
        Assert.assertEquals(result, 6);
    }
}
