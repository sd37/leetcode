// https://leetcode.com/problems/longest-palindrome/description/
// Status = AC

package com.leetcode.main.solution;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class LongestPalindrome {
  public int longestPalindrome(String s) {
    if(s == null || s.length() == 0) {
      return 0;
    }

    Map<Character, Integer> countMap = new HashMap<>();

    for(int i = 0; i < s.length(); i++) {
      char ch = s.charAt(i);
      countMap.put(ch, countMap.getOrDefault(ch, 0) + 1);
    }

    if(countMap.size() == 1) {
      return s.length();
    }

    int res = 0;
    int oddCount = 0;
    for (Entry<Character, Integer> kv : countMap.entrySet()) {
      if(kv.getValue() % 2 == 0) {
        res += kv.getValue();
      } else {
        // if subtract 1 from an odd integer we get even. Which can be used to generate the palindrome.
        res += kv.getValue() - 1;
        oddCount++;
      }
    }

    // if oddCount !=0 we can place a single char in the middle, so need to add 1.
    if(oddCount != 0) {
      res++;
    }

    return res;
  }
}
