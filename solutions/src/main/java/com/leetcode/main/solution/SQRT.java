// https://leetcode.com/problems/sqrtx/description/
// Status = AC
package com.leetcode.main.solution;

public class SQRT {
  // use longs to avoid overflow in binary search.
  public int mySqrt(int x) {
    long l = 1;
    long r = x;

    long mid = 0;
    while (l <= r) {
      mid = l + (r - l) / 2;
      long sq = mid * mid;

      if (sq == x) {
        return (int) mid;
      } else if (sq < x) {
        l = mid + 1;
      } else {
        r = mid - 1;
      }
    }

    // this line is important.
    if (mid * mid > x) {
      mid = mid - 1;
    }

    return (int) mid;
  }
}
