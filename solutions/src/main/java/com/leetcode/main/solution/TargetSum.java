// https://leetcode.com/problems/target-sum/discuss/
// status = AC

package com.leetcode.main.solution;

import java.util.HashMap;
import java.util.Map;

public class TargetSum {
  private char[] symbols = new char[] {'+', '-'};

  public int findTargetSumWays(int[] nums, int S) {
    if(nums == null) {
      return 0;
    }

    Map<String, Integer> mp = new HashMap<>();
    return findWaysUtil(nums, 0, S, mp);
  }

  private int findWaysUtil(int[] nums, int off, int t, Map<String, Integer> mp) {
    String keyString = Integer.toString(off) + "->" + t;

    if(off == nums.length) {
      if(t == 0) {
        return 1;
      }
      return 0;
    }

    if (mp.containsKey(keyString)) {
      return mp.get(keyString);
    }

    int numOfWays = 0;
    for (int i = 0; i < symbols.length; i++) {
      int option = convertor(symbols[i], nums[off]);
      numOfWays += findWaysUtil(nums, off + 1, t - option, mp);
    }

    mp.put(keyString, numOfWays);
    return numOfWays;
  }

  private int convertor(char sym, int x) {
    return (sym == '-' ? (-1 * x) : x);
  }
}
