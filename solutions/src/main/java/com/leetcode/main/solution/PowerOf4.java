// https://leetcode.com/problems/power-of-four/description/
// Status = AC

package com.leetcode.main.solution;

public class PowerOf4 {
  public boolean isPowerOfFour(int num) {
    return Integer.bitCount(num) == 1 && Integer.bitCount(num - 1) % 2 == 0;
  }
}
