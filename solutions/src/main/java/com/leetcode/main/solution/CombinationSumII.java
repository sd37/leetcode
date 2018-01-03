// https://leetcode.com/problems/combination-sum-ii/description/
// Status = AC

package com.leetcode.main.solution;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSumII {
  public List<List<Integer>> combinationSum2(int[] candidates, int target) {
    List<List<Integer>> res = new ArrayList<>();
    if (candidates == null || candidates.length == 0) {
      return res;
    }

    // sorting is important here to remove redundant entries.
    Arrays.sort(candidates);
    combSumUtil(candidates, 0, 0, new ArrayList<>(), target, res);
    return res;
  }

  private void combSumUtil(int[] candidates, int start, int currSum, List<Integer> currList,
      int target, List<List<Integer>> res) {

    if (currSum > target) {
      // all numbers including target will be +ve.
      return;
    }

    if (currSum == target) {
      // the new ArrayList<>() is imp here. Because everything is java is a reference.
      // so if you just use currList you will get empty [[],[], ..] as ans.
      res.add(new ArrayList<>(currList));
      return;
    }

    for (int i = start; i < candidates.length; i++) {
      if(i > start && (candidates[i - 1] == candidates[i])) {
        continue;
      }
      currList.add(candidates[i]);
      combSumUtil(candidates, i + 1, currSum + candidates[i], currList, target, res);
      currList.remove(currList.size() - 1);
    }
  }
}
