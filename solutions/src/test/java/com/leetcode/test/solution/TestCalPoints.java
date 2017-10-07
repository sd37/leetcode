package com.leetcode.test.solution;

import com.leetcode.main.solution.CalPoints;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class TestCalPoints {

  private static CalPoints soln;

  @BeforeClass
  public static void setUp() {
    soln = new CalPoints();
  }

  @Test
  public void testCalPoint() {
    String[] ops = new String[]{"5", "7", "C", "D", "+"};
    Assert.assertEquals(30,soln.calPoints(ops));
    String[] ops1 = new String[]{"1", "D", "D", "D"};
    Assert.assertEquals(15,soln.calPoints(ops1));
    String[] ops2 = new String[]{"1", "C", "C", "C", "1", "D"};
    Assert.assertEquals(3,soln.calPoints(ops2));
  }
}
