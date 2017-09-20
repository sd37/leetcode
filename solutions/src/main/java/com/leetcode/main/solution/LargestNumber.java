// https://leetcode.com/problems/largest-number/description/
// Status = AC

package com.leetcode.main.solution;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LargestNumber {
  public String largestNumber(int[] nums) {
    List<String> numsStr = Arrays.stream(nums).mapToObj(x -> String.valueOf(x))
        .sorted((s1, s2) -> (s2 + s1).compareTo(s1 + s2)).collect(Collectors.toList());

    // check if you have all zeros in the array.
    if(numsStr.get(0).charAt(0) == '0') {
      return "0";
    }

    return numsStr.stream().collect(Collectors.joining());
  }
}
