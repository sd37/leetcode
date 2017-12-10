// https://leetcode.com/problems/reverse-words-in-a-string-iii/description/
// Status = AC

package com.leetcode.main.solution;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ReverseWordsStringIII {
  public String reverseWords(String s) {
    if(s == null || "".equals(s)) {
      return s;
    }

    List<String> tokens = Arrays.stream(s.split(" ")).map(s1 -> new StringBuilder(s1).reverse().toString()).collect(
        Collectors.toList());

    return tokens.stream().collect(Collectors.joining(" "));
  }
}
