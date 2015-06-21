package com.leetcode.main.solution; /**
 * https://leetcode.com/problems/contains-duplicate/
 * Status = Accepted
 */

import java.util.HashSet;
import java.util.Set;

public class ContainsDuplicate {
  public boolean containsDuplicate(int[] nums) {
    Set<Integer> seen = new HashSet<Integer>();
    for (int x : nums) {
      if (seen.contains(x)) {
        return true;
      }
      seen.add(x);
    }
    return false;
  }
}
