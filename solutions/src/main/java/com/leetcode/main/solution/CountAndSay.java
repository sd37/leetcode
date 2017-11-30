// https://leetcode.com/problems/count-and-say/description/
// Status = AC

package com.leetcode.main.solution;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class CountAndSay {

  public String countAndSay(int n) {
    if (n <= 1) {
      return "1";
    }

    String currentRes = "1";
    String nextRes = null;

    for (int i = 2; i <= n; i++) {
      nextRes = countAndSayUtil(currentRes);
      currentRes = nextRes;
    }

    return nextRes;
  }


  String countAndSayUtil(String s) {
    String res = "";

    if (s == null) {
      return "";
    }

    int count = 1;

    int i = 0;
    int j = i + 1;

    char currChar = 'X';
    char nextChar = 'X';

    while (j < s.length()) {
      currChar = s.charAt(i);
      nextChar = s.charAt(j);

      String intRes = Character.toString(currChar);
      if (currChar == nextChar) {
        count++;
      } else {
        res += Integer.toString(count) + Character.toString(currChar);
        count = 1;
      }

      i++;
      j++;
    }

    if (j == s.length()) {
      // note the nextChar here.
      res += Integer.toString(count) + ((j == 1) ? s : Character.toString(nextChar));
    }

    return res;
  }
}
