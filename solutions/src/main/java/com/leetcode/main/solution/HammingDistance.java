// https://leetcode.com/problems/hamming-distance/description/
// Status = Accepted

package com.leetcode.main.solution;

import java.util.function.BinaryOperator;

public class HammingDistance {

  public int hammingDistance(int x, int y) {
    BinaryOperator<Integer> xorOpr = (a, b) -> a ^ b;
    return Integer.bitCount(xorOpr.apply(x, y));
  }
}
