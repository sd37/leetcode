// https://leetcode.com/problems/product-of-array-except-self/description/
// Status = Accepted

package com.leetcode.main.solution;

public class ProductExceptSelf {

  public int[] productExceptSelf(int[] nums) {
    int[] result = new int[nums.length];

    result[nums.length - 1] = 1;

    for (int i = nums.length - 2; i >= 0; i--) {
      result[i] = result[i + 1] * nums[i + 1];
    }

    int tmp = 1;
    for (int i = 1; i < nums.length; i++) {
      tmp *= nums[i - 1];
      result[i] *= tmp;
    }

    return result;
  }
}
