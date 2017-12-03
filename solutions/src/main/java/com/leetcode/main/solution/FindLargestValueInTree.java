// https://leetcode.com/problems/find-largest-value-in-each-tree-row/description/
// Status = AC

package com.leetcode.main.solution;

import com.leetcode.common.TreeNode;
import java.util.AbstractMap.SimpleEntry;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

public class FindLargestValueInTree {

  public List<Integer> largestValues(TreeNode root) {
    List<Integer> levelMax = new ArrayList<>();

    if (root == null) {
      return levelMax;
    }

    Deque<Entry<TreeNode, Integer>> q = new ArrayDeque<>();
    Map<Integer, Integer> levelMap = new TreeMap<>();

    q.add(new SimpleEntry<TreeNode, Integer>(root, 0));
    levelMap.put(0, root.val);

    while (!q.isEmpty()) {
      Entry<TreeNode, Integer> curr = q.poll();
      int nextLevel = curr.getValue() + 1;

      if (curr.getKey().left != null) {
        q.add(new SimpleEntry<TreeNode, Integer>(curr.getKey().left, nextLevel));

        levelMap.put(nextLevel,
            Math.max(levelMap.getOrDefault(nextLevel, Integer.MIN_VALUE), curr.getKey().left.val));
      }

      if (curr.getKey().right != null) {
        q.add(new SimpleEntry<TreeNode, Integer>(curr.getKey().right, nextLevel));

        levelMap.put(nextLevel,
            Math.max(levelMap.getOrDefault(nextLevel, Integer.MIN_VALUE), curr.getKey().right.val));
      }
    }

    for(int l : levelMap.keySet()) {
      levelMax.add(levelMap.get(l));
    }

    return levelMax;
  }
}
