// https://leetcode.com/problems/max-consecutive-ones/description/
// Status = AC
package com.leetcode.main.solution;

public class MaxConsecutiveOnes {
  public int findMaxConsecutiveOnes(int[] nums) {
    if(nums == null || nums.length == 0) {
      return 0;
    }

    int maxCount = Integer.MIN_VALUE;
    int count = 0;

    for(int x : nums) {
      if(x == 1) {
        count++;
      } else {
        maxCount = Math.max(maxCount, count);
        count = 0;
      }
    }

    return Math.max(maxCount, count);
  }
}
