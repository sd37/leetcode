// https://leetcode.com/problems/longest-consecutive-sequence/description/
// Status = AC

package com.leetcode.main.solution;

import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSequence {

  public int longestConsecutive(int[] nums) {
    if (nums == null || nums.length == 0) {
      return 0;
    }

    Set<Integer> numSet = new HashSet<>();

    for (int x : nums) {
      numSet.add(x);
    }

    int maxStreak = Integer.MIN_VALUE;

    for (int x : nums) {
      if (!numSet.contains(x - 1)) {
        int currNum = x;
        int currStreak = 1;
        while(numSet.contains(currNum + 1)) {
          currNum++;
          currStreak++;
        }

        maxStreak = Math.max(maxStreak, currStreak);
      }
    }

    return maxStreak;
  }
}
