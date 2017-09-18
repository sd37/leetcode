// https://leetcode.com/problems/valid-parenthesis-string/
// Status = AC

package com.leetcode.main.solution;

public class CheckValidString {
  public boolean checkValidString(String s) {
    if(s == null || s.isEmpty()) {
      return true;
    }

    int lo = 0;
    int hi = 0;

    for (char ch : s.toCharArray()) {
      lo += (ch == '(' ? 1 : -1);
      hi += (ch != ')' ? 1 : -1);

      if(hi < 0) {
        return false;
      }

      // This line is needed because, otherwise the test case would fail.
      // This because if we carry around past wrong behavior (-ve values )it will effect future predictions.
      // So we say we don't do wrong behavior in the past by making lo = 0 when lo < 0
      lo = Math.max(lo, 0);
    }

    return lo == 0;
  }
}
