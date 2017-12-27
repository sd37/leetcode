// https://leetcode.com/problems/closest-binary-search-tree-value/description/
// Status = AC

package com.leetcode.main.solution;

import com.leetcode.common.TreeNode;

public class ClosestValueBst {

  public int closestValue(TreeNode root, double target) {
    if(root == null) {
      return Integer.MAX_VALUE;
    }

    int closestValue = root.val;

    while (root != null) {
      double diff = Math.abs(target - root.val);
      if (diff < Math.abs(target - closestValue)) {
        closestValue = root.val;
      } else if (target < root.val) {
        root = root.left;
      } else {
        root = root.right;
      }
    }

    return closestValue;
  }
}
