package com.leetcode.main.solution;
// https://leetcode.com/contest/leetcode-weekly-contest-50/problems/valid-palindrome-ii/
// status = AC

public class ValidPalindrome {

  public boolean validPalindrome(String s) {
    if (s.length() < 2) {
      return true;
    }

    int i = 0;
    int j = s.length() - 1;

    while (i < j) {
      if (s.charAt(i) != s.charAt(j)) {
        break;
      }
      i++;
      j--;
    }

    if(i >= j) {
      return true;
    }

    return isPalin(s.substring(i + 1, j + 1))
        || isPalin(s.substring(i,j));
  }

  private boolean isPalin(String s) {
    if(s == null) {
      return false;
    }

    return s.equals(new StringBuilder(s).reverse().toString());
  }
}
