// https://leetcode.com/problems/minimum-absolute-difference-in-bst/description/
// Status = AC

package com.leetcode.main.solution;

import com.leetcode.common.TreeNode;

public class MinAbsDiffBst {

  private TreeNode prev;
  private int minDiff;

  public int getMinimumDifference(TreeNode root) {
    if (root == null) {
      return 0;
    }

    minDiff = Integer.MAX_VALUE;

    inOrder(root);

    return minDiff;
  }

  private void inOrder(TreeNode root) {
    if (root == null) {
      return;
    }

    inOrder(root.left);

    if (prev != null) {
      int diff = Math.abs(root.val - prev.val);
      minDiff = Math.min(minDiff, diff);
    }

    prev = root;

    inOrder(root.right);
  }
}
