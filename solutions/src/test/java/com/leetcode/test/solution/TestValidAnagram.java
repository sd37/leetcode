package com.leetcode.test.solution;

import com.leetcode.main.solution.ValidAnagram;
import junit.framework.Assert;
import org.junit.Test;

public class TestValidAnagram {

  @Test
  public void testValidAnagram() {
    ValidAnagram soln = new ValidAnagram();
    Assert.assertTrue(soln.isAnagram("test","tset"));
  }
}
