// https://leetcode.com/submissions/detail/133292347/
// Status = AC
package com.leetcode.main.solution;

public class ValidPalindrome {
  public boolean isPalindrome(String s) {
    if(s == null || s.length() == 0) {
      return true;
    }

    StringBuilder newS = new StringBuilder();
    for (int i = 0; i < s.length(); i++) {
      char ch = s.charAt(i);
      if(Character.isAlphabetic(ch) || Character.isDigit(ch)) {
        newS.append(Character.toLowerCase(ch));
      }
    }

    // note newS.reverse() modifies string in-place
    String s1 = newS.toString();
    String s2 = newS.reverse().toString();

    return s1.equals(s2);
  }
}
