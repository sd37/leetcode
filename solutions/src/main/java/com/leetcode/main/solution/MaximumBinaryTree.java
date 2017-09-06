// https://leetcode.com/problems/maximum-binary-tree/description/
// Status = Accepted

package com.leetcode.main.solution;

import com.leetcode.common.TreeNode;
import java.util.Arrays;

public class MaximumBinaryTree {
  public TreeNode constructMaximumBinaryTree(int[] nums) {
    if (nums.length == 0) {
      return null;
    }

    if (nums.length == 1) {
      return new TreeNode(nums[0]);
    }

    int maxIndex = getMaxIndex(nums);
    int maxNum = nums[maxIndex];
    TreeNode root = new TreeNode(maxNum);

    root.left = constructMaximumBinaryTree(Arrays.copyOfRange(nums, 0, maxIndex));
    root.right = constructMaximumBinaryTree(Arrays.copyOfRange(nums, maxIndex + 1, nums.length));
    return root;
  }

  private int getMaxIndex(int[] nums) {
    int maxIndex = 0;

    for (int i = 0; i < nums.length; i++) {
      if (nums[maxIndex] < nums[i]) {
        maxIndex = i;
      }
    }

    return maxIndex;
  }
}
