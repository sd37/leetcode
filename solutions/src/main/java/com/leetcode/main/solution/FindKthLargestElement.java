// https://leetcode.com/problems/kth-largest-element-in-an-array/description/
// Status = AC
package com.leetcode.main.solution;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class FindKthLargestElement {

  public int findKthLargest(int[] nums, int k) {
    List<Integer> aList = Arrays.stream(nums).boxed().collect(Collectors.toList());
    Collections.sort(aList, Comparator.reverseOrder());

    return aList.get(k - 1);
  }
}
