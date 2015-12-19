package com.leetcode.test.solution;

import com.leetcode.common.TreeNode;
import com.leetcode.main.solution.LCABst;
import junit.framework.Assert;
import org.junit.Test;

public class TestLCABst {
  /**
   * Construct sample tree.
   * 4
   * /   \
   * 2     7
   * / \   / \
   * 1   3 6   9
   */

  @Test
  public void testLCABst() {
    TreeNode root = new TreeNode(4);
    root.left = new TreeNode(2);
    root.right = new TreeNode(7);
    root.left.left = new TreeNode(1);
    root.left.right = new TreeNode(3);
    root.right.left = new TreeNode(6);
    root.right.right = new TreeNode(9);

    LCABst soln = new LCABst();
    TreeNode ancestor = soln.lowestCommonAncestor(root, new TreeNode(2), new TreeNode(9));
    Assert.assertEquals(4, ancestor.val);
  }
}
