package com.leetcode.test.solution;

import com.leetcode.main.solution.MapSum;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class TestMapSum {

  private static MapSum soln;

  @BeforeClass
  public static void setUp() {
    soln = new MapSum();
  }

  @Test
  public void testMapSum() {
    soln.insert("apple", 3);
    Assert.assertEquals(3, soln.sum("ap"));
    soln.insert("app", 2);
    Assert.assertEquals(5, soln.sum("ap"));
  }

}
