// https://leetcode.com/problems/word-break-ii/description/
// Status = AC

package com.leetcode.main.solution;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class WordBreakII {

  public List<String> wordBreak(String s, List<String> wordDict) {
    if(s == null || s.length() == 0) {
      return new ArrayList<>();
    }

    Map<Integer, List<String>> memo = new HashMap<>();
    return wordBreakUtil(s, 0, new HashSet<String>(wordDict), memo);
  }

  private List<String> wordBreakUtil(String s, int start,
      Set<String> wordDict, Map<Integer, List<String>> memo) {

    if(memo.containsKey(start)) {
      return memo.get(start);
    }

    List<String> res = new ArrayList<>();

    if(start == s.length()) {
      // put "" at the end so that the whole string can be recovered.
      res.add("");
      return res;
    }

    for (int end = start + 1; end <= s.length(); end++) {
      String subStr = s.substring(start, end);

      if(wordDict.contains(subStr)) {
        List<String> list = wordBreakUtil(s, end, wordDict, memo);

        for(String x : list) {
          res.add((subStr + " " + x).trim());
        }
      }
    }

    memo.put(start, res);
    return res;
  }
}
