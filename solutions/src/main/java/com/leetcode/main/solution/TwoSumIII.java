// https://leetcode.com/problems/two-sum-iii-data-structure-design/description/
// Status = AC

package com.leetcode.main.solution;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class TwoSumIII {

  List<Integer> nums;

  /**
   * Initialize your data structure here.
   */
  public TwoSumIII() {
    this.nums = new ArrayList<>();
  }

  /**
   * Add the number to an internal data structure..
   */
  public void add(int number) {
    nums.add(number);
  }

  /**
   * Find if there exists any pair of numbers which sum is equal to the value.
   */
  public boolean find(int value) {
    Set<Integer> seen = new HashSet<>();

    for(int x : nums) {
      if(seen.contains(value - x)) {
        return true;
      }
      seen.add(x);
    }

    return false;
  }
}
