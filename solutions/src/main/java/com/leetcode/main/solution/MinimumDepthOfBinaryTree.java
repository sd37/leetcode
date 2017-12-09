/**
 * https://leetcode.com/problems/minimum-depth-of-binary-tree/ Status = Accepted
 */
package com.leetcode.main.solution;

import com.leetcode.common.TreeNode;
import java.util.AbstractMap.SimpleEntry;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Map.Entry;

public class MinimumDepthOfBinaryTree {

  public int minDepth(TreeNode root) {
    if (root == null) {
      return 0;
    }

    Deque<Entry<TreeNode, Integer>> q = new ArrayDeque<>();

    q.add(new SimpleEntry<TreeNode, Integer>(root, 1));

    while (!q.isEmpty()) {
      Entry<TreeNode, Integer> elm = q.poll();
      TreeNode curr = elm.getKey();
      int level = elm.getValue();

      if (isLeaf(curr)) {
        return level;
      }

      if (curr.left != null) {
        q.add(new SimpleEntry<TreeNode, Integer>(curr.left, level + 1));
      }

      if (curr.right != null) {
        q.add(new SimpleEntry<TreeNode, Integer>(curr.right, level + 1));
      }
    }

    // never reach here.
    return -1;
  }

  private boolean isLeaf(TreeNode node) {
    return (node.left == null && node.right == null);
  }
}
