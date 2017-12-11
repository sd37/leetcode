//https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/
// Status = AC
package com.leetcode.main.solution;

import com.leetcode.common.TreeNode;

import java.util.*;
import java.util.stream.Collectors;

public class LCABst {
  public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
    if (root == null) {
      return null;
    }

    if (p == null || q == null) {
      return null;
    }

    List<TreeNode> pathP = bstSearch(root, p.val);
    List<TreeNode> pathQ = bstSearch(root, q.val);

    Set<Integer> seen = pathP.stream().mapToInt(node -> node.val).boxed()
        .collect(Collectors.toSet());

    Collections.reverse(pathQ);

    for (TreeNode x : pathQ) {
      if(seen.contains(x.val)) {
        return x;
      }
    }

    return null;
  }

  private List<TreeNode> bstSearch(TreeNode root, int val) {
    List<TreeNode> path = new ArrayList<>();

    TreeNode curr = root;

    while(curr != null) {
      path.add(curr);

      if(curr.val == val) {
        break;
      } else if(val < curr.val) {
        curr = curr.left;
      } else {
        curr = curr.right;
      }
    }

    return path;
  }
}
