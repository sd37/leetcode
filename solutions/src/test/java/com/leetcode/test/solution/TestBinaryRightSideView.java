package com.leetcode.test.solution;

import com.leetcode.common.TreeNode;
import com.leetcode.main.solution.BinaryTreeRightSideView;
import com.leetcode.main.solution.MinimumDepthOfBinaryTree;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class TestBinaryRightSideView {
    private static BinaryTreeRightSideView soln;

    @BeforeClass
    public static void setUp() {
        soln = new BinaryTreeRightSideView();
    }

    @Test
    public void testBinaryTreeRightSideView() {
        /*
         * Construct Tree.
         *    1
         *   /  \
         *  2    3
         *   \    \
         *    5    4
         *
         */
        TreeNode tree = new TreeNode(1);
        tree.left = new TreeNode(2);
        tree.right = new TreeNode(3);
        tree.left.right = new TreeNode(5);
        tree.right.right = new TreeNode(4);

        var result = soln.rightSideView(tree);
        Assert.assertNotNull(result);
    }
}
