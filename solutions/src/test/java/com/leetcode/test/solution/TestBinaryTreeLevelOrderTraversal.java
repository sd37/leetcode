package com.leetcode.test.solution;

import com.leetcode.common.TreeNode;
import com.leetcode.main.solution.BinaryTreeLevelOrderTraversal;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class TestBinaryTreeLevelOrderTraversal {
  private static BinaryTreeLevelOrderTraversal soln;

  @BeforeClass
  public static void setUp() {
    soln = new BinaryTreeLevelOrderTraversal();
  }

  @Test
  public void testLevelOrder() {
    /**
     *     3
     *    /  \
     *   9   20
     *  /  \
     * 5    7
     */

    TreeNode root = new TreeNode(3);
    root.left = new TreeNode(9);
    root.right = new TreeNode(20);
    root.left.left = new TreeNode(15);
    root.left.right = new TreeNode(7);
    root.right = new TreeNode(20);

    List<List<Integer>> levelOrder = soln.levelOrder(root);

    List<Integer> l1 = new ArrayList<>();
    l1.add(3);

    List<Integer> l2 = new ArrayList<>();
    l2.add(9);
    l2.add(20);

    List<Integer> l3 = new ArrayList<>();
    l3.add(15);
    l3.add(7);

    Assert.assertEquals(3, levelOrder.size());
    Assert.assertEquals(l1, levelOrder.get(0));
    Assert.assertEquals(l2, levelOrder.get(1));
    Assert.assertEquals(l3, levelOrder.get(2));
  }
}
