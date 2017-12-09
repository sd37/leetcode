// https://leetcode.com/problems/top-k-frequent-words/description/
// Status = AC
package com.leetcode.main.solution;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.PriorityQueue;
import java.util.stream.Collectors;

public class TopKFrequentWords {
  public List<String> topKFrequent(String[] words, int k) {
    if(words == null || words.length == 0) {
      return new ArrayList<>();
    }

    PriorityQueue<Entry<String, Integer>> pq = new PriorityQueue<>(
        new Comparator<Entry<String, Integer>>() {
          @Override
          public int compare(Entry<String, Integer> o1, Entry<String, Integer> o2) {
            int x = Integer.compare(o1.getValue(), o2.getValue());
            if(x != 0) {
              return x;
            }

            // this is the most imp line, because we want to lexicographically smaller one to remain.
            return o2.getKey().compareTo(o1.getKey());
          }
        });

    Map<String, Integer> countMap = new HashMap<>();

    for(String w : words) {
      countMap.put(w, countMap.getOrDefault(w, 0) + 1);
    }

    for(Entry<String, Integer> kv : countMap.entrySet()) {
      pq.add(kv);
      if(pq.size() > k) {
        pq.poll();
      }
    }

    return pq.stream().sorted(new Comparator<Entry<String, Integer>>() {
      @Override
      public int compare(Entry<String, Integer> o1, Entry<String, Integer> o2) {
        int x = Integer.compare(o2.getValue(), o1.getValue());
        if(x != 0) {
          return x;
        }

        return o1.getKey().compareTo(o2.getKey());
      }
    }).map(x -> x.getKey()).collect(Collectors.toList());
  }
}
