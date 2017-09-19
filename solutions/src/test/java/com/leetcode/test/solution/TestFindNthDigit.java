package com.leetcode.test.solution;

import com.leetcode.main.solution.NthDigit;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class TestFindNthDigit {
  private static NthDigit soln;

  @BeforeClass
  public static void setUp() {
    soln = new NthDigit();
  }

  @Test
  public void testNthDigit() {
    Assert.assertEquals(3, soln.findNthDigit(3));
    Assert.assertEquals(0, soln.findNthDigit(11));
    Assert.assertEquals(1, soln.findNthDigit(13));
    Assert.assertEquals(1, soln.findNthDigit(10));
    Assert.assertEquals(3, soln.findNthDigit(1000));
    Assert.assertEquals(1, soln.findNthDigit(1000000000));
  }
}
