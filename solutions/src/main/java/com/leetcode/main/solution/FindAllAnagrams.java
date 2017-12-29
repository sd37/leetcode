// https://leetcode.com/problems/find-all-anagrams-in-a-string/description/
// Status = AC
package com.leetcode.main.solution;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindAllAnagrams {

  public List<Integer> findAnagrams(String s, String p) {
    List<Integer> list = new ArrayList<>();

    if (s == null || s.length() == 0 || p == null || p.length() == 0) {
      return list;
    }

    Map<Character, Integer> countMap = new HashMap<>();

    for (int i = 0; i < p.length(); i++) {
      char ch = p.charAt(i);
      countMap.put(ch, countMap.getOrDefault(ch, 0) + 1);
    }

    int left = 0;
    int right = 0;
    int count = p.length();

    while (right < s.length()) {
      // here the condition counMap.get(s.charAt(right)) >= 1 is imp, otherwise a series of
      // repeated chars will push count to -ve values.
      if (countMap.containsKey(s.charAt(right)) && countMap.get(s.charAt(right)) >= 1) {
        count--;
      }

      // this should be outside to indicate the if countMap contains -ve values, there are
      // more chars in s that are contained in p.
      // -ve values indicate char is not in p.
      countMap.put(s.charAt(right), countMap.getOrDefault(s.charAt(right), 0) - 1);
      right++;

      if (count == 0) {
        list.add(left);
      }

      // update the window, shrink the window by 1.
      if (right - left == p.length()) {
        if (countMap.containsKey(s.charAt(left)) && countMap.get(s.charAt(left)) >= 0) {
          count++;
        }
        countMap.put(s.charAt(left), countMap.get(s.charAt(left)) + 1);
        left++;
      }
    }

    return list;
  }
}
