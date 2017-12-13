// https://leetcode.com/problems/validate-binary-search-tree/description/
// Status = AC
package com.leetcode.main.solution;

import com.leetcode.common.TreeNode;

public class ValidateBinarySearchTree {
  private TreeNode prev;

  public boolean isValidBST(TreeNode root) {
    if(root == null) {
      return true;
    }

    if(!isValidBST(root.left)) {
      return false;
    }

    // violates inorder condition.
    if(prev != null && root.val <= prev.val) {
      return false;
    }

    prev = root;

    return isValidBST(root.right);
  }
}
