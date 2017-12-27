// https://leetcode.com/problems/permutations/description/
// Status = AC

package com.leetcode.main.solution;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Permutations {

  public List<List<Integer>> permute(int[] nums) {
    List<List<Integer>> res = new ArrayList<>();

    if (nums == null || nums.length == 0) {
      return res;
    }

    permuteUtil(nums, res, 0, nums.length - 1);

    return res;
  }

  private void permuteUtil(int nums[], List<List<Integer>> res, int s, int e) {
    // not s >= e will fail!, because you are ignoring the last element.
    if (s > e) {
      res.add(Arrays.stream(nums).boxed().collect(Collectors.toList()));
    }

    for (int i = s; i <= e; i++) {
      swap(nums, s, i);
      permuteUtil(nums, res, s + 1, e);
      swap(nums, s, i); // backtrack
    }
  }

  private void swap(int nums[], int i, int j) {
    int tmp = nums[i];
    nums[i] = nums[j];
    nums[j] = tmp;
  }
}
