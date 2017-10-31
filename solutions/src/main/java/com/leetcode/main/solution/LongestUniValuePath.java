// Status AC
package com.leetcode.main.solution;

import com.leetcode.common.TreeNode;

public class LongestUniValuePath {
  private int ans;

  public int longestUnivaluePathHelper(TreeNode root) {
    if (root == null) {
      return 0;
    }

    int longestPathLeft = longestUnivaluePathHelper(root.left);
    int longestPathRight = longestUnivaluePathHelper(root.right);

    // path through root.
    int longestPathThrRootLeft = 0;
    int longestPathThrRootRight = 0;

    if (root.left != null && root.val == root.left.val) {
      longestPathThrRootLeft = 1 + longestPathLeft;
    }

    if (root.right != null && root.val == root.right.val) {
      longestPathThrRootRight = 1 + longestPathRight;
    }

    ans = Math.max(ans, longestPathThrRootLeft + longestPathThrRootRight);
    return Math.max(longestPathThrRootLeft, longestPathThrRootRight);
  }

  public int longestUnivaluePath(TreeNode root) {
    if(root == null) {
      return 0;
    }
    ans = 0;
    longestUnivaluePathHelper(root);
    return ans;
  }
}
