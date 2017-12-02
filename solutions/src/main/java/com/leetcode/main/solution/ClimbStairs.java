// https://leetcode.com/problems/climbing-stairs/description/
// Status = AC

package com.leetcode.main.solution;

import java.util.Arrays;

public class ClimbStairs {

  public int climbStairs(int n) {
    if(n < 0) {
      return 0;
    }

    int[] m = new int[n + 1];
    Arrays.fill(m, -1);

    m[0] = 1;
    m[1] = 1;

    return climbStairsUtil(n, m);
  }

  public int climbStairsUtil(int n, int[] m) {
    if (m[n] == -1) {
      m[n] = climbStairsUtil(n - 1, m) + climbStairsUtil(n - 2, m);
    }

    return m[n];
  }
}
