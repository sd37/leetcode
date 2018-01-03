// https://leetcode.com/problems/combination-sum-iii/description/
// Status = AC
package com.leetcode.main.solution;

import java.util.ArrayList;
import java.util.List;

public class CombinationSumIII {

  public List<List<Integer>> combinationSum3(int k, int n) {
    List<List<Integer>> res = new ArrayList<>();

    if (n <= 0) {
      return res;
    }

    int start = 1;
    combSumUtil(k, n, start, 0, new ArrayList<>(), res);
    return res;
  }

  private void combSumUtil(int k, int target, int start, int currSum, List<Integer> currList,
      List<List<Integer>> res) {

    if (currList.size() > k || currSum > target) {
      return;
    }

    if (k == currList.size() && currSum == target) {
      res.add(new ArrayList<>(currList));
      return;
    }

    for (int i = start; i <= 9; i++) {
      currList.add(i);
      combSumUtil(k, target, i + 1, currSum + i, currList, res);
      currList.remove(currList.size() - 1);
    }
  }
}
