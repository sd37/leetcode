// https://leetcode.com/problems/kth-smallest-element-in-a-sorted-matrix/description/
// Status = AC

package com.leetcode.main.solution;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class KthSmallestElement {

  class ListElement {

    private int x;
    private int listId;

    public ListElement(int x, int listId) {
      this.x = x;
      this.listId = listId;
    }
  }

  public int kthSmallest(int[][] matrix, int k) {
    if (matrix == null || matrix.length == 0) {
      return Integer.MIN_VALUE;
    }

    PriorityQueue<ListElement> pq = new PriorityQueue<>(new Comparator<ListElement>() {
      @Override
      public int compare(ListElement o1, ListElement o2) {
        return Integer.compare(o1.x, o2.x);
      }
    });

    List<Integer> head = new ArrayList<>();

    for (int r = 0; r < matrix.length; r++) {
      pq.add(new ListElement(matrix[r][0], r));
      head.add(1);
    }

    int count = 0;
    while (!pq.isEmpty()) {
      ListElement smallestElement = pq.poll();
      count++;
      if (count == k) {
        return smallestElement.x;
      }

      int nextIndex = head.get(smallestElement.listId);

      if (nextIndex < matrix[smallestElement.listId].length) {
        head.set(smallestElement.listId, nextIndex + 1);
        pq.add(new ListElement(matrix[smallestElement.listId][nextIndex], smallestElement.listId));
      }
    }

    // never reach here.
    return -1;
  }
}
