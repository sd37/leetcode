package com.leetcode.test.solution;

import com.leetcode.main.solution.CanWinNim;
import org.junit.Assert;
import org.junit.Test;

public class TestCanWinNim {
  @Test
  public void testCanWinNim() {
    CanWinNim soln = new CanWinNim();
    Assert.assertFalse(soln.canWinNim(4));
    Assert.assertTrue(soln.canWinNim(5));
    Assert.assertTrue(soln.canWinNim(6));
    Assert.assertFalse(soln.canWinNim(1348820612));
  }
}
