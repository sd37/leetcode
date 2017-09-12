package com.leetcode.test.solution;

import com.leetcode.main.solution.TopKFrequent;
import java.util.List;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class TestTopKFrequent {

  private static TopKFrequent soln;

  @BeforeClass
  public static void setUp() {
    soln = new TopKFrequent();
  }

  @Test
  public void testProductExceptSelf() {
    List<Integer> ans = soln.topKFrequent(new int[]{1, 1, 1, 2, 2, 3}, 2);
    Assert.assertEquals(1, ans.get(0).intValue());
    Assert.assertEquals(2, ans.get(1).intValue());
  }
}
