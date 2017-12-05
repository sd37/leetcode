// https://leetcode.com/problems/sort-characters-by-frequency/description/
// Status = AC

package com.leetcode.main.solution;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class SortCharByFreq {

  public String frequencySort(String s) {
    if (s == null || s.length() == 0) {
      return s;
    }

    Map<Character, Integer> countMap = new HashMap<>();

    for (int i = 0; i < s.length(); i++) {
      char ch = s.charAt(i);
      countMap.put(ch, countMap.getOrDefault(ch, 0) + 1);
    }

    List<Entry<Character, Integer>> keySetList = new ArrayList<>(countMap.entrySet());

    Collections.sort(keySetList, new Comparator<Entry<Character, Integer>>() {
      @Override
      public int compare(Entry<Character, Integer> x, Entry<Character, Integer> y) {
        return Integer.compare(y.getValue(), x.getValue());
      }
    });

    StringBuilder res = new StringBuilder("");

    for (Entry<Character, Integer> kv : keySetList) {
      res.append(repeatCharN(kv.getKey(), kv.getValue()));
    }

    return new String(res);
  }

  private StringBuilder repeatCharN(char ch, int n) {
    StringBuilder res = new StringBuilder("");
    for (int i = 0; i < n; i++) {
      res.append(ch);
    }
    return res;
  }
}
