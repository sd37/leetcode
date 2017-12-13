// https://leetcode.com/problems/linked-list-cycle/description/
// Status = AC

package com.leetcode.main.solution;

import com.leetcode.common.ListNode;

public class LinkedListCycle {
  public boolean hasCycle(ListNode head) {
    if(head == null) {
      return false;
    }

    ListNode slow = head;
    ListNode fast = head.next;

    while(true) {
      if(fast == null || fast.next == null) {
        return false;
      }

      if(fast == slow) {
        return true;
      }

      slow = slow.next;
      fast = fast.next.next;
    }
  }
}
