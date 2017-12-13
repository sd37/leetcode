// https://leetcode.com/problems/missing-number/
// Status = AC

package com.leetcode.main.solution;
public class MissingNumber {
  public int missingNumber(int[] nums) {
    if(nums == null) {
      throw new RuntimeException("nums == null");
    }

    int ans = 0;

    for (int i = 0; i <= nums.length; i++) {
      ans ^= i;
    }

    for (int x : nums) {
      ans ^= x;
    }

    return ans;
  }
}
