/**
 * https://leetcode.com/problems/rotate-array/
 * Status = Accepted
 */

package com.leetcode.main.solution;

public class RotateArray {
  public void rotate(int[] nums, int k) {
    if (k < 0) {
      throw new IllegalArgumentException("k < 0");
    }
    k = k % nums.length;
    rotateLeft(nums, nums.length - k);
  }

  private void rotateLeft(int[] nums, int k) {
    if (k < 0) {
      throw new IllegalArgumentException("k < 0");
    }
    k = k % nums.length;
    reverse(nums, 0, k - 1);
    reverse(nums, k, nums.length - 1);
    reverse(nums, 0, nums.length - 1);
  }

  private void reverse(int[] nums, int f, int l) {
    while (f < l) {
      int tmp = nums[f];
      nums[f] = nums[l];
      nums[l] = tmp;
      f++;
      l--;
    }
  }
}
