package com.leetcode.test.solution;

import com.leetcode.common.TreeNode;
import com.leetcode.main.solution.InvertBinaryTree;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;


public class TestInvertBinaryTree {
  private static InvertBinaryTree soln;

  @BeforeClass
  public static void setUp() {
    soln = new InvertBinaryTree();
  }

  @Test
  public void testInvertBinaryTree() {
    /**
     * Construct sample tree.
     *      4
     *    /   \
     *   2     7
     *  / \   / \
     * 1   3 6   9
     */
    TreeNode root = new TreeNode(4);
    root.left = new TreeNode(2);
    root.right = new TreeNode(7);
    root.left.left = new TreeNode(1);
    root.left.right = new TreeNode(3);
    root.right.left = new TreeNode(6);
    root.right.right = new TreeNode(9);

    TreeNode rootInverted = soln.invertTree(root);

    /**
     * Inverted tree.
     *      4
     *    /   \
     *   7     2
     *  / \   / \
     * 9   6 3   1
     *
     */

    Assert.assertEquals(4, rootInverted.val);
    Assert.assertEquals(2, rootInverted.right.val);
    Assert.assertEquals(7, rootInverted.left.val);
    Assert.assertEquals(1, rootInverted.right.right.val);
    Assert.assertEquals(3, rootInverted.right.left.val);
    Assert.assertEquals(6, rootInverted.left.right.val);
    Assert.assertEquals(9, rootInverted.left.left.val);
  }
}
