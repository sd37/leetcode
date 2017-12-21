package com.leetcode.main.solution;

import java.util.Arrays;

public class SearchInRotatedSortedArray {

  public int search(int[] nums, int target) {
    if (nums == null || nums.length == 0) {
      return -1;
    }

    int inflecPt = findInflectionPoint(nums);

    int ans = -1;
    if (target < nums[0]) {
      ans = Arrays.binarySearch(nums, inflecPt + 1, nums.length, target);
    } else {
      ans = Arrays.binarySearch(nums, 0, inflecPt + 1, target);
    }

    return (ans < 0 ? -1 : ans);
  }

  private int findInflectionPoint(int[] nums) {
    int l = 0;
    int r = nums.length - 1;

    int mid = -1;
    while (l <= r) {
      mid = l + (r - l) / 2;

      if ((mid > 0 && mid < nums.length - 1)
          && (nums[mid] > nums[mid - 1] && nums[mid] > nums[mid + 1])) {
        return mid;
      } else if (nums[mid] > nums[0]) {
        l = mid + 1;
      } else {
        r = mid - 1;
      }
    }

    return mid;
  }
}
