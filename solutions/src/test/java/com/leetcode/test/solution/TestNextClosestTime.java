package com.leetcode.test.solution;

import com.leetcode.main.solution.NextClosetTime;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class TestNextClosestTime {

  private static NextClosetTime soln;

  @BeforeClass
  public static void setUp() {
    soln = new NextClosetTime();
  }

  @Test
  public void testClosestTime() {
    Assert.assertEquals("19:39", soln.nextClosestTime("19:34"));
  }
}
