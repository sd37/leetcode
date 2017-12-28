// https://leetcode.com/problems/decode-ways/description/
// Status = AC
package com.leetcode.main.solution;

public class DecodeWays {

  public int numDecodings(String s) {
    if (s == null || s.length() == 0) {
      return 0;
    }

    int n = s.length();
    int[] memo = new int[n + 1];

    memo[0] = 1; // this has to be 1, otherwise "12" test case fails.
    memo[1] = s.charAt(0) == '0' ? 0 : 1;

    for (int i = 2; i <= n; i++) {
      int oneDigit = Integer.valueOf(s.substring(i - 1, i));
      int twoDigit = Integer.valueOf(s.substring(i - 2, i));

      if(1 <= oneDigit && oneDigit <= 9) {
        memo[i] += memo[i - 1];
      }

      if(10 <= twoDigit && twoDigit <= 26) {
        memo[i] += memo[i - 2];
      }
    }

    return memo[n];
  }
}
