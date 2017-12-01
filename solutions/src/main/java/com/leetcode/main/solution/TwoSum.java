// https://leetcode.com/problems/two-sum/description/
// Status = AC

package com.leetcode.main.solution;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class TwoSum {

  public int[] twoSum(int[] nums, int target) {
    Map<Integer, Integer> seen = new HashMap<>();

    for (int i = 0; i < nums.length; i++) {
      int diff = target - nums[i];
      if (seen.containsKey(diff)) {
        return new int[]{seen.get(diff), i};
      }
      seen.put(nums[i], i);
    }

    return null;
  }
}
