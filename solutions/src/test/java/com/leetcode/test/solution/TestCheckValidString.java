package com.leetcode.test.solution;

import com.leetcode.main.solution.CheckValidString;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class TestCheckValidString {
  private static CheckValidString soln;

  @BeforeClass
  public static void setUp() {
    soln = new CheckValidString();
  }

  @Test
  public void testMapSum() {
    Assert.assertFalse(soln.checkValidString("(***)("));
  }
}
