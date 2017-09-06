// https://leetcode.com/problems/maximum-binary-tree/description/
// Status = Accepted

package com.leetcode.main.solution;

import com.leetcode.common.TreeNode;
import java.util.Arrays;
import java.util.stream.IntStream;

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
    return IntStream.range(0, nums.length).reduce(0, (a,b) -> nums[a] < nums[b] ? b : a);
  }
}
