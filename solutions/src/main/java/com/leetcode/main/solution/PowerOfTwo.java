/**
 * https://leetcode.com/problems/power-of-two/
 * Status = Accepted
 */
package com.leetcode.main.solution;

public class PowerOfTwo {
  public boolean isPowerOfTwo(int n) {
    if (n <= 0) {
      return false;
    }
    int ans = (n & (n - 1));
    return (ans == 0);
  }
}
