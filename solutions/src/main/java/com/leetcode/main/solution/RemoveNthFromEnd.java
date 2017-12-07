// https://leetcode.com/problems/remove-nth-node-from-end-of-list/description/
// Status = AC

package com.leetcode.main.solution;

import com.leetcode.common.ListNode;

public class RemoveNthFromEnd {
  public ListNode removeNthFromEnd(ListNode head, int n) {
    if (head == null) {
      return head;
    }

    ListNode p1 = head;
    ListNode p2 = head;

    if (p2.next == null) {
      head = null;
      return head;
    }

    // create a diff of n nodes
    while (p2 != null && n != 0) {
      p2 = p2.next;
      n--;
    }

    if(n > 0) {
      // no deletion can be performed.
      return head;
    }

    if(p2 == null) {
      head = head.next;
    } else{
      // move both pointers together
      while (p2 != null && p2.next != null) {
        p1 = p1.next;
        p2 = p2.next;
      }

      p1.next = p1.next.next;
    }

    return head;
  }
}
