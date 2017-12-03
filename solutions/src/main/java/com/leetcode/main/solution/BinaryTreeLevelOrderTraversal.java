/**
 * https://leetcode.com/problems/binary-tree-level-order-traversal/
 * Status = Accepted
 */
package com.leetcode.main.solution;

import com.leetcode.common.TreeNode;

import java.util.*;
import java.util.AbstractMap.SimpleEntry;
import java.util.Map.Entry;

public class BinaryTreeLevelOrderTraversal {

  public List<List<Integer>> levelOrder(TreeNode root) {
    List<List<Integer>> levelOrder = new ArrayList<>();

    if (root == null) {
      return levelOrder;
    }

    Deque<Entry<TreeNode, Integer>> q = new ArrayDeque<>();
    Map<Integer, List<Integer>> levelMap = new TreeMap<>();

    q.add(new SimpleEntry<TreeNode, Integer>(root, 0));
    levelMap.put(0, Arrays.asList(root.val));

    while(!q.isEmpty()) {
      Entry<TreeNode, Integer> curr = q.poll();
      int nextLevel = curr.getValue() + 1;

      if(curr.getKey().left != null) {
        q.add(new SimpleEntry<TreeNode, Integer>(curr.getKey().left, nextLevel));
        if(!levelMap.containsKey(nextLevel)) {
          levelMap.put(nextLevel, new ArrayList<>());
        }
        levelMap.get(nextLevel).add(curr.getKey().left.val);
      }

      if(curr.getKey().right != null) {
        q.add(new SimpleEntry<TreeNode, Integer>(curr.getKey().right, nextLevel));
        if(!levelMap.containsKey(nextLevel)) {
          levelMap.put(nextLevel, new ArrayList<>());
        }
        levelMap.get(nextLevel).add(curr.getKey().right.val);
      }
    }

    for(int l : levelMap.keySet()) {
      levelOrder.add(levelMap.get(l));
    }

    return levelOrder;
  }
}
