//https://leetcode.com/problems/path-sum/
package com.leetcode.main.solution;

import com.leetcode.common.TreeNode;

public class PathSum {
  public boolean hasPathSum(TreeNode root, int sum) {
    if (root == null) {
      return false;
    }

    if (root.left == null && root.right == null) {
      return sum == root.val;
    }

    return hasPathSum(root.left, sum - root.val)
        || hasPathSum(root.right, sum - root.val);
  }
}
