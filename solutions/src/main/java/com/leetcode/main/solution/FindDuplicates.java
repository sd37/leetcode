// https://leetcode.com/problems/find-all-duplicates-in-an-array/description/
// Status = AC

package com.leetcode.main.solution;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindDuplicates {
  public List<Integer> findDuplicates(int[] nums) {
    List<Integer> res = new ArrayList<>();

    if(nums == null || nums.length == 0) {
      return res;
    }

    Map<Integer, Integer> countMap = new HashMap<>();

    for (int x : nums) {
      countMap.put(x, countMap.getOrDefault(x, 0) + 1);
    }

    for(int x : countMap.keySet()) {
      if(countMap.get(x) == 2) {
        res.add(x);
      }
    }

    return res;
  }
}
