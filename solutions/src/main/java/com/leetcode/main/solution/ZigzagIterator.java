// https://leetcode.com/problems/zigzag-iterator/description/
// Status = AC

package com.leetcode.main.solution;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

public class ZigzagIterator {
  Deque<Iterator<Integer>> q;

  public ZigzagIterator(List<Integer> v1, List<Integer> v2) {
    q = new ArrayDeque<>();

    if (!v1.isEmpty()) {
      q.add(v1.iterator());
    }

    if (!v2.isEmpty()) {
      q.add(v2.iterator());
    }
  }

  public int next() {
    if (q.isEmpty()) {
      throw new NoSuchElementException("Empty List!");
    }

    Iterator<Integer> curr = q.poll();

    int res = curr.next();

    if(curr.hasNext()) {
      q.add(curr);
    }

    return res;
  }

  public boolean hasNext() {
    return !q.isEmpty();
  }
}

/**
 * Your ZigzagIterator object will be instantiated and called as such: ZigzagIterator i = new
 * ZigzagIterator(v1, v2); while (i.hasNext()) v[f()] = i.next();
 */

/*
v1 = [1, 2]
v2 = [3, 4, 5, 6]

Output:
[1, 3, 2, 4, 5, 6]
 */