// https://leetcode.com/problems/top-k-frequent-elements/
// Status = Accepted
package com.leetcode.main.solution;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.stream.Collectors;
import javafx.util.Pair;

public class TopKFrequent {

  public List<Integer> topKFrequent(int[] nums, int k) {
    Map<Integer, Integer> countMap = new HashMap<>();

    for (int i = 0; i < nums.length; i++) {
      if (!countMap.containsKey(nums[i])) {
        countMap.put(nums[i], 0);
      }
      countMap.put(nums[i], countMap.get(nums[i]) + 1);
    }

    Queue<Pair<Integer,Integer>> pq = new PriorityQueue<>(new Comparator<Pair<Integer, Integer>>() {
      @Override
      public int compare(Pair<Integer, Integer> o1, Pair<Integer, Integer> o2) {
        if (o1.getValue() < o2.getValue()) {
          return -1;
        } else if(o1.getValue() > o2.getValue()) {
          return 1;
        } else {
          return 0;
        }
      }
    });

    for (Integer key : countMap.keySet()) {
      pq.add(new Pair<>(key, countMap.get(key)));

      if (pq.size() > k) {
        pq.poll();
      }
    }

    return pq.stream().map(p -> p.getKey()).sorted().collect(Collectors.toList());
  }
}
