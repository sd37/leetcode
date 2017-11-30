package com.leetcode.test.solution;

import com.leetcode.main.solution.CountAndSay;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class TestCountAndSay {

  private static CountAndSay soln;

  @BeforeClass
  public static void setUp() {
    soln = new CountAndSay();
  }

  @Test
  public void testCountAndSay() {
    Assert.assertEquals("111221", soln.countAndSay(5));
  }
}
