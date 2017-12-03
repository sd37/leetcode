// https://leetcode.com/problems/first-unique-character-in-a-string/description/
// Status = AC

package com.leetcode.main.solution;

import java.util.HashMap;
import java.util.Map;

public class FirstUniqueChar {
  public int firstUniqChar(String s) {
    if(s == null || s.length() == 0) {
      return -1;
    }

    Map<Character, Integer> countMap = new HashMap<>();

    for(int i = 0; i < s.length(); i++) {
      char ch = s.charAt(i);
      countMap.put(ch, countMap.getOrDefault(ch, 0) + 1);
    }

    for (int i = 0; i < s.length(); i++) {
      char ch = s.charAt(i);
      if(countMap.get(ch) == 1) {
        return i;
      }
    }

    return -1;
  }
}
