// https://leetcode.com/problems/average-of-levels-in-binary-tree/description/
// Status = AC

package com.leetcode.main.solution;

import com.leetcode.common.TreeNode;
import java.util.AbstractMap.SimpleEntry;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class AverageOfLevels {
  public List<Double> averageOfLevels(TreeNode root) {
    List<Double> avgOfLevels = new ArrayList<>();
    if (root == null) {
      return avgOfLevels;
    }

    List<List<Integer>> lOrder = new ArrayList<>();
    Map<Integer, List<Integer>> levelMap = new HashMap<>();

    Deque<Entry<TreeNode, Integer>> q = new ArrayDeque<>();

    q.add(new SimpleEntry<TreeNode, Integer>(root, 0));

    while (!q.isEmpty()) {
      Entry<TreeNode, Integer> elm = q.poll();
      TreeNode curr = elm.getKey();
      int level = elm.getValue();

      if (!levelMap.containsKey(level)) {
        levelMap.put(level, new ArrayList<>());
      }
      levelMap.get(level).add(curr.val);

      if (curr.left != null) {
        q.add(new SimpleEntry<TreeNode, Integer>(curr.left, level + 1));
      }

      if (curr.right != null) {
        q.add(new SimpleEntry<TreeNode, Integer>(curr.right, level + 1));
      }
    }

    for (int i = 0; i < levelMap.size(); i++) {
      List<Integer> tmpList = levelMap.get(i);
      avgOfLevels.add(tmpList.stream().mapToDouble(x -> x).average().getAsDouble());
    }

    return avgOfLevels;
  }
}

