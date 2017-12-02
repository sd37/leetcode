// https://leetcode.com/problems/roman-to-integer/discuss/
// Status = AC

package com.leetcode.main.solution;

import java.util.HashMap;
import java.util.Map;

public class RomanToInteger {

  public int romanToInt(String s) {
    if (s == null || "".equals(s)) {
      return 0;
    }

    Map<Character, Integer> translator = getTranslation();

    int num = translator.get(s.charAt(s.length() - 1));

    for (int i = 0; i < s.length() - 1; i++) {
      int curr = translator.get(s.charAt(i));
      int next = translator.get(s.charAt(i + 1));

      if (curr < next) {
        num -= curr;
      } else {
        num += curr;
      }
    }

    return num;
  }

  private static Map<Character, Integer> getTranslation() {
    Map<Character, Integer> translator = new HashMap<>();

    translator.put('I', 1);
    translator.put('V', 5);
    translator.put('X', 10);
    translator.put('L', 50);
    translator.put('C', 100);
    translator.put('D', 500);
    translator.put('M', 1000);

    return translator;
  }
}
