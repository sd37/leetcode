package com.leetcode.main.solution;

import java.util.*;

public class CanWinNim {
  public boolean canWinNim(int n) {
    if(n % 4 == 0) {
      return false;
    }
    return true;
  }

  public boolean canWinNimSlow(int n) {
    if (n <= 3) {
      return true;
    }

    LinkedList<Boolean> q = new LinkedList<>();
    for (int i = 0; i < 3; i++) {
      q.add(true);
    }

    for (int i = 4; i <= n; i++) {
      boolean res = !(q.get(0) && q.get(1) && q.get(2));
      q.removeFirst();
      q.add(res);
    }

    return q.get(2);
  }
}
