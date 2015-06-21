package com.leetcode.test.solution;

import com.leetcode.common.TreeNode;
import com.leetcode.main.solution.SameTree;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class TestSameTree {
  private static SameTree soln;

  @BeforeClass
  public static void setUp() {
    soln = new SameTree();
  }

  @Test
  public void testSameTree() {
    // construct two trees.

    TreeNode tree1 = new TreeNode(2);
    tree1.left = new TreeNode(1);
    tree1.right = new TreeNode(3);

    TreeNode tree2 = new TreeNode(2);
    tree2.left = new TreeNode(1);
    tree2.right = new TreeNode(3);

    Assert.assertTrue(soln.isSameTree(tree1, tree2));
  }
}
