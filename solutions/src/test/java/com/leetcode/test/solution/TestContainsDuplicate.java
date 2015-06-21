package com.leetcode.test.solution;

import com.leetcode.main.solution.ContainsDuplicate;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class TestContainsDuplicate {
  private static ContainsDuplicate soln;

  @BeforeClass
  public static void setUp() {
    soln = new ContainsDuplicate();
  }

  @Test
  public void testContainsDuplicate() {
    Assert.assertFalse(soln.containsDuplicate(new int[]{}));
    Assert.assertFalse(soln.containsDuplicate(new int[]{1, 2}));
    Assert.assertTrue(soln.containsDuplicate(new int[]{5, 5, 5}));
    Assert.assertFalse(soln.containsDuplicate(new int[]{1, 2, 3, 4}));
    Assert.assertTrue(soln.containsDuplicate(new int[]{4, 5, 6, 7, 6}));
  }
}
