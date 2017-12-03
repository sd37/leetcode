/**
 * https://leetcode.com/problems/invert-binary-tree/
 * Status = Accepted
 */
package com.leetcode.main.solution;

import com.leetcode.common.TreeNode;

public class InvertBinaryTree {
  public TreeNode invertTree(TreeNode root) {
    if (root == null) {
      return null;
    }

    invertTree(root.right);
    invertTree(root.left);

    TreeNode tmp = root.left;
    root.left = root.right;
    root.right = tmp;

    return root;
  }
}
