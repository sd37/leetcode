// https://leetcode.com/problems/reverse-linked-list/description/
// Status = AC
package com.leetcode.main.solution;

import com.leetcode.common.ListNode;

public class ReverseLinkedList {
  public ListNode reverseList(ListNode head) {
    if(head == null) {
      return null;
    }

    ListNode prev = null;
    ListNode curr = head;

    while(curr != null) {
      ListNode tmp = curr.next;
      curr.next = prev;
      prev = curr;
      curr = tmp;
    }

    return prev;
  }
}
