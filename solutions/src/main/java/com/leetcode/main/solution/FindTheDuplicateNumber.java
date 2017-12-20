// https://leetcode.com/problems/find-the-duplicate-number/description/
// Status = AC

package com.leetcode.main.solution;

import java.util.Arrays;

public class FindTheDuplicateNumber {

  public int findDuplicate(int[] nums) {
    if (nums == null || nums.length == 0) {
      throw new RuntimeException("Invalid Input!");
    }

    Arrays.sort(nums);

    for (int i = 0; i < nums.length - 1; i++) {
      if(nums[i] == nums[i + 1]) {
        return nums[i];
      }
    }

    // should not reach here.
    return Integer.MIN_VALUE;
  }
}
