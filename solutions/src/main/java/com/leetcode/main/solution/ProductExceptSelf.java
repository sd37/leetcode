// https://leetcode.com/problems/product-of-array-except-self/description/
// Status = Accepted
/*
Given an integer array nums, return an array answer such that answer[i] is equal to the product of all the elements of nums except nums[i].

The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.

You must write an algorithm that runs in O(n) time and without using the division operation.



Example 1:

Input: nums = [1,2,3,4]
Output: [24,12,8,6]
Example 2:

Input: nums = [-1,1,0,-3,3]
Output: [0,0,9,0,0]
 */

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
