// https://leetcode.com/problems/group-anagrams/description/
// Status = AC

package com.leetcode.main.solution;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class GroupAnagrams {
  public List<List<String>> groupAnagrams(String[] strs) {
    if(strs == null || strs.length == 0) {
      return null;
    }

    Map<String, List<String>> groupMap = new HashMap<>();

    List<List<String>> res = new ArrayList<>();

    for (String str : strs) {
      String sortedS = sortCharString(str);
      if(!groupMap.containsKey(sortedS)) {
        groupMap.put(sortedS, new ArrayList<>());
      }

      groupMap.get(sortedS).add(str);
    }

    for(Entry<String, List<String>> kv : groupMap.entrySet()) {
      res.add(kv.getValue());
    }

    return res;
  }

  private String sortCharString(String s) {
    if(s == null) {
      return s;
    }

    char[] charS = s.toCharArray();
    Arrays.sort(charS);

    return new String(charS);
  }
}
