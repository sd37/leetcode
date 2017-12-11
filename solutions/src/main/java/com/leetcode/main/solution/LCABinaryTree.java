package com.leetcode.main.solution;

import com.leetcode.common.TreeNode;

public class LCABinaryTree {
  public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
    if(root == null || p == null || q == null) {
      throw new RuntimeException("Invalid input args");
    }

    return lcaUtil(root, p, q);
  }

  private TreeNode lcaUtil(TreeNode root, TreeNode p, TreeNode q) {
    if(root == p || root == q) {
      return root;
    }

    boolean leftP = isPresent(root.left, p);
    boolean leftQ = isPresent(root.left, q);

    if(leftP && leftQ) {
      lcaUtil(root.left, p, q);
    }

    if(!leftP && !leftQ) {
      lcaUtil(root.right, p, q);
    }

    // otherwise they are present in opp sides return root
    return root;
  }

  private boolean isPresent(TreeNode root, TreeNode p) {
    if(root == null) {
      return false;
    }

    return root == p || isPresent(root.left, p) || isPresent(root.right, p);
  }
}