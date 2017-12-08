package com.leetcode.main.solution;

import java.util.Arrays;

public class ArrayPartitionI {

  public int arrayPairSum(int[] nums) {
    if (nums == null || nums.length == 0) {
      return 0;
    }

    Arrays.sort(nums);

    int maxSum = Integer.MIN_VALUE;
    for (int i = 2; i < nums.length; i += 2) {
      maxSum += Math.min(nums[i - 1], nums[i]);
    }

    return maxSum;
  }
}
