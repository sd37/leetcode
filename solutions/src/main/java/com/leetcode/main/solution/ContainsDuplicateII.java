// https://leetcode.com/problems/contains-duplicate-ii/description/
// Status = AC

package com.leetcode.main.solution;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ContainsDuplicateII {

  public boolean containsNearbyDuplicate(int[] nums, int k) {
    if (nums == null || nums.length == 0) {
      return false;
    }

    Map<Integer, List<Integer>> seen = new HashMap<>();

    for (int i = 0; i < nums.length; i++) {
      if(seen.containsKey(nums[i])) {
        for(int x : seen.get(nums[i])) {
          if(Math.abs(i - x) <= k) {
            return true;
          }
        }
      }

      if(!seen.containsKey(nums[i])) {
        seen.put(nums[i], new ArrayList<>());
      }

      seen.get(nums[i]).add(i);
    }

    return false;
  }
}
