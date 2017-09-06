package com.leetcode.test.solution;

import com.leetcode.common.TreeNode;
import com.leetcode.main.solution.MaximumBinaryTree;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class TestMaximumBinaryTree {

  private static MaximumBinaryTree soln;

  @BeforeClass
  public static void setUp() {
    soln = new MaximumBinaryTree();
  }

  @Test
  public void testMaximumBinaryTree() {
    int[] nums = {3,2,1,6,0,5};
    TreeNode root = soln.constructMaximumBinaryTree(nums);

    Assert.assertEquals(6, root.val);
    Assert.assertEquals(3, root.left.val);
    Assert.assertEquals(2, root.left.right.val);
    Assert.assertEquals(1, root.left.right.right.val);
    Assert.assertEquals(5, root.right.val);
    Assert.assertEquals(0, root.right.left.val);
  }

}
