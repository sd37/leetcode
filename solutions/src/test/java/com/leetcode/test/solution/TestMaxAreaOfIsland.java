package com.leetcode.test.solution;

import com.leetcode.main.solution.MaxAreaOfIsland;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class TestMaxAreaOfIsland {


  private static MaxAreaOfIsland soln;

  @BeforeClass
  public static void setUp() {
    soln = new MaxAreaOfIsland();
  }

  @Test
  public void TestHammingDistance() {
    int[][] grid = new int[][]{
        {1, 1, 0, 1, 1},
        {1, 0, 0, 0, 0},
        {0, 0, 0, 0, 1},
        {1, 1, 0, 1, 1}
    };
    Assert.assertEquals(3, soln.maxAreaOfIsland(grid));
  }
}
