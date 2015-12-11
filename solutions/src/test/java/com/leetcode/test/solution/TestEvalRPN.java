package com.leetcode.test.solution;

import com.leetcode.main.solution.EvalRPN;
import junit.framework.Assert;
import org.junit.Test;

public class TestEvalRPN {
  @Test
  public void testEvalRPN() {
    EvalRPN soln = new EvalRPN();
    String[] parts = new String[]{"2", "1", "+", "3", "*"};
    Assert.assertEquals(9,soln.evalRPN(parts));
  }
}
