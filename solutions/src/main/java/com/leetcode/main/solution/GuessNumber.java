// https://leetcode.com/problems/guess-number-higher-or-lower/description/
// Status = AC
package com.leetcode.main.solution;

public class GuessNumber {

  private int guess(int num) {
    return -1;
  }

  public int guessNumber(int n) {
    int l = 1;
    int r = n;
    int mid;

    while (l <= r) {
      mid = l + (r - l) / 2;
      int cmp = guess(mid);
      if (cmp == 0) {
        return mid;
      } else if (cmp < 0) {
        r = mid - 1;
      } else {
        l = mid + 1;
      }
    }

    return -1;
  }
}
