package com.leetcode.test.solution;

import com.leetcode.main.solution.MaximumSubArray;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class TestMaximumSubArray {

  private static MaximumSubArray soln;

  @BeforeClass
  public static void setUp() {
    soln = new MaximumSubArray();
  }

  @Test
  public void testCountAndSay() {
    Assert.assertEquals(6, soln.maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));
  }
}
