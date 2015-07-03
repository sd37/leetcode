package com.leetcode.test.solution;

import com.leetcode.main.solution.ValidNumber;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class TestIsNumber {
  private static ValidNumber soln;

  @BeforeClass
  public static void setUp() {
    soln = new ValidNumber();
  }

  @Test
  public void testIsNumber() {
    Assert.assertTrue(soln.isNumber("1.23"));
    Assert.assertFalse(soln.isNumber("abc"));
    Assert.assertTrue(soln.isNumber("2e10"));
  }
}
