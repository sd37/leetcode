// https://leetcode.com/problems/reverse-string/description/
// Status = AC

package com.leetcode.main.solution;

public class ReverseString {

  public String reverseString(String s) {
    char[] charS = s.toCharArray();

    int f = 0;
    int l = s.length() - 1;

    while (f <= l) {
      char tmp = charS[f];
      charS[f] = charS[l];
      charS[l] = tmp;

      f++;
      l--;
    }

    return new String(charS);
  }
}
