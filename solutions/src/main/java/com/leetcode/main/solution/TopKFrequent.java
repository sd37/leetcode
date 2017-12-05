// https://leetcode.com/problems/top-k-frequent-elements/
// Status = Accepted
package com.leetcode.main.solution;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.PriorityQueue;
import java.util.stream.Collectors;

public class TopKFrequent {

  public List<Integer> topKFrequent(int[] nums, int k) {
    Map<Integer, Integer> countMap = new HashMap<>();

    for(int x : nums) {
      countMap.put(x, countMap.getOrDefault(x, 0) + 1);
    }

    PriorityQueue<Entry<Integer, Integer>> pq = new PriorityQueue<>(
        new Comparator<Entry<Integer, Integer>>() {
          @Override
          public int compare(Entry<Integer, Integer> o1, Entry<Integer, Integer> o2) {
            return Integer.compare(o1.getValue(), o2.getValue());
          }
        });

    for (Entry<Integer, Integer> kv : countMap.entrySet()) {
      pq.add(kv);
      if(pq.size() > k) {
        pq.poll();
      }
    }

    return pq.stream().mapToInt(x -> x.getKey()).boxed().collect(Collectors.toList());
  }
}
