// https://leetcode.com/problems/binary-tree-right-side-view/description/
// Status = AC
/*
Given the root of a binary tree, imagine yourself standing on the right side of it, return the values of the nodes you can see ordered from top to bottom.



Example 1:


Input: root = [1,2,3,null,5,null,4]
Output: [1,3,4]
Example 2:

Input: root = [1,null,3]
Output: [1,3]
Example 3:

Input: root = []
Output: []


Constraints:

The number of nodes in the tree is in the range [0, 100].
-100 <= Node.val <= 100
 */
package com.leetcode.main.solution;

import com.leetcode.common.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeRightSideView {
    class Pair {
        public TreeNode node;
        public int level;

        public Pair(TreeNode node, int level) {
            this.node = node;
            this.level = level;
        }
    }

    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> rightView = new ArrayList<>();
        if (root == null) {
            return rightView;
        }

        List<List<Integer>> levelOrder = new ArrayList<>();
        levelOrderUtil(root, levelOrder);

        // right side view
        for (List<Integer> level : levelOrder) {
            var lastRowElement = level.get(level.size() - 1);
            rightView.add(lastRowElement);
        }

        return rightView;
    }

    private void levelOrderUtil(TreeNode root, List<List<Integer>> levelOrder) {
        if (root == null) {
            return;
        }

        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(root, 0));

        while (!q.isEmpty()) {
            var curr = q.poll();
            var node = curr.node;
            var level = curr.level;

            if (level >= levelOrder.size()) {
                levelOrder.add(new ArrayList<>());
            }

            levelOrder.get(level).add(node.val);

            if (node.left != null) {
                q.add(new Pair(node.left, level + 1));
            }

            if (node.right != null) {
                q.add(new Pair(node.right, level + 1));
            }
        }
    }
}
