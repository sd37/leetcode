package com.leetcode.main.solution;

/**
 * https://leetcode.com/problems/binary-tree-level-order-traversal-ii/
 * Status = AC
 */

import com.leetcode.common.TreeNode;
import java.util.AbstractMap.SimpleEntry;
import java.util.*;

public class LevelOrderBottom {
  public List<List<Integer>> levelOrderBottom(TreeNode root) {
    List<List<Integer>> lOrder = new ArrayList<>();

    if (root == null) {
      return lOrder;
    }

    Map<Integer, List<Integer>> levelNodes = new TreeMap<>();

    Queue<SimpleEntry<TreeNode, Integer>> q = new ArrayDeque<>();
    q.add(new SimpleEntry<TreeNode, Integer>(root, 0));

    while(!q.isEmpty()) {
      SimpleEntry<TreeNode, Integer> curr = q.remove();
      if (!levelNodes.containsKey(curr.getValue())) {
        levelNodes.put(curr.getValue(), new ArrayList<Integer>());
      }

      levelNodes.get(curr.getValue()).add(curr.getKey().val);

      if (curr.getKey().left != null) {
        q.add(new SimpleEntry<TreeNode, Integer>(curr.getKey().left, curr.getValue() + 1));
      }

      if (curr.getKey().right != null) {
        q.add(new SimpleEntry<TreeNode, Integer>(curr.getKey().right, curr.getValue() + 1));
      }
    }

    for (Integer i : levelNodes.keySet()) {
      lOrder.add(levelNodes.get(i));
    }

    Collections.reverse(lOrder);
    return lOrder;
  }
}
