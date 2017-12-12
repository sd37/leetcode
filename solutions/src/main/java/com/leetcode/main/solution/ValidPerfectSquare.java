// https://leetcode.com/problems/valid-perfect-square/discuss/
// Status = AC
package com.leetcode.main.solution;

public class ValidPerfectSquare {

  public boolean isPerfectSquare(int num) {
    long l = 1;
    long r = num;

    while (l <= r) {
      long mid = l + (r - l) / 2;
      long sq = mid * mid;

      if (sq == num) {
        return true;
      } else if(sq < num) {
        l = mid + 1;
      } else {
        r = mid - 1;
      }
    }

    return false;
  }
}
