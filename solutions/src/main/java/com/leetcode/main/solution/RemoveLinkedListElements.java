/**
 * https://leetcode.com/problems/remove-linked-list-elements/
 * Status = Accepted
 */

package com.leetcode.main.solution;

import com.leetcode.common.ListNode;

public class RemoveLinkedListElements {
  public ListNode removeElements(ListNode head, int val) {
    if (head == null) {
      return null;
    }

    ListNode prev = null;
    ListNode curr = head;

    while (curr != null) {
      if (curr.val == val) {
        // when val is the first node in the list.
        if (curr == head) {
          head = head.next;
        } else {
          // when val is the middle of the list or at the end of the list.
          prev.next = curr.next;
          curr = prev.next;
          continue;
        }
      }
      prev = curr;
      curr = curr.next;
    }
    return head;
  }
}
