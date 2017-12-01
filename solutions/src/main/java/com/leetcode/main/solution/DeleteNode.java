// https://leetcode.com/problems/delete-node-in-a-linked-list/description/
// status = AC

package com.leetcode.main.solution;

import com.leetcode.common.ListNode;

public class DeleteNode {
  public void deleteNode(ListNode node) {
    ListNode tmp = node.next;
    node.val = tmp.val;
    node.next = tmp.next;

    // the below step is not necessary, since tmp doesn't have anymore references.
    System.gc();
  }
}
