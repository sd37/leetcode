package com.leetcode.main.solution;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class UniquePermutations {
  public List<List<Integer>> permuteUnique(int[] nums) {
    List<List<Integer>> res = new ArrayList<>();

    if(nums == null || nums.length == 0) {
      return res;
    }

    permUtil(nums, 0, nums.length - 1, res);
    return res;
  }

  private void permUtil(int[] nums, int s, int e, List<List<Integer>> res) {
    if(s > e) {
      res.add(Arrays.stream(nums).boxed().collect(Collectors.toList()));
      return;
    }

    Set<Integer> appeared = new HashSet<>();

    for (int i = s; i <= e ; i++) {
      if(appeared.contains(nums[i])) {
        continue;
      }

      appeared.add(nums[i]);

      swap(nums, s, i);
      permUtil(nums, s + 1, e, res);
      swap(nums, s, i); // backtrack
    }
  }

  private void swap(int[] nums, int i, int j) {
    int tmp = nums[i];
    nums[i] = nums[j];
    nums[j] = tmp;
  }
}
