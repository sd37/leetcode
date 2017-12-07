// https://leetcode.com/problems/3sum/discuss/
// Status = AC
package com.leetcode.main.solution;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ThreeSum {

  public List<List<Integer>> threeSum(int[] nums) {
    Set<List<Integer>> res = new HashSet<>();

    if (nums == null || nums.length == 0) {
      return new ArrayList<>();
    }

    Arrays.sort(nums);

    for (int i = 0; i < nums.length; i++) {
      int first = nums[i];

      for (List<Integer> l : findTwoSums(nums, i + 1, -first)) {
        res.add(l);
      }
    }

    return new ArrayList<List<Integer>>(res);
  }

  private List<List<Integer>> findTwoSums(int[] nums, int i, int k) {
    List<List<Integer>> res = new ArrayList<>();

    int f = i;
    int l = nums.length - 1;
    while (f < l) {
      if (nums[f] + nums[l] == k) {
        res.add(Arrays.asList(-k, nums[f], nums[l]));
        f++;
        l--;
      } else if (nums[f] + nums[l] < k) {
        f++;
      } else {
        l--;
      }
    }

    return res;
  }
}
