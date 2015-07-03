/**
 * https://leetcode.com/problems/valid-number/
 * Status = Accepted
 */
package com.leetcode.main.solution;

public class ValidNumber {
  public boolean isNumber(String s) {
    if (s == null) {
      throw new RuntimeException();
    }

    s = s.toLowerCase();

    if (!initialValidation(s)) {
      return false;
    }

    try {
      Double.parseDouble(s);
    } catch (NumberFormatException e) {
      return false;
    }
    return true;
  }

  private boolean initialValidation(String s) {
    for (char ch : s.toCharArray()) {
      if (Character.isLetter(ch) && ch != 'e') {
        return false;
      }
    }

    return true;
  }
}
