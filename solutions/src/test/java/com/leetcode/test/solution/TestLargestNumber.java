package com.leetcode.test.solution;

import com.leetcode.main.solution.LargestNumber;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class TestLargestNumber {

  private static LargestNumber soln;

  @BeforeClass
  public static void setUp() {
    soln = new LargestNumber();
  }

  @Test
  public void testIsNumber() {
    Assert.assertEquals("9534330", soln.largestNumber(new int[]{3, 30, 34, 5, 9}));
  }
}
