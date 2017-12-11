// https://leetcode.com/problems/binary-tree-inorder-traversal/description/
// Status = AC
package com.leetcode.main.solution;

import com.leetcode.common.TreeNode;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinaryInorderTraversal {
  public List<Integer> inorderTraversal(TreeNode root) {
    List<Integer> inorder = new ArrayList<>();

    if(root == null) {
      return inorder;
    }

    Stack<TreeNode> st = new Stack<>();

    pushLeftMostAll(root, st);

    while(!st.isEmpty()) {
      TreeNode curr = st.pop();
      inorder.add(curr.val);
      pushLeftMostAll(curr.right, st);
    }

    return inorder;
  }

  private void pushLeftMostAll(TreeNode root, Stack<TreeNode> st) {
    while(root != null) {
      st.push(root);
      root = root.left;
    }
  }
}
