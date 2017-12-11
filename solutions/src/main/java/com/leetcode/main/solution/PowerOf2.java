// https://leetcode.com/problems/power-of-two/description/
// Status = AC
package com.leetcode.main.solution;

public class PowerOf2 {

  public boolean isPowerOfTwo(int n) {
    return n > 0 && (n & n - 1) == 0;
  }
}
