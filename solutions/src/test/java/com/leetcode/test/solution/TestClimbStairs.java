package com.leetcode.test.solution;

import com.leetcode.main.solution.ClimbStairs;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class TestClimbStairs {
  private static ClimbStairs soln;

  @BeforeClass
  public static void setUp() {
    soln = new ClimbStairs();
  }

  @Test
  public void testClimbStairs() {
    Assert.assertEquals(2, soln.climbStairs(2));
  }

}
