// https://leetcode.com/problems/two-sum-iv-input-is-a-bst/description/
// Status = AC

package com.leetcode.main.solution;

import com.leetcode.common.TreeNode;
import java.util.HashSet;
import java.util.Set;

public class TwoSumIV {

  public boolean findTarget(TreeNode root, int k) {
    if (root == null) {
      return false;
    }

    Set<Integer> seen = new HashSet<>();

    return findUtil(root, k, seen);
  }

  private boolean findUtil(TreeNode root, int k, Set<Integer> seen) {
    if (root == null) {
      return false;
    }

    if (seen.contains(k - root.val)) {
      return true;
    }

    seen.add(root.val);

    return findUtil(root.left, k, seen) ||
        findUtil(root.right, k, seen);
  }
}
