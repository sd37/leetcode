package com.leetcode.main.solution;

/**
 * https://leetcode.com/problems/min-stack/
 * Status = Accepted
 */
import java.util.Stack;

public class MinStack {
  private Stack<Integer> s;
  private Stack<Integer> minS;

  public MinStack() {
    this.s = new Stack<>();
    this.minS = new Stack<>();
  }

  public void push(int x) {
    if (s.empty()) {
      minS.push(x);
    } else {
      minS.push(Math.min(x, minS.peek()));
    }
    s.push(x);
  }

  public void pop() {
    s.pop();
    minS.pop();
  }

  public int top() {
    return s.peek();
  }

  public int getMin() {
    return minS.peek();
  }
}
