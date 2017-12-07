package com.leetcode.test.solution;

import com.leetcode.main.solution.ThreeSum;
import org.junit.BeforeClass;
import org.junit.Test;

public class TestThreeSum {
  private static ThreeSum soln;

  @BeforeClass
  public static void setUp() {
    soln = new ThreeSum();
  }

  @Test
  public void testThreeSum() {
    soln.threeSum(new int[] {-1,0,1,2,-1,-4});
  }
}

