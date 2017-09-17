package com.leetcode.test.solution;

import com.leetcode.main.solution.ValidPalindrome;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class TestValidPalindrome {

  private static ValidPalindrome soln;

  @BeforeClass
  public static void setUp() {
    soln = new ValidPalindrome();
  }

  @Test
  public void testValidPalindrome() {
    //Assert.assertFalse(soln.validPalindrome("atbbga"));
    Assert.assertTrue(soln.validPalindrome("tcaac"));
    Assert.assertTrue(soln.validPalindrome("eedede"));
  }
}
