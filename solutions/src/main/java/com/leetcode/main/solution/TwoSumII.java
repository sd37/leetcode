// https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/discuss/
// Status = AC
package com.leetcode.main.solution;

public class TwoSumII {

  public int[] twoSum(int[] nums, int k) {
    if (nums == null || nums.length == 0) {
      return new int[]{};
    }

    int f = 0;
    int l = nums.length - 1;

    while (f < l) {
      if (nums[f] + nums[l] == k) {
        return new int[]{f + 1, l + 1};
      } else if (nums[f] + nums[l] < k) {
        f++;
      } else {
        l--;
      }
    }
    return new int[]{};
  }
}
