package com.leetcode.test.solution;

import com.leetcode.common.TreeNode;
import com.leetcode.main.solution.MinimumDepthOfBinaryTree;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class TestMinimumDepthOfBinaryTree {
  private static MinimumDepthOfBinaryTree soln;

  @BeforeClass
  public static void setUp() {
    soln = new MinimumDepthOfBinaryTree();
  }

  @Test
  public void testMinDepth() {
    /**
     * Construct Tree.
     *    2
     *      \
     *       3
     *      /  \
     *     4    6
     *    /
     *   5
     */
    TreeNode tree = new TreeNode(2);
    tree.right = new TreeNode(3);
    tree.right.left = new TreeNode(4);
    tree.right.left.left = new TreeNode(5);
    tree.right.right = new TreeNode(6);

    Assert.assertEquals(3, soln.minDepth(tree));
  }
}
