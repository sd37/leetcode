package com.leetcode.main.solution;
// https://leetcode.com/contest/leetcode-weekly-contest-50/problems/valid-palindrome-ii/
// status = TLE

public class ValidPalindrome {

  public boolean validPalindrome(String s) {
    if (isPalindrome(s)) {
      return true;
    }

    for (int i = 0; i < s.length(); i++) {
      String newString = new StringBuilder(s).deleteCharAt(i).toString();
      if (isPalindrome(newString)) {
        return true;
      }
    }
    return false;
  }

  private boolean isPalindrome(String s) {
    if (s == null) {
      return true;
    }
    StringBuilder sb = new StringBuilder(s);
    return s.equals(sb.reverse().toString());
  }
}
