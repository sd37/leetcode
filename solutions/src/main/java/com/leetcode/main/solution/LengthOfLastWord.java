// https://leetcode.com/problems/length-of-last-word/description/
// Status = AC

package com.leetcode.main.solution;

public class LengthOfLastWord {
  public int lengthOfLastWord(String s) {
    if(s == null) {
      return 0;
    }

    s = s.trim();
    if(s.equals("")) {
      return 0;
    }

    String[] tokens = s.split(" ");

    return tokens[tokens.length - 1].length();
  }
}
