// https://leetcode.com/problems/hamming-distance/description/
// Status = Accepted

package com.leetcode.main.solution;

public class HammingDistance {

  public int hammingDistance(int x, int y) {
    return Integer.bitCount(x ^ y);
  }
}
