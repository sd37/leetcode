// https://leetcode.com/contest/leetcode-weekly-contest-50/problems/map-sum-pairs/
// status = AC

package com.leetcode.main.solution;

import java.util.HashMap;
import java.util.Map;

public class MapSum {

  /**
   * Initialize your data structure here.
   */

  private Map<String, Integer> mapSum;

  public MapSum() {
    mapSum = new HashMap<>();
  }

  public void insert(String key, int val) {
    assert key != null;
    mapSum.put(key, val);
  }

  public int sum(String prefix) {
    int total = mapSum.keySet().stream().filter(s -> s.startsWith(prefix))
        .mapToInt(s -> mapSum.get(s)).sum();
    return total;
  }
}
