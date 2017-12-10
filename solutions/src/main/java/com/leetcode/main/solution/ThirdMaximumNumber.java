// https://leetcode.com/problems/third-maximum-number/description/
// Status = AC
package com.leetcode.main.solution;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class ThirdMaximumNumber {

  public int thirdMax(int[] nums) {
    if (nums == null) {
      throw new RuntimeException("Invalid nums");
    }

    List<Integer> lNums = Arrays.stream(nums).boxed().collect(Collectors.toSet())
        .stream().collect(Collectors.toList());

    Collections.sort(lNums, Comparator.reverseOrder());

    if (lNums.size() <= 2) {
      return lNums.get(0);
    }

    return lNums.get(2);
  }
}
