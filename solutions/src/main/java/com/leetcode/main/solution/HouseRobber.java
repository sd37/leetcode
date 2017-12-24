// https://leetcode.com/problems/house-robber/description/
// Status = AC

package com.leetcode.main.solution;

public class HouseRobber {
  public int rob(int[] nums) {
    if(nums == null || nums.length == 0) {
      return 0;
    }

    if(nums.length == 1) {
      return nums[0];
    }

    int[] profits = new int[nums.length];
    int[] maxProfitsSeen = new int[nums.length];

    profits[0] = nums[0];
    profits[1] = nums[1];

    maxProfitsSeen[0] = profits[0];
    maxProfitsSeen[1] = Math.max(profits[0], profits[1]);

    for (int i = 2; i < nums.length; i++) {
      profits[i] = nums[i] + maxProfitsSeen[i - 2];
      maxProfitsSeen[i] = Math.max(maxProfitsSeen[i - 1], profits[i]);
    }

    return maxProfitsSeen[nums.length - 1];
  }
}
