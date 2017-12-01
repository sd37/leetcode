package com.leetcode.test.solution;

import com.leetcode.main.solution.LongestCommonPrefix;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class TestLongestCommonPrefix {

  private static LongestCommonPrefix soln;

  @BeforeClass
  public static void setUp() {
    soln = new LongestCommonPrefix();
  }

  @Test
  public void testLongestCommonPrefix() {
    Assert.assertEquals("leet", soln.longestCommonPrefix(new String[]{"leetcode", "leet"}));
  }
}
