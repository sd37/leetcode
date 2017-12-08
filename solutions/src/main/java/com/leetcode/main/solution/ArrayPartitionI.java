package com.leetcode.main.solution;

import java.util.Arrays;

public class ArrayPartitionI {

  public int arrayPairSum(int[] nums) {
    if (nums == null || nums.length == 0) {
      return 0;
    }

    Arrays.sort(nums);

    int maxSum = 0;
    for (int i = 1; i < nums.length; i += 2) {
      maxSum += Math.min(nums[i - 1], nums[i]);
    }

    return maxSum;
  }
}
