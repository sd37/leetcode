package com.leetcode.main.solution;

import com.leetcode.common.ListNode;

public class DeleteNodeLL {
  public void deleteNode(ListNode node) {
    if (node == null) {
      return;
    }

    if (node.next == null) {
      throw new RuntimeException("Invalid input : cannot delete last node");
    }

    node.val = node.next.val;
    node.next = node.next.next;
  }
}
