/**
 * https://leetcode.com/problems/binary-tree-level-order-traversal/
 * Status = Accepted
 */
package com.leetcode.main.solution;

import com.leetcode.common.TreeNode;

import java.util.*;

public class BinaryTreeLevelOrderTraversal {
  public List<List<Integer>> levelOrder(TreeNode root) {
    List<List<Integer>> levelOrder = new ArrayList<List<Integer>>();

    if (root == null) {
      return levelOrder;
    }

    Map<Integer, List<Integer>> levelNodes = new TreeMap<Integer, List<Integer>>();
    Map<TreeNode, Integer> nodeLevel = new HashMap<TreeNode, Integer>();

    Queue<TreeNode> q = new LinkedList<TreeNode>();
    q.add(root);
    nodeLevel.put(root, 0);
    levelNodes.put(nodeLevel.get(root), new ArrayList<Integer>());
    levelNodes.get(nodeLevel.get(root)).add(root.val);

    while (!q.isEmpty()) {
      TreeNode curr = q.poll();
      int nextLevel = nodeLevel.get(curr) + 1;
      if (curr.left != null) {
        q.add(curr.left);
        nodeLevel.put(curr.left, nextLevel);
        if (!levelNodes.containsKey(nextLevel)) {
          levelNodes.put(nextLevel, new ArrayList<Integer>());
        }
        levelNodes.get(nextLevel).add(curr.left.val);
      }

      if (curr.right != null) {
        q.add(curr.right);
        nodeLevel.put(curr.right, nextLevel);
        if (!levelNodes.containsKey(nextLevel)) {
          levelNodes.put(nextLevel, new ArrayList<Integer>());
        }
        levelNodes.get(nextLevel).add(curr.right.val);
      }
    }

    for (Integer i : levelNodes.keySet()) {
      levelOrder.add(levelNodes.get(i));
    }
    return levelOrder;
  }
}
