//https://leetcode.com/problems/single-number/description/
// Status = AC

package com.leetcode.main.solution;

import java.util.Arrays;

public class SingleNumber {
  public int singleNumber(int[] nums) {
    return Arrays.stream(nums).reduce((a, b) -> a^b).getAsInt();
  }
}
