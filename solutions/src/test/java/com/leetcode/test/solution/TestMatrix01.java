package com.leetcode.test.solution;

import com.leetcode.main.solution.Matrix01;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class TestMatrix01 {

  private static Matrix01 soln;

  @BeforeClass
  public static void setUp() {
    soln = new Matrix01();
  }

  @Test
  public void testClimbStairs() {
//    int[][] grid = new int[][]{
//        {1, 0, 1, 1, 0, 0, 1, 0, 0, 1},
//        {0, 1, 1, 0, 1, 0, 1, 0, 1, 1},
//        {0, 0, 1, 0, 1, 0, 0, 1, 0, 0},
//        {1, 0, 1, 0, 1, 1, 1, 1, 1, 1},
//        {0, 1, 0, 1, 1, 0, 0, 0, 0, 1},
//        {0, 0, 1, 0, 1, 1, 1, 0, 1, 0},
//        {0, 1, 0, 1, 0, 1, 0, 0, 1, 1},
//        {1, 0, 0, 0, 1, 1, 1, 1, 0, 1},
//        {1, 1, 1, 1, 1, 1, 1, 0, 1, 0},
//        {1, 1, 1, 1, 0, 1, 0, 0, 1, 1}
//    };

    int[][] grid = new int[][]{
        {0, 1, 0, 1},
        {1, 0, 0, 1},
        {1, 1, 1, 0},
        {1, 1, 1, 1}
    };

    int[][] ans = soln.updateMatrix(grid);
    Assert.assertNotNull(ans);

  }

}
