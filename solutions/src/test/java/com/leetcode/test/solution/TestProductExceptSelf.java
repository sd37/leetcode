package com.leetcode.test.solution;

import com.leetcode.main.solution.ProductExceptSelf;
import java.util.Arrays;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class TestProductExceptSelf {

  private static ProductExceptSelf soln;

  @BeforeClass
  public static void setUp() {
    soln = new ProductExceptSelf();
  }

  @Test
  public void testProductExceptSelf() {
    Assert.assertTrue(Arrays.equals(new int[]{24, 12, 8, 6}, soln.productExceptSelf(new int[]{1, 2, 3, 4})));
  }
}
