// https://leetcode.com/problems/merge-two-sorted-lists/description/
// Status = AC
package com.leetcode.main.solution;

import com.leetcode.common.ListNode;

public class MergeTwoSortedLists {

  public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
    ListNode newHead = new ListNode(-1);
    ListNode newTail = newHead;

    while (l1 != null && l2 != null) {
      if (l1.val < l2.val) {
        newTail.next = l1;
        l1 = l1.next;
      } else {
        newTail.next = l2;
        l2 = l2.next;
      }

      newTail = newTail.next;
    }

    if (l1 != null) {
      newTail.next = l1;
    }

    if (l2 != null) {
      newTail.next = l2;
    }

    return newHead.next;
  }
}
