package com.leetcode.test.solution;

import com.leetcode.main.solution.NumberOfOneBits;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class TestNumberOfOneBits {
  private static NumberOfOneBits soln;

  @BeforeClass
  public static void setUp() {
    soln = new NumberOfOneBits();
  }

  @Test
  public void testHammingWeight() {
    Assert.assertEquals(2, soln.hammingWeight(5));
  }
}
