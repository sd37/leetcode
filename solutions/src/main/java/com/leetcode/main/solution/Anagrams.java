/**
 * https://leetcode.com/problems/anagrams/
 * Status = Accepted.
 */
package com.leetcode.main.solution;

import java.util.*;

public class Anagrams {
  public List<String> anagrams(String[] strs) {
    if (strs == null) {
      throw new RuntimeException("str == null illegal input.");
    }

    List<String> anagrams = new ArrayList<>();

    Map<String, List<String>> anagramMap = new HashMap<>();
    for (String s : strs) {
      String sortedS = sortedCharString(s);
      if (!anagramMap.containsKey(sortedS)) {
        anagramMap.put(sortedS, new ArrayList<String>());
      }
      anagramMap.get(sortedS).add(s);
    }

    for (String key : anagramMap.keySet()) {
      if (anagramMap.get(key).size() > 1) {
        anagrams.addAll(anagramMap.get(key));
      }
    }
    return anagrams;
  }

  private String sortedCharString(String s) {
    if (s == null) {
      return null;
    }

    char[] arrS = s.toCharArray();
    Arrays.sort(arrS);
    return new String(arrS);
  }
}
