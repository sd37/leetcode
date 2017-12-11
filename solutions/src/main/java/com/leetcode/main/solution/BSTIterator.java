// https://leetcode.com/problems/binary-search-tree-iterator/description/
// Status = AC
package com.leetcode.main.solution;

import com.leetcode.common.TreeNode;
import java.util.Stack;

public class BSTIterator {
  private Stack<TreeNode> st;

  public BSTIterator(TreeNode root) {
    st = new Stack<>();
    pushLeftMost(root);
  }

  /** @return whether we have a next smallest number */
  public boolean hasNext() {
    return !st.isEmpty();
  }

  /** @return the next smallest number */
  public int next() {
    TreeNode res = st.pop();
    pushLeftMost(res.right);
    return res.val;
  }

  private void pushLeftMost(TreeNode root) {
    if(root == null) {
      return;
    }

    while(root != null) {
      st.push(root);
      root = root.left;
    }
  }
}
