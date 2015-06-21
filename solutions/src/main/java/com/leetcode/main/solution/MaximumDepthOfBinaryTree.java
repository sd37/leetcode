/**
 * https://leetcode.com/problems/maximum-depth-of-binary-tree/
 * Status = Accepted
 */
package com.leetcode.main.solution;

import com.leetcode.common.TreeNode;

public class MaximumDepthOfBinaryTree {
  public int maxDepth(TreeNode root) {
    if (root == null) {
      return 0;
    }
    return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
  }
}
