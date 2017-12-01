// https://leetcode.com/problems/longest-common-prefix/description/
// Status = AC

package com.leetcode.main.solution;

public class LongestCommonPrefix {

  public String longestCommonPrefix(String[] strs) {
    if (strs == null || strs.length == 0) {
      return "";
    }

    String prefix = strs[0];

    for (int i = 1; i < strs.length; i++) {
      while (strs[i].indexOf(prefix) != 0) {
        // update the prefix by shortening it by one char
        prefix = prefix.substring(0, prefix.length() - 1);
        if (prefix.isEmpty()) {
          return "";
        }
      }
    }

    return prefix;
  }
}
