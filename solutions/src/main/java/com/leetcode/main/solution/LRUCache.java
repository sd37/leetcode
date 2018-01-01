// https://leetcode.com/problems/lru-cache/description/
// Status AC

package com.leetcode.main.solution;

import java.util.LinkedHashMap;
import java.util.Map;

public class LRUCache {

  private Map<Integer, Integer> lruMap;
  private final int CAPACITY;

  public LRUCache(int capacity) {
    CAPACITY = capacity;
    lruMap = new LinkedHashMap<Integer, Integer>(capacity, 0.75f, true) {
      protected boolean removeEldestEntry(Map.Entry eldest) {
        return size() > CAPACITY;
      }
    };
  }

  public int get(int key) {
    return lruMap.getOrDefault(key, -1);
  }

  public void put(int key, int value) {
    lruMap.put(key, value);
  }
}

/**
 * Your LRUCache object will be instantiated and called as such: LRUCache obj = new
 * LRUCache(capacity); int param_1 = obj.get(key); obj.put(key,value);
 */
