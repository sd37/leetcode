// Status = AC
// https://leetcode.com/problems/binary-tree-paths/description/
package com.leetcode.main.solution;

import com.leetcode.common.TreeNode;
import java.util.ArrayList;
import java.util.List;

public class BinaryTreePaths {

  public List<String> binaryTreePaths(TreeNode root) {
    List<String> result = new ArrayList<>();

    if (root == null) {
      return result;
    }

    binaryTreePathHelper(root, result, "");
    return result;
  }

  public void binaryTreePathHelper(TreeNode root, List<String> result, String curr) {
    if (root.left == null && root.right == null) {
      result.add(curr + root.val);
      return;
    }

    curr = curr + root.val;

    if (root.left != null) {
      binaryTreePathHelper(root.left, result, curr + "->");
    }

    if (root.right != null) {
      binaryTreePathHelper(root.right, result, curr + "->");
    }
  }
}
