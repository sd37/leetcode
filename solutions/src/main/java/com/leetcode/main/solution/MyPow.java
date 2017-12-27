// https://leetcode.com/problems/powx-n/description/
// Status = AC

package com.leetcode.main.solution;

public class MyPow {
  // changed the n to long so that it can hold -ve large value.
  public double myPow(double x, long n) {
    if(n == 0) {
      return 1;
    }

    if(x == 0) {
      return 0;
    }

    if(n < 0) {
      x = 1 / x;
      n = Math.abs(n);
    }

    double tmp = myPow(x, n / 2);

    return (n % 2 == 0 ? tmp * tmp : tmp * tmp * x);
  }
}
