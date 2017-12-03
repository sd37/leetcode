// https://leetcode.com/problems/move-zeroes/description/
// Status = AC

package com.leetcode.main.solution;

public class MoveZeros {
  public void moveZeroes(int[] nums) {
    if (nums == null) {
      throw new RuntimeException("Illegal nums = " + nums);
    }

    int insertPos = 0;
    for(int x : nums) {
      if(x != 0) {
        nums[insertPos] = x;
        insertPos++;
      }
    }

    // fill rest with zeros.
    for (int i = insertPos; i < nums.length; i++) {
      nums[i] = 0;
    }
  }
}
