// https://leetcode.com/problems/unique-binary-search-trees-ii/
// Status = AC

package com.leetcode.main.solution;

import com.leetcode.common.TreeNode;
import java.util.ArrayList;
import java.util.List;

public class UniqueBSTII {

  public List<TreeNode> generateTrees(int n) {
    if(n <= 0) {
      return new ArrayList<>();
    }

    return generateSubTrees(1, n);
  }

  private List<TreeNode> generateSubTrees(int s, int e) {
    List<TreeNode> res = new ArrayList<>();

    if (s > e) {
      res.add(null); // empty tree
      return res;
    }

    for (int i = s; i <= e; i++) {
      List<TreeNode> leftSubTrees = generateSubTrees(s, i - 1);
      List<TreeNode> rightSubTrees = generateSubTrees(i + 1, e);

      for (TreeNode l : leftSubTrees) {
        for (TreeNode r : rightSubTrees) {
          TreeNode root = new TreeNode(i);
          root.left = l;
          root.right = r;

          res.add(root);
        }
      }
    }

    return res;
  }
}
