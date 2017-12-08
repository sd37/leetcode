// https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/description/
// Status = AC

package com.leetcode.main.solution;

import com.leetcode.common.TreeNode;

public class ConvertSortedArrayToBST {

  public TreeNode sortedArrayToBST(int[] nums) {
    if (nums == null || nums.length == 0) {
      return null;
    }

    return sortedArrayToBSTUtil(nums, 0, nums.length - 1);
  }

  public TreeNode sortedArrayToBSTUtil(int[] nums, int i, int j) {
    if (i > j) {
      return null;
    }

    int mid = i + (j - i) / 2;
    TreeNode root = new TreeNode(nums[mid]);

    root.left = sortedArrayToBSTUtil(nums, i, mid - 1);
    root.right = sortedArrayToBSTUtil(nums, mid + 1, j);

    return root;
  }
}
