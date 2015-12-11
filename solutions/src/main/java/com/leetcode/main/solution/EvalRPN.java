/**
 * Status = AC
 * https://leetcode.com/problems/evaluate-reverse-polish-notation/
 */
package com.leetcode.main.solution;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class EvalRPN {
  public static Set<String> opr = new HashSet<String>() {{
    add("+");
    add("-");
    add("*");
    add("/");
  }};

  public int evalRPN(String tokens[]) {
    Stack<Integer> s = new Stack<>();

    for (String t : tokens) {
      if (isValidNumber(t)) {
        s.push(Integer.parseInt(t));
      } else if (opr.contains(t)) {
        int x = s.pop();
        int y = s.pop();
        int res = performOpr(y, x, t);
        s.push(res);
      }
    }

    return s.peek();
  }

  private int performOpr(int x, int y, String o) {
    int res = -1;
    switch (o) {
    case "+":
      res = x + y;
      break;
    case "-":
      res = x - y;
      break;
    case "*":
      res = x * y;
      break;
    case "/":
      res = x / y;
      break;
    default:
      throw new RuntimeException("Incorrect opr = " + o);
    }

    return res;
  }

  private boolean isValidNumber(String s) {
    if (s == null) {
      throw new RuntimeException(s);
    }

    try {
      Integer.parseInt(s);
    } catch (NumberFormatException e) {
      return false;
    }
    return true;
  }
}
