package com.leetcode.test.solution;

import com.leetcode.common.TreeNode;
import com.leetcode.main.solution.MaximumDepthOfBinaryTree;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class TestMaximumDepthOfBinaryTree {
  private static MaximumDepthOfBinaryTree soln;

  @BeforeClass
  public static void setUp() {
    soln = new MaximumDepthOfBinaryTree();
  }

  @Test
  public void testMaxDepth() {
    /**
     * Construct Tree.
     *    2
     *  /   \
     * 1     3
     *      /  \
     *     4    6
     *    /
     *   5
     */
    TreeNode tree = new TreeNode(2);
    tree.left = new TreeNode(1);
    tree.right = new TreeNode(3);
    tree.right.left = new TreeNode(4);
    tree.right.left.left = new TreeNode(5);
    tree.right.right = new TreeNode(6);

    Assert.assertEquals(4, soln.maxDepth(tree));
  }
}
