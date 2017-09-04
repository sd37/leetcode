package com.leetcode.test.solution;

import com.leetcode.main.solution.HammingDistance;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class TestHammingDistance {

  private static HammingDistance soln;

  @BeforeClass
  public static void setUp() {
    soln = new HammingDistance();
  }

  @Test
  public void TestHammingDistance() {
    Assert.assertEquals(2, soln.hammingDistance(1, 4));
  }
}
