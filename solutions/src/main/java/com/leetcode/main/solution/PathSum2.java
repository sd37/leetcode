// https://leetcode.com/problems/path-sum-ii/
package com.leetcode.main.solution;

import com.leetcode.common.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PathSum2 {
  public List<List<Integer>> pathSum(TreeNode root, int sum) {
    List<List<TreeNode>> root2LeafPaths = new ArrayList<>();
    List<List<Integer>> ans = new ArrayList<>();

    if (root == null) {
      return ans;
    }

    pathSumUtil(root, root2LeafPaths, Collections.unmodifiableList(new ArrayList<TreeNode>()));

    for (List<TreeNode> p : root2LeafPaths) {
      if (sumPath(p) == sum) {
        List<Integer> tmp = new ArrayList<>();
        for (TreeNode x : p) {
          tmp.add(x.val);
        }
        ans.add(tmp);
      }
    }

    return ans;
  }

  private void pathSumUtil(TreeNode root, List<List<TreeNode>> root2LeafPath,
      List<TreeNode> path) {
    if (root == null) {
      return;
    }

    List<TreeNode> copyPath = new ArrayList<>(path);
    copyPath.add(root);

    if (root.left == null && root.right == null) {
      root2LeafPath.add(copyPath);
      return;
    }

    pathSumUtil(root.left, root2LeafPath, Collections.unmodifiableList(copyPath));
    pathSumUtil(root.right, root2LeafPath, Collections.unmodifiableList(copyPath));
  }

  private int sumPath(List<TreeNode> path) {
    if (path == null) {
      return 0;
    }

    int s = 0;
    for (TreeNode t : path) {
      s += t.val;
    }

    return s;
  }
}
