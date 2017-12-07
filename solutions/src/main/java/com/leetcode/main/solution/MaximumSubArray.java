// https://leetcode.com/problems/maximum-subarray/discuss/
// Status = AC

package com.leetcode.main.solution;

public class MaximumSubArray {
  public int maxSubArray(int[] nums) {
    if (nums == null || nums.length == 0) {
      return 0;
    }

    int[] s = new int[nums.length];

    s[0] = nums[0];
    int maxSoFar = s[0];

    for (int i = 1; i < nums.length; i++) {
      s[i] = Math.max(s[i-1] + nums[i], nums[i]);
      maxSoFar = Math.max(maxSoFar, s[i]);
    }

    return maxSoFar;
  }
}
