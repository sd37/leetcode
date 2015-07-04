package com.leetcode.test.solution;

import com.leetcode.main.solution.CountPrimes;
import junit.framework.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class TestCountPrimes {
  private static CountPrimes soln;

  @BeforeClass
  public static void setUp() {
    soln = new CountPrimes();
  }

  @Test
  public void testCountPrimes() {
    Assert.assertEquals(25, soln.countPrimes(100));
  }
}
