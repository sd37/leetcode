// Status = AC
// https://leetcode.com/problems/symmetric-tree/description/
package com.leetcode.main.solution;

import com.leetcode.common.TreeNode;

public class SymmetricTree {

  public boolean isSymmetric(TreeNode root) {
    if (root == null) {
      return true;
    }

    return isSymTreeHelper(root.left, root.right);
  }

  public boolean isSymTreeHelper(TreeNode leftRoot, TreeNode rightRoot) {
    if (leftRoot == null && rightRoot == null) {
      return true;
    }

    if ((leftRoot == null && rightRoot != null) || (leftRoot != null && rightRoot == null)) {
      return false;
    }

    return leftRoot.val == rightRoot.val && isSymTreeHelper(leftRoot.left, rightRoot.right)
        && isSymTreeHelper(leftRoot.right, rightRoot.left);
  }
}
