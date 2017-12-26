// https://leetcode.com/problems/word-break/description/
// Status = AC
package com.leetcode.main.solution;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordBreak {

  public boolean wordBreak(String s, List<String> wordDict) {
    Boolean[] memo = new Boolean[s.length()];
    return wordBreakUtil(s, 0, new HashSet<>(wordDict), memo);
  }

  private boolean wordBreakUtil(String s, int start, Set<String> wordDict, Boolean[] memo) {
    if (start == s.length()) {
      return true;
    }

    if(memo[start] != null) {
      return memo[start];
    }

    for (int end = start + 1; end <= s.length(); end++) {
      if (wordDict.contains(s.substring(start, end)) && wordBreakUtil(s, end, wordDict, memo)) {
        return (memo[start] = true);
      }
    }

    return (memo[start] = false); // backtrack
  }
}
