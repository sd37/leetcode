//https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/
package com.leetcode.main.solution;

import com.leetcode.common.TreeNode;

import java.util.*;

public class LCABst {
  public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
    if (root == null) {
      return null;
    }

    if (p == null || q == null) {
      return null;
    }


    List<TreeNode> p1 = bstSearch(root, p.val);
    List<TreeNode> p2 = bstSearch(root, q.val);

    Collections.reverse(p1);
    Collections.reverse(p2);

    Set<Integer> s = new HashSet<>();

    for (TreeNode x : p1) {
      s.add(x.val);
    }

    for (TreeNode y : p2) {
      if (s.contains(y.val)) {
        return y;
      }
    }
    return null;
  }

  private List<TreeNode> bstSearch(TreeNode root, int val) {
    if (root == null) {
      return null;
    }
    List<TreeNode> path = new ArrayList<>();
    TreeNode curr = root;
    while (curr != null) {
      path.add(curr);
      if (curr.val == val) {
        return path;
      } else if (val < curr.val) {
        curr = curr.left;
      } else {
        curr = curr.right;
      }
    }
    return null;
  }
}
