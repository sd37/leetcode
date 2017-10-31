// https://leetcode.com/problems/convert-bst-to-greater-tree/
// Status = AC

package com.leetcode.main.solution;

import com.leetcode.common.TreeNode;

public class ConvertBstToGreaterTree {
  private int residueSum;

  public TreeNode convertBST(TreeNode root) {
    if (root == null) {
      return null;
    }

    residueSum = 0;
    convertBstHelper(root, null);
    return root;
  }

  private void convertBstHelper(TreeNode root, TreeNode parent) {
    if (root.right != null) {
      convertBstHelper(root.right, root);
    }

    root.val += residueSum;
    residueSum = root.val;

    if (root.left != null) {
      convertBstHelper(root.left, root);
    }
  }
}
