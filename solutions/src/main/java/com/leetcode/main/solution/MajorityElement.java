// https://leetcode.com/problems/majority-element/description/
// Status = AC
package com.leetcode.main.solution;

import java.util.Arrays;
import java.util.Iterator;

public class MajorityElement {

  public int majorityElement(int[] nums) {
    Iterator<Integer> it = Arrays.stream(nums).iterator();

    int count = 0;
    Integer candidate = null;

    while (it.hasNext()) {
      int x = it.next();

      if (count == 0) {
        candidate = x;
      }

      count += (candidate == x ? 1 : -1);
    }

    return candidate;
  }
}
