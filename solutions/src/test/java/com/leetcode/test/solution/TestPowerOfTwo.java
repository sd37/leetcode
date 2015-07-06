package com.leetcode.test.solution;

import com.leetcode.main.solution.PowerOfTwo;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class TestPowerOfTwo {
  private static PowerOfTwo soln;

  @BeforeClass
  public static void setUp() {
    soln = new PowerOfTwo();
  }

  @Test
  public void testPowerOfTwo() {
    Assert.assertTrue(soln.isPowerOfTwo(4));
    Assert.assertFalse(soln.isPowerOfTwo(5));
  }
}
