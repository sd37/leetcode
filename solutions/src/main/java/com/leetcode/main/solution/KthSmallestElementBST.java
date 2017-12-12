package com.leetcode.main.solution;

import com.leetcode.common.TreeNode;

public class KthSmallestElementBST {
  private int result = Integer.MIN_VALUE;
  private int count = 0;

  public int kthSmallest(TreeNode root, int k) {
    if(root == null) {
      throw new RuntimeException("Invalid root");
    }

    inorder(root, k);

    return result;
  }

  private void inorder(TreeNode root, int k) {
    if(root == null) {
      return;
    }

    inorder(root.left, k);

    count++;

    if(count == k) {
      result = root.val;
      return;
    }

    inorder(root.right, k);
  }
}
