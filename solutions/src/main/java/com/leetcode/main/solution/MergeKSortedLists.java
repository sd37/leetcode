// https://leetcode.com/problems/merge-k-sorted-lists/description/
// Status = AC

package com.leetcode.main.solution;

import com.leetcode.common.ListNode;
import java.util.Comparator;
import java.util.PriorityQueue;

public class MergeKSortedLists {

  class ListElement {

    private int listId;
    private int x;

    public ListElement(int x, int listId) {
      this.listId = listId;
      this.x = x;
    }
  }

  public ListNode mergeKLists(ListNode[] lists) {
    if (lists == null || lists.length == 0) {
      return null;
    }

    ListNode newHead = null;
    ListNode lastNewHead = null;

    PriorityQueue<ListElement> pq = new PriorityQueue<>(new Comparator<ListElement>() {
      @Override
      public int compare(ListElement o1, ListElement o2) {
        return Integer.compare(o1.x, o2.x);
      }
    });

    for (int i = 0; i < lists.length; i++) {
      if (lists[i] != null) {
        pq.add(new ListElement(lists[i].val, i));
      }
    }

    while(!pq.isEmpty()) {
      ListElement smallestElement = pq.poll();
      ListNode tmp = new ListNode(smallestElement.x);

      if(newHead == null) {
        newHead = tmp;
        lastNewHead = newHead;
      } else {
        lastNewHead.next = tmp;
        lastNewHead = tmp;
      }

      lists[smallestElement.listId] = lists[smallestElement.listId].next;

      if(lists[smallestElement.listId] != null) {
        pq.add(new ListElement(lists[smallestElement.listId].val, smallestElement.listId));
      }
    }

    return newHead;
  }
}
