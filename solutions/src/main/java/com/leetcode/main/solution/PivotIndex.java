// https://leetcode.com/problems/find-pivot-index/description/
// Status = AC
package com.leetcode.main.solution;

import java.util.Arrays;

public class PivotIndex {
  public int pivotIndex(int[] nums) {
    if(nums == null || nums.length == 0) {
      return -1;
    }

    int totalSum = Arrays.stream(nums).sum();

    int leftSum = 0;

    for (int i = 0; i < nums.length; i++) {
      if(leftSum == totalSum - leftSum - nums[i]) {
        return i;
      }

      leftSum += nums[i];
    }

    return -1;
  }
}
