// https://leetcode.com/problems/longest-substring-without-repeating-characters/description/
// Status = AC
// TC = O(n^2)
// SC = O(n)

package com.leetcode.main.solution;

import java.util.HashSet;
import java.util.Set;

public class LongestSubstring {
  public int lengthOfLongestSubstring(String s) {
    if(s == null || s.length() == 0) {
      return 0;
    }

    if(s.length() == 1) {
      return 1;
    }

    Set<Character> seen = new HashSet<>();
    int longestSubstr = Integer.MIN_VALUE;
    int count = 0;

    for(int i = 0; i < s.length(); i++) {
      count = 0;
      for(int j = i; j < s.length(); j++) {
        if(seen.contains(s.charAt(j))) {
          break;
        }
        seen.add(s.charAt(j));
        count++;
      }
      longestSubstr = Math.max(longestSubstr, count);
      seen.clear();
    }

    return longestSubstr;
  }
}
