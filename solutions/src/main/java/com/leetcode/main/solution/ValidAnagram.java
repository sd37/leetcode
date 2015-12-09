package com.leetcode.main.solution;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class ValidAnagram {
  public boolean isAnagram1(String s, String t) {
    String sortedS = sortCharString(s);
    String sortedT = sortCharString(t);
    return Objects.equals(sortedS, sortedT);
  }

  public boolean isAnagram(String s, String t) {
    Map<Character, Integer> charCount = new HashMap<>();

    for (Character ch : s.toCharArray()) {
      if (!charCount.containsKey(ch)) {
        charCount.put(ch, 0);
      }
      charCount.put(ch, charCount.get(ch) + 1);
    }

    for (Character ch : t.toCharArray()) {
      if (!charCount.containsKey(ch) || charCount.get(ch) < 0) {
        return false;
      }
      charCount.put(ch, charCount.get(ch) - 1);
    }

    for (Character ch : charCount.keySet()) {
      if (charCount.get(ch) != 0) {
        return false;
      }
    }

    return true;
  }

  private String sortCharString(String s) {
    if (s == null) {
      return null;
    }

    char[] newS = s.toCharArray();
    Arrays.sort(newS);

    return new String(newS);
  }
}
