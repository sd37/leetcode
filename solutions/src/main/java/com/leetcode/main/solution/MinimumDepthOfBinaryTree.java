/**
 * https://leetcode.com/problems/minimum-depth-of-binary-tree/
 * Status = Accepted
 */
package com.leetcode.main.solution;

import com.leetcode.common.TreeNode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class MinimumDepthOfBinaryTree {
  public int minDepth(TreeNode root) {
    if (root == null) {
      return 0;
    }

    Queue<TreeNode> q = new LinkedList<>();
    Map<TreeNode, Integer> nodeLevel = new HashMap<>();

    q.add(root);
    nodeLevel.put(root, 1);

    int minDepth = 0;

    while (!q.isEmpty()) {
      TreeNode curr = q.poll();

      if (isLeaf(curr)) {
        minDepth = nodeLevel.get(curr);
        break;
      }

      if (curr.left != null) {
        q.add(curr.left);
        nodeLevel.put(curr.left, nodeLevel.get(curr) + 1);
      }

      if (curr.right != null) {
        q.add(curr.right);
        nodeLevel.put(curr.right, nodeLevel.get(curr) + 1);
      }
    }

    return minDepth;
  }

  private boolean isLeaf(TreeNode node) {
    if (node.left == null && node.right == null) {
      return true;
    }
    return false;
  }
}
