package com.leetcode.test.solution;

import com.leetcode.main.solution.JudgeRouteCircle;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class TestJudgeRouteCircle {

  private static JudgeRouteCircle soln;

  @BeforeClass
  public static void setUp() {
    soln = new JudgeRouteCircle();
  }

  @Test
  public void testJudgeRouteCircle() {
    Assert.assertTrue(soln.judgeCircle("UD"));
    Assert.assertFalse(soln.judgeCircle("LL"));
    Assert.assertTrue(soln.judgeCircle("UDLR"));
  }

}
