package com.leetcode.main.solution;

public class NonDecreasingArray {

  public boolean checkPossibility(int[] nums) {
    if (nums == null || nums.length == 0) {
      return true;
    }

    int discrepancyCount = 0;

    for (int i = 0; i < nums.length - 1; i++) {
      if (nums[i] > nums[i + 1]) {
        discrepancyCount++;
      }
    }

    return (discrepancyCount <= 1);
  }
}
